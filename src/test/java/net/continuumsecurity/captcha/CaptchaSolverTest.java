package net.continuumsecurity.captcha;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class CaptchaSolverTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFromFile() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("deathbycaptcha.properties"));
		ISolveCaptcha solver = CaptchaSolverFactory.createSolver(props);
		assertEquals("tessestu", solver.solve(new File("captcha.jpg")));
	}
}
