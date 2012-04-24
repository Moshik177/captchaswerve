// Copyright (C) 2009

package net.continuumsecurity.captcha.caption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class for frequent MD5 operations  
 * @author 
 *
 */
public class MD5Helper {
	/**
	 * Returns MD5 string hash 
	 * @param str Input string
	 * @return MD5 string 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getMD5StringHash(String str) throws UnsupportedEncodingException {
		String res = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(str.getBytes("utf8"));
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {}
        return res;
    }
}
