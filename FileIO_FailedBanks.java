import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class FileIO_FailedBanks {
	public static void main(String[] args)
	{

		try{
			File data = new File("/Users/student/Desktop/banklist.csv");
			Path studentfile = Paths.get("/Users/student/Desktop/banklist.csv");
			BufferedReader reader =  Files.newBufferedReader(studentfile, StandardCharsets.UTF_8);

			Scanner file = new Scanner(data);
			ArrayList<Bank> banks = new ArrayList<Bank>();
			file.nextLine();

			File bank = new File("/Users/student/Desktop/bank.html"); // output location, make bank.html
			if(!bank.exists()){
				bank.createNewFile();
			}

			FileWriter fw = new FileWriter(bank);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.flush();

			boolean runs = true;
			
			bw.write("<HTML>");
			bw.write("<body>");
			bw.write("<title>");
			bw.write("Bank Closures in the US");
			bw.write("</title>");
			
			bw.write("<div align = 'center'>");
			bw.write("<img src = '/Users/student/Desktop/cracked-bank.jpg'; alt='4/ id = 6/>'; align='middle'; style='width:80%;height:80%;'");
			bw.write("<br>");
			bw.write("<h1>");
			bw.write("Failed Bank Data");
			bw.write("<br>");
			bw.write("</h1>");
			bw.write("<br>");
			bw.write("<h2>");
			bw.write("This program uses data from the FDIC Failed Bank List which includes all banks that have failed in the United States since Oct. 1, 2000.");
			bw.write(" All data used is taken from data.gov, branch: Federal Deposit Insurance Corporation.");
			bw.write("<br>");
			bw.write("</h2>");
			bw.write("</div>");

			while(runs == true){
				//breaks when you press 5

				//menu
				System.out.println("");
				System.out.println("This is a program that presents the data for bank foreclosures in the United States.");
				System.out.println("Menu:");
				System.out.println("Press 1 to see the closures in all states.");
				System.out.println("Press 2 to see the state with the most foreclosures.");
				System.out.println("Press 3 to see the state with the least foreclosures");
				System.out.println("Press 4 to search for a specific state.");
				System.out.println("Press 5 to exit.");



				Scanner input = new Scanner(System.in);

				int choice = input.nextInt();

				int counter = 0;
				String line;
				try{
					while( (line = file.nextLine()) !=null)
					{
						banks.add(new Bank(line));

					}
				}
				catch(NoSuchElementException e){

				}
				boolean stop = false;
				try{ Thread.sleep(10);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}

				//1) all bank stats
				if(choice ==1){
					SortedBanks(banks,bw);
				}

				//2)most foreclosures
				else if(choice ==2){
					MostClosed(banks,bw);
				}

				//3) least closed
				else if(choice == 3){
					LeastClosed(banks,bw);
				}

				//4) search for a state
				else if(choice == 4){
					Search(banks,bw);
				}

				//5) exit
				else if(choice == 5){
					System.out.println("Goodbye.");
					break;
				}
			}

		}
		catch(Exception e){
			e.printStackTrace();
		} 

	}//end main 


	static int most_num =0;
	static String most_name = null;

	static int least_num = 0;
	static String least_name = null;
	
	/**
	 * 
	 * @param bank
	 * @param bw
	 * @throws IOException
	 * 
	 * Print out all of the states and the number of failed banks in each
	 * 3 arrays, states (all states alphabetized), state_name (breaks when state name changes, shows all of the diff states), and state_freq (stores the # of failed banks that corresponds to the same spot in state_name)
	 * Break from looping through state [] when state[i] is diff from state[i-1], add name to state_name and counter to state_freq
	 * Counter reset to 1 each time
	 */

	public static void SortedBanks(ArrayList<Bank> bank, BufferedWriter bw) throws IOException
	{


		String[] states = new String[bank.size()];
		Collections.sort(bank, new Comparator<Bank>(){
			@Override
			public int compare(Bank bank1, Bank bank2)
			{
				return bank1.getState().compareTo(bank2.getState());
			}
		});
		for(int i = 0; i<bank.size(); i++)
		{
			states[i] = bank.get(i).getState();
		}

		int counter=0;
		int resets =0;

		String[] state_name = new String[50];
		int[] state_freq = new int[50];

		state_name[0] = states[0];
		state_freq[0] = 1;

		for (int j = 1; j < states.length; j++) {

			if(states[j].equals(states[j-1]))
			{
				counter++;
			}
			else{
				resets++;
				state_freq[resets-1] = state_freq[resets-1]+counter;
				state_name[resets] = states[j];
				counter = 1;
			}

		}

		System.out.println("Here is an alphabetized list of the states in the US and the number of banks that have failed since Oct. 1, 2000.");
		bw.write("<h3>");
		bw.write("<br> Here is an alphabetized list of the states in the US and the number of banks that have failed since Oct. 1, 2000.");
		bw.write("<br>");
		bw.write("</h3>");
		bw.flush();

		bw.write("<br>");
		for (int i = 0; i < resets+1; i++) {
			bw.write("State: " + (String) state_name[i] + ";" + " Failed Banks: " + state_freq[i] + "<br>");
			bw.flush();
			System.out.println("State: " + (String) state_name[i] +";" + " Failed Banks: " + state_freq[i]);
		}

	}

	/**
	 * 
	 * @param bank
	 * @param bw
	 * @throws IOException
	 * 
	 * Prints out the state with the most failed banks
	 * Compares state_freq[i] to state_freq[i-1], which ever one is greater becomes mostNum (static int). mostNum replaced when another freq is greater.
	 * Finds what i is for mostNum, prints out state_name[i]
	 */
	public static void MostClosed(ArrayList<Bank> bank, BufferedWriter bw) throws IOException{

		String[] states = new String[bank.size()];
		Collections.sort(bank, new Comparator<Bank>(){
			@Override
			public int compare(Bank bank1, Bank bank2)
			{
				return bank1.getState().compareTo(bank2.getState());
			}
		});
		for(int i = 0; i<bank.size(); i++)
		{
			states[i] = bank.get(i).getState();
		}

		int counter=0;
		int resets =0;

		String[] state_name = new String[bank.size()];
		int[] state_freq = new int[bank.size()];

		state_name[0] = states[0];
		state_freq[0] = 1;

		for (int j = 1; j < states.length; j++) {

			if(states[j].equals(states[j-1]))
			{
				counter++;
			}
			else{
				resets++;
				state_freq[resets-1] = state_freq[resets-1]+counter;
				state_name[resets] = states[j];
				counter = 1;
			}

		}

		most_num = state_freq[0];

		for (int i = 0; i < resets+1; i++) {
			if(state_freq[i] > most_num) most_num = state_freq[i];
		}

		for (int i = 0; i < resets+1; i++) {
			if(state_freq[i] == most_num) most_name = state_name[i];
		}

		System.out.println("The state with the most bank foreclosures is " + most_name + " with " + most_num + " closures.");
		bw.write("<h3>");
		bw.write("Most Failed Banks: <br>");
		bw.write("</h3>");
		bw.write("The state with the most bank foreclosures is " + most_name + " with " + most_num + " closures.");
		bw.flush();
	}

	
	/**
	 * 
	 * @param bank
	 * @param bw
	 * @throws IOException
	 * 
	 * Prints out state with least failed banks
	 * Compares state_freq[i] to state_freq[i-1], which ever one is lower becomes leastNum (static int). leastNum replaced when another freq is lower.
	 * Finds what i is for mostNum, prints out state_name[i]
	 */
	public static void LeastClosed(ArrayList<Bank> bank, BufferedWriter bw) throws IOException{
		String[] states = new String[bank.size()];
		Collections.sort(bank, new Comparator<Bank>(){
			@Override
			public int compare(Bank bank1, Bank bank2)
			{
				return bank1.getState().compareTo(bank2.getState());
			}
		});
		for(int i = 0; i<bank.size(); i++)
		{
			states[i] = bank.get(i).getState();
		}

		int counter=0;
		int resets =0;

		String[] state_name = new String[bank.size()];
		int[] state_freq = new int[bank.size()];

		state_name[0] = states[0];
		state_freq[0] = 1;

		for (int j = 1; j < states.length; j++) {

			if(states[j].equals(states[j-1]))
			{
				counter++;
			}
			else{
				resets++;
				state_freq[resets-1] = state_freq[resets-1]+counter;
				state_name[resets] = states[j];
				counter = 1;
			}

		}

		least_num = state_freq[0];

		for (int i = 0; i < resets+1; i++) {
			if(state_freq[i] < least_num) least_num = state_freq[i];
		}

		for (int i = 0; i < resets+1; i++) {
			if(state_freq[i] == least_num) least_name = state_name[i];
		}

		bw.write("<h3>");
		bw.write("Least Failed Banks: <br>");
		bw.write("</h3>");
		
		System.out.println("The state with the least bank foreclosures is " + least_name + " with " + least_num + " closures.");
		bw.write("The state with the least bank foreclosures is " + least_name + " with " + least_num + " closures.");
		bw.flush();
	}

	/**
	 * 
	 * @param bank
	 * @param bw
	 * @throws IOException
	 * 
	 * Search for a specific state, finds what i makes state_searched equal state_name[i], prints out state_freq[i]
	 */
	public static void Search(ArrayList<Bank> bank, BufferedWriter bw) throws IOException{

		String[] states = new String[bank.size()];

		System.out.println("Search for a specific state using the standard two-letter postal code abbreviation. Please use proper capitalization.");

		Scanner read = new Scanner(System.in);
		String state_searched = read.nextLine();

		Collections.sort(bank, new Comparator<Bank>(){
			@Override
			public int compare(Bank bank1, Bank bank2)
			{
				return bank1.getState().compareTo(bank2.getState());
			}
		});
		for(int i = 0; i<bank.size(); i++)
		{
			states[i] = bank.get(i).getState();
		}

		int counter=0;
		int resets =0;

		String[] state_name = new String[bank.size()];
		int[] state_freq = new int[bank.size()];

		state_name[0] = states[0];
		state_freq[0] = 1;

		for (int j = 1; j < states.length; j++) {

			if(states[j].equals(states[j-1]))
			{
				counter++;
			}
			else{
				resets++;
				state_freq[resets-1] = state_freq[resets-1]+counter;
				state_name[resets] = states[j];
				counter = 1;
			}

		}
		
		bw.write("<h3>");
		bw.write("State Search: <br>");
		bw.write("</h3>");

		System.out.println("You searched for: " + state_searched);
		bw.write("You searched for: " + state_searched);
		bw.write("<br>");
		bw.flush();

		for (int i = 0; i < resets+1; i++) {
			if(state_name[i].equals(state_searched)){
				System.out.println(state_searched + " has had " + state_freq[i] + " closure(s).");
				bw.write(state_searched + " has had " + state_freq[i] + " closure(s).");
				bw.flush();
				break;
			}
		}
	}
}

//done