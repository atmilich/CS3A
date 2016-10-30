import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ACSL4_regexp15_c17am1 {

	public static void main(String[] args) throws IOException {

		//declarations:
		String filein = "testdata/regexp_DATA";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		String param = scan.nextLine();
		String []input = param.split(",[ ]*");

		//main loop:
		while(scan.hasNext()) {
			String reg = scan.nextLine();
			
			String s = "";

			Pattern p = Pattern.compile("\\A" + reg + "\\z");
			Matcher m = null;

			for (int i = 0; i < input.length; i++) {
				m = p.matcher(input[i]);
				if(m.find()){
					s = s + input[i] + ", ";
				}
			}
			s = s.replaceAll(", \\z", " ");
			
			if(s == ""){
				s = "NONE";
			}
			
			System.out.println(s);


		}

		fop.flush();
		fop.close();
		scan.close();
	}
}
//final final