import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class ACSL3_abc_c17am1 {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/abc_Data";
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

	static String solve(String s) {
		String input = s;



		String[] data = input.split(",[ ]*");

		int filled1 = Integer.parseInt(data[0]);
		int filled2 = Integer.parseInt(data[1]);
		int filled3 = Integer.parseInt(data[2]);
		int filled4 = Integer.parseInt(data[3]);

		int givenLetters = Integer.parseInt(data[4]);

		//put spaces in the basic grid

		char[][] originalBoard = new char[6][6];
		for(int i = 1; i<=36; i++) {
			if(i > 0 & i <= 6) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[0][i-1] = 'X'; 
				}
			}
			if(i >= 7 & i<=12) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[1][i - 7] = 'X'; 
				}
			}
			if(i >= 13 & i<= 18) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[2][i - 13] = 'X'; 
				}
			}
			if(i >= 19 & i<=24) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[3][i - 19] = 'X'; 
				}
			}
			if(i >= 25 & i<=30) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[4][i - 25] = 'X'; 
				}
			}
			if(i >= 31 & i<=36) {
				if(i == filled1 || i == filled2 || i == filled3 || i == filled4) {
					originalBoard[5][i - 31] = 'X'; 
				}
			}
		}



		if(givenLetters == 1) {
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int firstPosition = Integer.parseInt(data[6]);
			int column = 0;
			while(firstPosition>6) {
				firstPosition = firstPosition - 6;
				column++;
			}
			originalBoard[column][firstPosition-1] = Letter1;

		}

		if(givenLetters == 2) {
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int firstPosition = Integer.parseInt(data[6]);

			int column = 0;
			while(firstPosition>6) {
				firstPosition = firstPosition - 6;
				column++;
			}
			originalBoard[column][firstPosition - 1] = Letter1;

			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;


		}
		if(givenLetters == 3) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;


			//2nd letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;


			//3rd letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;

		}
		if(givenLetters == 4) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;

			//2nd Letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;


			//3rd Letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;


			//4th Letter
			String fourthLetter = data[11];
			char Letter4 = fourthLetter.charAt(0);
			int Position4 = Integer.parseInt(data[12]);

			int column4 = 0;
			while(Position4>6) {
				Position4 = Position4 - 6;
				column4++;
			}
			originalBoard[column4][Position4 - 1] = Letter4;

		}
		if(givenLetters == 5) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;

			//2nd Letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;

			//3rd Letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;

			//4th Letter
			String fourthLetter = data[11];
			char Letter4 = fourthLetter.charAt(0);
			int Position4 = Integer.parseInt(data[12]);

			int column4 = 0;
			while(Position4>6) {
				Position4 = Position4 - 6;
				column4++;
			}
			originalBoard[column4][Position4 - 1] = Letter4;

			//5th letter
			String sLetter5 = data[13];
			char Letter5 = sLetter5.charAt(0);
			int Position5 = Integer.parseInt(data[14]);

			int column5 = 0;
			while(Position5>6) {
				Position5 = Position5 - 6;
				column5++;
			}
			originalBoard[column5][Position5 - 1] = Letter5;

		}
		if(givenLetters == 6) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;

			//2nd Letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;

			//3rd Letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;

			//4th Letter
			String fourthLetter = data[11];
			char Letter4 = fourthLetter.charAt(0);
			int Position4 = Integer.parseInt(data[12]);

			int column4 = 0;
			while(Position4>6) {
				Position4 = Position4 - 6;
				column4++;
			}
			originalBoard[column4][Position4 - 1] = Letter4;

			//5th letter
			String sLetter5 = data[13];
			char Letter5 = sLetter5.charAt(0);
			int Position5 = Integer.parseInt(data[14]);

			int column5 = 0;
			while(Position5>6) {
				Position5 = Position5 - 6;
				column5++;
			}
			originalBoard[column5][Position5 - 1] = Letter5;

			//6th letter
			String sixthLetter = data[15];
			char Letter6 = sixthLetter.charAt(0);
			int Position6 = Integer.parseInt(data[16]);

			int column6 = 0;
			while(Position6>6) {
				Position6 = Position6 - 6;
				column6++;
			}
			originalBoard[column6][Position6 - 1] = Letter6;

		}
		if(givenLetters == 7) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;


			//2nd Letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;


			//3rd Letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;


			//4th Letter
			String fourthLetter = data[11];
			char Letter4 = fourthLetter.charAt(0);
			int Position4 = Integer.parseInt(data[12]);

			int column4 = 0;
			while(Position4>6) {
				Position4 = Position4 - 6;
				column4++;
			}
			originalBoard[column4][Position4 - 1] = Letter4;


			//5th letter
			String sLetter5 = data[13];
			char Letter5 = sLetter5.charAt(0);
			int Position5 = Integer.parseInt(data[14]);

			int column5 = 0;
			while(Position5>6) {
				Position5 = Position5 - 6;
				column5++;
			}
			originalBoard[column5][Position5 - 1] = Letter5;

			//6th letter
			String sixthLetter = data[15];
			char Letter6 = sixthLetter.charAt(0);
			int Position6 = Integer.parseInt(data[16]);

			int column6 = 0;
			while(Position6>6) {
				Position6 = Position6 - 6;
				column6++;
			}
			originalBoard[column6][Position6 - 1] = Letter6;

			//7th letter
			String seventhLetter = data[17];
			char Letter7 = seventhLetter.charAt(0);
			int Position7 = Integer.parseInt(data[18]);

			int column7 = 0;
			while(Position7>6) {
				Position7 = Position7 - 6;
				column7++;
			}
			originalBoard[column7][Position7 - 1] = Letter7;

		}
		if(givenLetters == 8) {

			//1st letter
			String firstLetter = data[5];
			char Letter1 = firstLetter.charAt(0);
			int Position1 = Integer.parseInt(data[6]);

			int column = 0;
			while(Position1>6) {
				Position1 = Position1 - 6;
				column++;
			}
			originalBoard[column][Position1 - 1] = Letter1;


			//2nd Letter
			String secondLetter = data[7];
			char Letter2 = secondLetter.charAt(0);
			int Position2 = Integer.parseInt(data[8]);

			int column2 = 0;
			while(Position2>6) {
				Position2 = Position2 - 6;
				column2++;
			}
			originalBoard[column2][Position2 - 1] = Letter2;


			//3rd Letter
			String thirdLetter = data[9];
			char Letter3 = thirdLetter.charAt(0);
			int Position3 = Integer.parseInt(data[10]);

			int column3 = 0;
			while(Position3>6) {
				Position3 = Position3 - 6;
				column3++;
			}
			originalBoard[column3][Position3 - 1] = Letter3;


			//4th Letter
			String fourthLetter = data[11];
			char Letter4 = fourthLetter.charAt(0);
			int Position4 = Integer.parseInt(data[12]);

			int column4 = 0;
			while(Position4>6) {
				Position4 = Position4 - 6;
				column4++;
			}
			originalBoard[column4][Position4 - 1] = Letter4;

			//5th letter
			String sLetter5 = data[13];
			char Letter5 = sLetter5.charAt(0);
			int Position5 = Integer.parseInt(data[14]);

			int column5 = 0;
			while(Position5>6) {
				Position5 = Position5 - 6;
				column5++;
			}
			originalBoard[column5][Position5 - 1] = Letter5;


			//6th letter
			String sixthLetter = data[15];
			char Letter6 = sixthLetter.charAt(0);
			int Position6 = Integer.parseInt(data[16]);

			int column6 = 0;
			while(Position6>6) {
				Position6 = Position6 - 6;
				column6++;
			}
			originalBoard[column6][Position6 - 1] = Letter6;

			//7th letter
			String seventhLetter = data[17];
			char Letter7 = seventhLetter.charAt(0);
			int Position7 = Integer.parseInt(data[18]);

			int column7 = 0;
			while(Position7>6) {
				Position7 = Position7 - 6;
				column7++;
			}
			originalBoard[column7][Position7 - 1] = Letter7;


			//8th letter
			String eigthLetter = data[19];
			char Letter8 = eigthLetter.charAt(0);
			int Position8 = Integer.parseInt(data[20]);

			int column8 = 0;
			while(Position8>6) {
				Position8 = Position8 - 6;
				column8++;
			}
			originalBoard[column8][Position8 - 1] = Letter8;
		}


		//put in the letters to the 4x4 grid

		for(int k = 1; k <5; k++) {
			if(originalBoard[k][0] == 'A') {
				if(originalBoard[k][1] != 'X') {
					originalBoard[k][1] = 'A';
				}
				else if(originalBoard[k][2] != 'X') {
					originalBoard[k][2] = 'A';
				}
			}
			if(originalBoard[k][0] == 'B') {
				if(originalBoard[k][1] != 'X') {
					originalBoard[k][1] = 'B';
				}
				else if(originalBoard[k][2] != 'X') {
					originalBoard[k][2] = 'B';
				}
			}
			if(originalBoard[k][0] == 'C') {
				if(originalBoard[k][1] != 'X') {
					originalBoard[k][1] = 'C';
				}
				else if(originalBoard[k][2] != 'X') {
					originalBoard[k][2] = 'C';
				}
			}

			//right side
			if(originalBoard[k][5] == 'A') {
				if(originalBoard[k][4] != 'X') {
					originalBoard[k][4] = 'A';
				}
				else if(originalBoard[k][3] != 'X') {
					originalBoard[k][3] = 'A';
				}
			}
			if(originalBoard[k][5] == 'B') {
				if(originalBoard[k][4] != 'X') {
					originalBoard[k][4] = 'B';
				}
				else if(originalBoard[k][3] != 'X') {
					originalBoard[k][3] = 'B';
				}
			}
			if(originalBoard[k][5] == 'C') {
				if(originalBoard[k][4] != 'X') {
					originalBoard[k][4] = 'C';
				}
				else if(originalBoard[k][3] != 'X') {
					originalBoard[k][3] = 'C';
				}
			}
		}	

		//top side

		for(int m = 1; m <5; m++) {
			if(originalBoard[0][m] == 'A') {
				if(originalBoard[1][m] != 'z') {
					originalBoard[1][m] = 'A';
				}
				else if(originalBoard[2][m] != 'z') {
					originalBoard[2][m] = 'A';
				}
			}
			if(originalBoard[0][m] == 'B') {
				if(originalBoard[1][m] != 'z') {
					originalBoard[1][m] = 'B';
				}
				else if(originalBoard[2][m] != 'z') {
					originalBoard[2][m] = 'B';
				}
			}
			if(originalBoard[0][m] == 'C') {
				if(originalBoard[1][m] != 'z') {
					originalBoard[1][m] = 'C';
				}
				else if(originalBoard[2][m] != 'z') {
					originalBoard[2][m] = 'C';
				}
			}

			//bottom side
			if(originalBoard[5][m] == 'A') {
				if(originalBoard[4][m] != 'z') {
					originalBoard[4][m] = 'A';
				}
				else if(originalBoard[3][m] != 'z') {
					originalBoard[3][m] = 'A';
				}
			}
			if(originalBoard[5][m] == 'B') {
				if(originalBoard[4][m] != 'z') {
					originalBoard[4][m] = 'B';
				}
				else if(originalBoard[3][m] != 'z') {
					originalBoard[3][m] = 'B';
				}
			}
			if(originalBoard[5][m] == 'C') {
				if(originalBoard[4][m] != 'z') {
					originalBoard[4][m] = 'C';
				}
				else if(originalBoard[3][m] != 'z') {
					originalBoard[3][m] = 'C';
				}
			}
		}	

		char[][] grid = new char[4][4];

		//1st row
		grid[0][0] = originalBoard[1][1];
		grid[0][1] = originalBoard[1][2];
		grid[0][2] = originalBoard[1][3];
		grid[0][3] = originalBoard[1][4];
		//2nd row
		grid[1][0] = originalBoard[2][1];
		grid[1][1] = originalBoard[2][2];
		grid[1][2] = originalBoard[2][3];
		grid[1][3] = originalBoard[2][4];		
		//3rd row
		grid[2][0] = originalBoard[3][1];
		grid[2][1] = originalBoard[3][2];
		grid[2][2] = originalBoard[3][3];
		grid[2][3] = originalBoard[3][4];
		//4th row
		grid[3][0] = originalBoard[4][1];
		grid[3][1] = originalBoard[4][2];
		grid[3][2] = originalBoard[4][3];
		grid[3][3] = originalBoard[4][4];

		//test for repeats in row

		if(full(grid) == false)	{
			for(int p = 0; p < 4; p++) {
				for(int q = 0; q < 4; q++) {
					if(empty(grid, p, q) == true) {
						if(containsA(grid, p, q) == true && containsB(grid, p, q) == true && containsC(grid, p, q) == false) {
							grid[p][q] = 'C';
						}
						else if(containsA(grid, p, q) == true && containsC(grid, p, q) == true && containsB(grid, p, q) == false) {
							grid[p][q] = 'B';
						}
						else if(containsB(grid, p, q) == true && containsC(grid, p, q) == true && containsA(grid, p, q) == false) {
							grid[p][q] = 'A';
						}
					}
				}
			}
		}

		if(full(grid) == false)	{
			for(int p = 0; p < 3; p++) {
				for(int q = 0; q < 3; q++) {
					if(empty(grid, p, q) == true) {
						if(containsA(grid, p, q) == true && containsB(grid, p, q) == true && containsC(grid, p, q) == false) {
							grid[p][q] = 'C';
						}
						else if(containsA(grid, p, q) == true && containsC(grid, p, q) == true && containsB(grid, p, q) == false) {
							grid[p][q] = 'B';
						}
						else if(containsB(grid, p, q) == true && containsC(grid, p, q) == true && containsA(grid, p, q) == false) {
							grid[p][q] = 'A';
						}
					}
				}
			}
		}


		if(full(grid) == false)	{
			for(int p = 0; p < 4; p++) {
				for(int q = 0; q < 4; q++) {
					if(empty(grid, p, q) == true) {
						if(containsA(grid, p, q) == true && containsB(grid, p, q) == true && containsC(grid, p, q) == false) {
							grid[p][q] = 'C';
						}
						else if(containsA(grid, p, q) == true && containsC(grid, p, q) == true && containsB(grid, p, q) == false) {
							grid[p][q] = 'B';
						}
						else if(containsB(grid, p, q) == true && containsC(grid, p, q) == true && containsA(grid, p, q) == false) {
							grid[p][q] = 'A';
						}
					}
				}
			}
		}

		if(full(grid) == false)	{
			for(int a = 0; a < 4; a++) {
				for(int b = 0; b < 4; b++) {
					if(empty(grid, a, b) == true) {
						if(containsA(grid, a, b) == true && containsB(grid, a, b) == true && containsC(grid, a, b) == false) {
							grid[a][b] = 'C';
						}
						else if(containsA(grid, a, b) == true && containsC(grid, a, b) == true && containsB(grid, a, b) == false) {
							grid[a][b] = 'B';
						}
						else if(containsB(grid, a, b) == true && containsC(grid, a, b) == true && containsA(grid, a, b) == false) {
							grid[a][b] = 'A';
						}
					}
				}
			}
		}

		if(full(grid) == false)	{
			for(int p = 0; p < 4; p++) {
				for(int q = 0; q < 4; q++) {
					if(empty(grid, p, q) == true) {
						if(containsA(grid, p, q) == true && containsB(grid, p, q) == true && containsC(grid, p, q) == false) {
							grid[p][q] = 'C';
						}
						else if(containsA(grid, p, q) == true && containsC(grid, p, q) == true && containsB(grid, p, q) == false) {
							grid[p][q] = 'B';
						}
						else if(containsB(grid, p, q) == true && containsC(grid, p, q) == true && containsA(grid, p, q) == false) {
							grid[p][q] = 'A';
						}
					}
				}
			}
		}

		//print output
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] != 'X') {
					System.out.print(grid[i][j]);
				}
			}
		}

		return "";

	}

	//function for if its empty
	public	static boolean empty(char[][] c, int a, int b) {
		if(c[a][b] != 'X' && c[a][b]!='A' && c[a][b]!='B' && c[a][b]!='C') {
			return true;
		}
		else {
			return false;
		}
	}

	//function to check if row or column contains A
	public static boolean containsA(char[][] c, int a, int b) {
		for(int i = 0; i < 4; i++) {
			//check row
			if(c[a][i] == 'A') {
				return true;
			}
			//check column
			if(c[i][b] == 'A') {
				return true;
			}
		}
		return false;	
	}



	//function to check if row or column contains B
	public static boolean containsB(char[][] c, int a, int b) {
		for(int i = 0; i < 4; i++) {
			//check row
			if(c[a][i] == 'B') {
				return true;
			}
			//check column
			if(c[i][b] == 'B') {
				return true;
			}
		}
		return false;	
	}

	//function to check if row or column contains C
	public static boolean containsC(char[][] c, int a, int b) {
		for(int i = 0; i < 4; i++) {
			//check row
			if(c[a][i] == 'C') {
				return true;
			}
			//check column
			if(c[i][b] == 'C') {
				return true;
			}
		}
		return false;	
	}
	//function to check if array is filled
	public static boolean full(char[][] c) {
		for(int i = 0; i < 4; i++) {
			if(empty(c, 0, i) != true) {
				return false;
			}
			if(empty(c, 1, i) != true) {
				return false;
			}
			if(empty(c, 2, i) != true) {
				return false;
			}
			if(empty(c, 3, i) != true) {
				return false;
			}
		}

		return true;
	}


}

//final final
