package test2;

import org.testng.Assert;
import org.testng.annotations.Test;

import testcases.TestBase;

public class Test1 extends TestBase {

	@Test(priority = 0)
	public void login() {
		System.out.println("Executing login Test");

		
	}
	@Test(priority = 1)
	public void logOut() {
		System.out.println("Executing login Test");

		Assert.fail("Logout Failed");
	}
}
