package Automation;

import org.testng.annotations.Test;

public class Groups
{
	@Test(groups="smoke")
	public void test1() 
	{
		System.out.println("This is my firs smoke test");
	}
	@Test(groups="Regrssion")
	public void test2() 
	{
		System.out.println("This is my firs Regression test");
	}
	@Test(groups="smoke")
	public void test3() 
	{
		System.out.println("This is my Second smoke test");
	}
	@Test(groups="Regression")
	public void test4() 
	{
		System.out.println("This is my Second Regression test");
	}
}
