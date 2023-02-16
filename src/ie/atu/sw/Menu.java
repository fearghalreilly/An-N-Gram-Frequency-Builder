package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private Scanner s;
	// Boolean used to toggle the application off/on
	private boolean keepRunning = true;
	// Stores the inputted text file directory
	private String filePath;
	// Stores the inputted n-gram frequency size
	private Integer nGramFreqNumber;
	// Stores the outputted n-gram frequency
	private static List<String> nGramFreqList = new ArrayList<>();
	// Stores the inputted output file location
	private String outputPath;

	// Creating a local variable "parser" of Parser
	Parser parser = new Parser();
	// Creating a local variable "ngramoutput" of NGramOutputter
	NGramOutputter ngramoutput = new NGramOutputter();

	public Menu() {
		s = new Scanner(System.in);
	}

	public void start() throws Exception {
		// Keep application running when variable keepRunning is equal to true. The
		// application will be terminated when keepRunning is toggled to false. Option 5
		// of the application menu changes keepRunning from true to false.

		while (keepRunning) {
			showOptions();
			// Block and wait for users input
			int choice = Integer.parseInt(s.next());

			if (choice == 1) {
				// Execute method getTextDirectory
				getTextDirectory();
			} else if (choice == 2) {
				// Execute method getSize
				getSize();
			} else if (choice == 3) {
				// Execute method getOutputFile
				getOutputFile();
			} else if (choice == 4) {
				// Execute method build
				build();
			} else if (choice == 5) {
				// Prompts the user that the application is shutting down. Changes variable
				// keepRunning from true to false which causes the application to terminate as
				// the while statement for keepRunning is longer valid.
				System.out.println("Shutting down application..");
				keepRunning = false;
			} else {
				// Prints Invalid input if an input other than 1-5 is inputted by the user
				System.out.println("Invalid input");
			}

		}
	}

	// Method getTextDirectory is executed when the user selects option 1. It
	// retrieves the inputted text file location where the user wants to use for the
	// n-gram frequency application.

	public void getTextDirectory() throws Exception {
		// The user is prompted to enter the file directory of the text file they want
		// to use for the application
		System.out.println("Specify Text File Directory");
		// The inputted file directory is saved to variable filePath
		filePath = s.next();

	}

	// Method getSize is executed when the user selects option 2. It retrieves the
	// inputted n-gram size. Reads the text file of the inputted text file
	// directory. Creates a string and removes all the white space, changes the text
	// all to lower case and removes all special characters. Spilts the string into
	// chunks of the inputted n-gram frequency size. Loops through each chunk of the
	// string array into the Hashmap. The frequency of each chunk is printed into a
	// list array
	public void getSize() throws Exception {
		// The user is prompted to enter the size of the n-gram frequency they want to
		// create. The inputted n-gram frequency size is saved to variable
		// nGramFreqNumber
		System.out.println("Specify n-Gram Size");
		nGramFreqNumber = s.nextInt();
		// Method readStringData is executed using variable nGramFreqNumber as a
		// parameter. The returned string is saved to variable returnedData
		String returnedData = parser.readStringData(filePath);
		// Method numberOfChunksArray is executed using parameters returnedData and
		// nGramFreqNumber. The returned data is saved to variable nGramFreqList
		nGramFreqList = parser.numberOfChunksArray(returnedData, nGramFreqNumber);

	}

	// Method getOutputFile is executed when the user selects option 3. It retrieves
	// the inputted output file location where the user wants to save the n-gram
	// frequency csv file.
	public void getOutputFile() throws Exception {
		// The user is prompted to enter the output file location to save file
		// ngramOutputG00411386.csv. The inputted n-gram frequency size is saved to
		// variable outputPath
		System.out.println("Specify Output File Location for file ngramOutputG00411386.csv to be saved");
		outputPath = s.next();

	}

	// Method build is executed when the user selects option 4. It outputs the
	// n-gram frequency csv file called ngramOutputG00411386.csv to the inputted
	// output location
	public void build() throws Exception {
		// The user is prompted that the n-Gram frequency application us being built in
		// the inputted output file directory plus /ngramOutputG00411386.csv
		System.out.println("Building N-Gram Frequency. Please wait while it gets build in location " + outputPath
				+ "/ngramOutputG00411386.csv");
		// Method nGramFreqOutputCreation is executed using parameters nGramFreqList and
		// outputPath
		ngramoutput.nGramFreqOutputCreation(nGramFreqList, outputPath);

	}

	private void showOptions() {

		System.out.println("************************************************************");
		System.out.println("*      ATU - Dept. Computer Science & Applied Physics     *");
		System.out.println("*                                                          *");
		System.out.println("*                  N-Gram Frequency Builder                *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		System.out.println("(1) Specify Text File Directory");
		System.out.println("(2) Specify n-Gram Size");
		System.out.println("(3) Specify Output File");
		System.out.println("(4) Build n-Grams ");
		System.out.println("(5) Quit");
		System.out.print("Select Option [1-4]>");
		System.out.println();
	}
}
