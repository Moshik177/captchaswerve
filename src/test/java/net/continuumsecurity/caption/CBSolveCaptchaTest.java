package net.continuumsecurity.caption;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CBSolveCaptchaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ISolveCaptcha solver = new CBSolveCaptcha();
		assertEquals("7T8uGr",solver.solveFromUrl("http://www.google.com/recaptcha/api/image?c=03AHJ_VuskAvuLHmgyC_OPZupQKPuEdaQffKe4LDRmcWnypZHsjzh-P3w_8Wd9BkjpC3Yb9XdL8R9noFMldSOmj4oJWPExgw1j56k9krPWujcVTCX0x4QXIxu75Y5y9KDS_mnKYW0k5_782FetlL8KS0sq9vwV_0STMxIvkO45Birg_FQLOT4N1WY"));
	}

}
