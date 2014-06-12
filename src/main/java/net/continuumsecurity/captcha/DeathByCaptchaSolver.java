package net.continuumsecurity.captcha;

import com.DeathByCaptcha.Captcha;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;

import java.io.File;
import java.util.Properties;

/**
 * Created by stephen on 18/03/2014.
 */
public class DeathByCaptchaSolver implements ISolveCaptcha {
    String username, password;

    public DeathByCaptchaSolver(Properties properties) {
        username = (String)properties.get("username");
        password = (String)properties.get("password");
    }

    public String solve(File file) throws Exception {
        Client client = (Client) (new HttpClient(username, password));
        client.isVerbose = true;
        int iterations = 0;
        while (iterations < 3) {
            Captcha captcha = client.decode(file, 60);
            if (null != captcha) {
                return captcha.text;
            }
            iterations++;
        }
        throw new CaptchaSolvingFailedException();
    }
}
