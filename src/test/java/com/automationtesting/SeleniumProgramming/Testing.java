package com.automationtesting.SeleniumProgramming;

public class Testing {

	public static void main(String[] args) {
		int count = 0;
		String str = "testing12345";
		char[] ch = str.toCharArray();
		System.out.println(ch);

		for (char c : ch) {
			System.out.println("word name is "+c);
			if (Character.isDigit(c)) {
				 int num= Character.getNumericValue(c);
				 count+=num;
				System.out.println(count);
				
			}
		}
		 System.out.println("Total count of numbers "+count);
	}

}
