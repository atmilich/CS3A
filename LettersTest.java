/*
 * This class will not be graded, it is for your use in testing.
 */

public class LettersTest {

	public static void main(String[] args) {
		System.out.println("isPalindrome " + (palindromeTest()?"Passed":"Failed"));
		System.out.println("reverse " + (reverseTest()?"Passed":"Failed"));
		System.out.println("wordCount " + (wordCountTest()?"Passed":"Failed"));	
		System.out.println("letterCount " + (letterCountTest()?"Passed":"Failed"));
		System.out.println("capitalCount " + (capitalCountTest()?"Passed":"Failed"));
	}
	
	/*
	 * note: you should test more thoroughly than this:
	 */
	static boolean palindromeTest() {
		if(Letters.isPalindrome("ABBA".toCharArray())!=true) return false; 
		return true;
	}
	static boolean reverseTest() {
		char[] test = new char[4];
		char [] reversed = new char[4];
		test = "hello".toCharArray();
		if (reversed == "olleh".toCharArray());
			return true;
	}
	static boolean wordCountTest() {
		char[] test = new char[4];
		test = "hg g".toCharArray();
		if(Letters.wordCount(test)!=2){
			return false;
		}
               else return true;
	}
	static boolean capitalCountTest(){
		char[] test = new char[6];
                test = "HHHH D".toCharArray();
                if(Letters.capitalCount(test)!=5){
                        return false;
                }
               else return true;
	}
	static boolean letterCountTest() {
                char[] test = new char[4];
                test = "hg g".toCharArray();
		char letter = 'g';
                if(Letters.letterCount(test, letter)!=2){
                        return false;
                }
               else return true;
	}
}
