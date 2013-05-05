package net.continuumsecurity.caption;

import java.io.File;

public interface ISolveCaptcha {
	public String solveFromUrl(String url) throws Exception;
	public String solveFromFile(File file) throws Exception;
}
