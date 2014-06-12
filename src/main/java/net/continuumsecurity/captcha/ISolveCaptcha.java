package net.continuumsecurity.captcha;

import java.io.File;

public interface ISolveCaptcha {
	public String solve(File file) throws Exception;
}
