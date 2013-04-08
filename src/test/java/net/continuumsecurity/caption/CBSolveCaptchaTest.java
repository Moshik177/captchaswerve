package net.continuumsecurity.caption;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CBSolveCaptchaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ISolveCaptcha solver = new CBSolveCaptcha();
		assertEquals("oseux3",solver.solveFromUrl("http://www.twisteddelight.org/captcha.jpg"));
	}

}
