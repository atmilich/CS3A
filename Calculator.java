/* 
 * Calculator (7pt)
 * implement a calculator that takes a char[] and returns a value 
 * 
 * Should handle +, /, -, *, e, and m 
 * (e for exponentiation, m for modulo)
 * 
 * Should handle unlimited correctly matched parenthesis
 * 
 * example input:
 * 
 * input: (3+4)
 * value: 7.0
 * 
 * input: ((4+6)*2)
 * value: 20.0
 * 
 * 
 */

public class Calculator {

	public static void main(String[] args) {
		System.out.println("calculator " + (calcTest()?"Passed":"Failed"));
	}

	/*
	 * note: you should test MUCH more thoroughly than this
	 */
	static boolean calcTest() {
		if(calc("(3+4)".toCharArray())!=7.0) return false; 
		if(calc("((4+6)*2)".toCharArray())!=20.0) return false; 
		return true; 
	}

	/*
	 * complete 
	 */
	static double calc(char[] a) {
		throw new NotImplemented();
	}

}
