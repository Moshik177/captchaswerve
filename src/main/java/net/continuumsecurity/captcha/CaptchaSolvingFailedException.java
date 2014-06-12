package net.continuumsecurity.captcha;

/**
 * Created by stephen on 18/03/2014.
 */
public class CaptchaSolvingFailedException extends Exception {
    public CaptchaSolvingFailedException() {
    }

    public CaptchaSolvingFailedException(String message) {
        super(message);
    }
}
