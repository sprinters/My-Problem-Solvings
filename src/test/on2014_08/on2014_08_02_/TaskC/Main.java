package test.on2014_08.on2014_08_02_.TaskC;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/on2014_08/on2014_08_02_/TaskC/TaskC.task"))
			Assert.fail();
	}
}
