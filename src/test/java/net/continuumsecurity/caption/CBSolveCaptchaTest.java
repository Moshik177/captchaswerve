package net.continuumsecurity.caption;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class CBSolveCaptchaTest {

	@Before
	public void setUp() throws Exception {
	}

	//FIXME @Test
	public void testUrl() throws Exception {
		ISolveCaptcha solver = new CBSolveCaptcha();
		assertEquals("oseux3",solver.solveFromUrl("http://www.twisteddelight.org/captcha.jpg"));
	}

	@Test
	public void testFromFile() throws Exception {
		ISolveCaptcha solver = new CBSolveCaptcha();
		assertEquals("tessestu", solver.solveFromFile(new File("captcha.jpg")));
	}
}
