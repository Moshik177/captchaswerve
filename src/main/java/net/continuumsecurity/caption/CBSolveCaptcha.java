package net.continuumsecurity.caption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import net.continuumsecurity.captcha.caption.CaptchaSolver;

public class CBSolveCaptcha implements ISolveCaptcha {
	public final static String CHARSET = "UTF-8";
	private CaptchaSolver solver;

	public CBSolveCaptcha() {
		solver = new CaptchaSolver();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.continuumsecurity.caption.ISolveCaptcha#solveFromUrl(java.lang.String
	 * ) Prefer to use the screenshot method because some CAPTCHAs will refresh
	 * to a new value for every request
	 */
	public String solveFromUrl(String strUrl) throws Exception {

		URL url = new URL(strUrl);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Accept-Charset", CHARSET);
		InputStream response = conn.getInputStream();

		solver.initialize();
		return (solver.solveCaptcha(response).getResult());
	}

	public String solveFromFile(File file) throws Exception {
		return solver.solveCaptcha(new FileInputStream(file)).getResult();
	}

}
