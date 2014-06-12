package net.continuumsecurity.captcha;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class CaptchaSolverFactory {

	public static ISolveCaptcha createSolver(Properties properties) {
        String type = (String)properties.get("type");
        if ("DeathByCaptcha".equalsIgnoreCase(type)) {
            return new DeathByCaptchaSolver(properties);
        }
        throw new RuntimeException("No CAPTCHA solver found matching type: "+type);
	}



}
