// Copyright (C) 2009

package net.continuumsecurity.captcha.caption;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Helper class for HTTP methods
 * 
 * @author
 * 
 */
class HttpHelper {
	/**
	 * Reads the URI using POST Specific to our service
	 * 
	 * @param uri
	 *            Uri
	 * @param parameters
	 *            POST parameters
	 * @param captcha
	 *            CAPTCHA image
	 * @return Uri contents
	 * @throws Exception
	 */
	public static String ReadUri(String uri,
			Dictionary<String, String> parameters, InputStream imageStream)
			throws Exception {
		URL url = new URL(uri);

		ByteArrayOutputStream memStm = new ByteArrayOutputStream();

		Enumeration<String> keys = parameters.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = parameters.get(key);

			memStm.write(String
					.format("-----------------------------217261477111538\r\nContent-Disposition: form-data; name=\"%s\"\r\n\r\n%s\r\n",
							key, value).getBytes("utf8"));
		}

		if (imageStream != null) {
			memStm.write("-----------------------------217261477111538\r\nContent-Disposition: form-data; name=\"file\"; filename=\"captcha.jpg\"\r\nContent-Type: image/jpeg\r\n\r\n"
					.getBytes("utf8"));
			//MemoryCacheImageOutputStream imgStm = new MemoryCacheImageOutputStream(
			//		memStm);
			//ImageIO.write((RenderedImage) captcha, "JPG", imgStm);
			for (int b; (b = imageStream.read()) != -1; ) {
                memStm.write(b);
            }
			memStm.write("\r\n-----------------------------217261477111538\r\n"
					.getBytes("utf8"));
		} else {
			memStm.write("-----------------------------217261477111538\r\n\r\n"
					.getBytes("utf8"));
		}

		memStm.flush();
		byte[] buffer = memStm.toByteArray();
		memStm.close();

		URLConnection conn = url.openConnection();

		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=---------------------------217261477111538");
		conn.setRequestProperty("Content-Length",
				Integer.toString(buffer.length));

		OutputStream reqStream = conn.getOutputStream();
		reqStream.write(buffer);
		reqStream.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String content = "";
		String line;

		while ((line = reader.readLine()) != null) {
			content += line + "\n";
		}

		return content;
	}
}
