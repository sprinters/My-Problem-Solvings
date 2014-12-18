package test.on2014_03.on2014_03_26_.AssemblyLineScheduling;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("src/test/on2014_03/on2014_03_26_/AssemblyLineScheduling/AssemblyLineScheduling.task"))
			Assert.fail();
	}
}
