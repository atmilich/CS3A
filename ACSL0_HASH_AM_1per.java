import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ACSL0_HASH_AM_1per {

	public static void main(String[] args) throws IOException {
		
		/*
		 * @author: Aly Milich
		 * 12-18-15
		 * 
		 * Sample Data:
		 * 9, a, d; OUTPUT:
		 * 	0, .00, x--x-----, 0, 22%
		 * 
		 * 13, a, g, h, j, z, x; OUTPUT:
		 * 	0, .00, x-----xx-xx-x, 0, 46%
		 * 
		 * 3, a, d, z; OUTPUT:
		 * 	1, .33, xx-, 1, 67%
		 *
		 */
		//declarations:
		String filein = "testdata/AM_HashData";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return "", outputs syso-ed
	 */
	static String solve(String s) {
		String[] input = s.split(",[ ]*");
		int capacity = Integer.parseInt(input[0]);
		String key = "abcdefghijklmnopqrstuvwxyz";

		//build table of size capacity:
		int[] table = new int[capacity];

		//fill table, each letter = ascii -key mod capacity
		for (int i = 1; i < input.length; i++) {
			int spot = key.indexOf(input[i]);
			table[spot%capacity]++;
		}

		//collision count
		int collisions = 0;
		for (int i = 0; i < table.length; i++) {
			if(table[i]>1) collisions+=table[i]-1;
		}
		System.out.println(collisions);

		//collision rate
		double collisionrate = (double)collisions/(double)(input.length-1);
		DecimalFormat decimal = new DecimalFormat(); //format w ACSL
		decimal.setMaximumFractionDigits(2);
		decimal.setMinimumFractionDigits(2);
		decimal.setMinimumIntegerDigits(0);
		System.out.println(decimal.format(collisionrate));

		//table mask

		String [] mask = new String[capacity];
		for (int i = 0; i < mask.length; i++) {
			if(table[i] !=0){
				mask[i] = "x";
			}
			else{
				mask[i] = "-";
			}
			System.out.print(mask[i]);
		}
		System.out.println();

		//max chain depth: largest distance in any individual chain in the hash table
		//need largest chain
		Arrays.sort(table);
		System.out.println(table[table.length-1]-1);

		//percent filled
		int filled=0;

		for (int i = 0; i < table.length; i++) {
			if(table[i]!=0){
				filled++;
			}
		}
		decimal.setMinimumFractionDigits(0);
		decimal.setMaximumFractionDigits(0);
		String percent = decimal.format(Math.abs(100*((double) filled/(double) capacity)));
		System.out.println(percent + "%");
		return "";
	}
}
