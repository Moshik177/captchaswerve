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
		assertEquals("7T8uGr",solver.solveFromUrl("http://www.google.com/recaptcha/api/image?c=03AHJ_Vuv75stwxFKNM3yXnLcjmg9goF2lHVDPS8VNY5VMNARi4GLDfjjkk-LO7oiVNT7s2GoOSr0hxaxCt6vo_6BR-au23qhhYPFXOjf0n0NLi_l7BnQUQWnYRq4SUdEyIyawegblX3yzxiuMxAxxLPwsb4qqaa3m-w"));
	}

}
