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
		assertEquals("7T8uGr",solver.solveFromUrl("https://c5.ah.yahoo.com/img/ws_hsF98vB0rbP4tR1swpuys6EZ7z9C71ZPBXuwlU7yjSRXBbtdvudPwcrIQQol2x2ShII9eBfYlPoLsecthekeNeZqjdzSjfdR4rJ8Jm1BSkxesYUgVM0nbBjBrqB0cwlTd.atbKYnVEGQ.jpg"));
	}

}
