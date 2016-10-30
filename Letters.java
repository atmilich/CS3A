/**
 * Recursion Assignment
 * @author 
 *
 * Remove the NotImplemented line from any methods you write
 * DO NOT change the method signatures
 * You MAY write helper classes
 */
public class Letters {
	
	/*
	 * Palindrome (2pt)
	 * recursion: are the first and last letters the same?
	 * base case: is the word length <=2?
	 */

	//looks at the first spot of the array and the last spot. 
	//if equal, returns true, else return false

	static boolean isPalindrome(char[] arr) {
		if(arr.length < 2) return true;
		if(arr[0] == arr[arr.length-1]) return true;
		else return false;
	}
	
	/*
	 * Reverse (2pt)
	 * R(a, i) = a 			(if i >= |a|/2)
	 * R(a, i) = R(b, i+1)
	 * b has the ith and |a|-ith letters swapped  
	 */

	static char[] reverse(char[] arr) {
		return reverse(arr, 0);
	}

	static char[] reverse(char[] arr, int i) {
		char temp;

		if(i >= (arr.length/2))
			return arr;
		else{
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
			reverse(arr, i+1);
		}
		return arr;
	}

	/*
	 * Word count (2pt)
	 * L(a) = 1                 (if |a| = 0)
	 * L(a) = 1 + L(a[1:])      (if a[0] = ' ')
	 * L(a) = L(a[1:])
	 * 
	 * you may use the slice function
	 */

	//looks at each spot in char[] arr. 
	//if arr[i] has a space, slice from there (completed 1 word)
	//if there are more chars in the array, adds 1 + the rest of the array (takes into account the word it just did and continues to do it until the end of the array).

	static int wordCount(char[] arr) {
		int number = 0;
		if(arr.length == 1){
			number = 1;
		}
		else if(arr[0] == ' '){
			number = 1+(wordCount(slice(arr, 1, (arr.length))));
		}
		else{
			number = (wordCount(slice(arr, 1, (arr.length))));
		}
		return number;
	}

	/*
	 * Capital count (2pt)
	 * L(a) = 0                 (if |a| = 0)
	 * L(a) = 1 + L(a[1:])      (if a[0] is capital)
	 * L(a) = L(a[1:])
	 * 
	 * you may use the slice function
	 */
	static int capitalCount(char[] arr) {
		int capitals =0;

		if(arr.length == 0){
			return 0;
		}

		if(Character.isUpperCase(arr[0])){
			capitals = (capitalCount(slice(arr, 1, (arr.length)))+1);
		}
		else{
			capitals = (capitalCount(slice(arr, 1, (arr.length))));
		}
		return capitals;
	}
	
	/*
	 * Letter count (2pt)
	 * L(a,c) = 0                 (if |a| = 0)
	 * L(a,c) = 1 + L(a[1:], c)   (if a[0] = c)
	 * L(a,c) = L(a[1:], c)
	 * 
	 * you may use the slice function
	 */

	//similar to wordCount, looks for spaces & counts only letters
	static int letterCount(char[] arr, char letter) {
		if(arr.length ==0){ 
			return 0;
		}	
		if(arr[0] == letter){ 
			return letterCount(slice(arr, 1), letter) +1;
		}
		else{
			return letterCount(slice(arr,1), letter);
		}
	}	

	/*
	 * Contains (3pt)
	 * C(a,s) = false                          (if |a| = 0)
	 * C(a,s) = true                           (if |s| = 0)
	 * C(a,s) = C(a[1:],s[1:]) || C(a[1:], s)  (if a[0] = s[0])
	 * C(a,s) = C(a[1:],s)
	 * 
	 * you may use the slice function
	 */
	static boolean contains(char[] arr, char[] sub) {
		throw new NotImplemented();
	}

	
	/*
	 * Replace (3pt)
	 * R(a,f,t) = empty 					(if |a| = 0)
	 * R(a,f,t) = t JOIN R(a[1:], f, t)     (if a[0] = f)
	 * R(a,f,t) = a[0] JOIN R(a[1:], f, t) 
	 * 
	 * you will need to write a JOIN function
	 * you may use the slice function
	 */
	static void replace(char[] arr, char from, char to) {
		throw new NotImplemented();
	}
	
	/*
	 * LetterFrequency (3pt)
	 * L(a,f,i) ends if i=0, and all values in F divided by |a|
	 * L(a,f,i) = L(a[1:], f, i+1) and f at letter a[0] increments
	 * (i starts at |a|)        
	 */
	static void letterFrequency(char[] arr, double[] freq) {
		throw new NotImplemented();		
	}
	
	/**
	 * Slice an array
	 * @param a the array to slice
	 * @param i the starting place
	 * @param j the ending place
	 * @return a new array which is a subset of a from i to j
	 */
	static char[] slice(char[] a, int i, int j) {
		char[] ret = new char[j-i];

		for(int k = i; k<j; k++) {
			ret[k-i] = a[k];
		}
		return ret;
	}
	
	/**
	 * Slice an array
	 * @param a the array to slice
	 * @param i the starting place
	 * @return a new array which is a subset of a from i to the end
	 */
	static char[] slice(char[] a, int i) {
		return slice(a, i, a.length);
	}

	/**
	 * Slice an array
	 * @param a the array to slice
	 * @return a new array which is a subset that removes the first item
	 */
	static char[] slice(char[] a) {
		return slice(a, 1, a.length);
	}
}
