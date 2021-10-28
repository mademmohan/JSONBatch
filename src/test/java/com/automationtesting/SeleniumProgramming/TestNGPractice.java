package com.automationtesting.SeleniumProgramming;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test (invocationCount = 10)
	public void tc1() {
		System.out.println("TC1 exectued");
	}

}
