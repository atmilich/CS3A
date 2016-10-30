
public class NumbersTest {
	public static void main(String[] args) 
	{
		//print passed or failed for each function
		System.out.println("factorial " + (factorialTest()?"Passed":"Failed"));
		System.out.println("summation " + (summationTest()?"Passed":"Failed"));
		System.out.println("fibonacci " + (fibonacciTest()?"Passed":"Failed"));
		System.out.println("sumDigits " + (digitTest()?"Passed":"Failed"));
		System.out.println("productDigits " + (productDigitTest()?"Passed":"Failed"));
		System.out.println("product " + (productTest()?"Passed":"Failed"));
		System.out.println("sumRange " + (rangeTest()?"Passed":"Failed"));
		System.out.println("reverse " + (reverseTest()?"Passed":"Failed"));
		System.out.println("gcd " + (gcdTest()?"Passed":"Failed"));
		System.out.println("compound " + (compoundTest()?"Passed":"Failed"));
		System.out.println("combinations " + (combinationsTest()?"Passed":"Failed"));
		System.out.println("sqrtNewton " + (sqrtTest()?"Passed":"Failed"));
		System.out.println("sqrtBisection " + (sqrtBisectionTest()?"Passed":"Failed"));
	}
	
	static boolean factorialTest() {
		if(Numbers.factorial(0)!=1) return false; //check base case 
		if(Numbers.factorial(1)!=1) return false; //check base case
		if(Numbers.factorial(5)!=120) return false;
		if(Numbers.factorial(20)!=-2102132736) return false;  //recursion check
		if(Numbers.factorial(-2)!=1) return false;  //error handling check
		return true;
	}
	
	static boolean summationTest(){
		if(Numbers.summation(5) !=15) return false;
		if(Numbers.summation(21343) !=227772496) return false; //recursion check
		return true;
	}

	static boolean fibonacciTest() {
		if(Numbers.fibonacci(6) !=8) return false;
		if(Numbers.fibonacci(29) !=514229) return false;
		else{
			return true;
		}
	}
	
	static boolean digitTest() {
		if(Numbers.sumDigits(50) !=5) return false;
		else{
			return true;
		}

	}

	static boolean productDigitTest() {
		if (Numbers.productDigits(34) !=12) return false;
		if(Numbers.productDigits(80) !=0) return false;
		return true;
	}
	
	static boolean productTest() {
		if(Numbers.product(2, 3) !=6) return false;
		if(Numbers.product(0, 90000) !=0) return false; //base case check
		if(Numbers.product(90, 88) !=7920) return false; //recursion check
		return true;
	}
	static boolean rangeTest() {
		if(Numbers.sumRange(1, 4) !=10) return false;
		if(Numbers.sumRange(4, 1) !=10) return false;
		return true;
	}
	static boolean reverseTest() {
		if(Numbers.reverseDigits(2) !=2) return false;
		if(Numbers.reverseDigits(34) !=43) return false;
		return true;
	}
	static boolean gcdTest() {
		if(Numbers.gcd(408, 126) !=6) return false;
		return true;
	}

	 static boolean compoundTest() {
		if(Numbers.compound(3, 2, 4)!= 243) return false;
		return true;
	}

	static boolean combinationsTest() {
		if(Numbers.combinations(7, 5) != 21) return false;
		return true;	
	}
	static boolean sqrtTest() {
                if(Numbers.sqrtNewton(1.0, .01, 1.0) != 1.0) return false;
		if(Numbers.sqrtNewton(49.0, .01, 49.0) > 7.01) return false;
                return true;
        }
	static boolean sqrtBisectionTest() {
		if(Numbers.sqrtBisection(49.0, .01, 49.0, 0) > 7.01) return false;
                return true;
	}
}
