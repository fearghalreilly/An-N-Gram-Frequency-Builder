package ie.atu.sw;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

	// Method numberOfChunksArray takes in 2 parameters. A string of the contents of
	// the inputted text file and an integer of the inputted n-gram frequency size.
	// All the white space is removed, the text is changed all to lower case and the
	// all special characters are removed on the string parameter. The string is
	// spilt into chunks of sizes inputted for the n-gram frequency size. Each chunk
	// is looped through in a Hashmap. The frequency of a chunk is printed if its
	// present into a list array. This list array is then returned.
	// Reference https://www.youtube.com/watch?v=pzQvKGcze3A
	public List<String> numberOfChunksArray(String string, Integer number) {
		//Stores inputted text file
		String nGramFreqOutput;
		//Stores n-gram frequency output
		List<String> nGramFreqList = new ArrayList<>();

		//Removes all the white space between characters, changes everything to  lower case and removes all special characters. The string is spilt into chunks of sizes inputted for the n-gram frequency size from method getSize to create a string array of the chunks. 
		String[] strArray = string.trim().replaceAll("[^a-zA-Z]", "").toLowerCase().split("(?<=\\G.{" + number + "})");

		//Hashmap takes in two parameters, key equals String and value equals Integer.
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// For loop to put each element of the array into the hashmap.
		for (int i = 0; i < strArray.length; i++) {
			// If the hashmap already contains the key .i.e the chunk of data from the
			// string array.
			if (hm.containsKey(strArray[i])) {
				// Add one to the current value
				hm.put(strArray[i], hm.get(strArray[i]) + 1);
			}
			// If it doesn't contain key .i.e chunk, keep the current value keep it the same
			// value.
			else {
				hm.put(strArray[i], 1);
			}
		}
		// Print Hashmap
		// Output the element to the list array for each entry that is present
		// Reference
		// https://stackoverflow.com/questions/48809435/java-for-loop-only-storing-last-value
		for (Map.Entry entry : hm.entrySet()) {
			// Output to list array in format - n-gram chunk : frequency
			nGramFreqOutput = (entry.getKey() + "," + entry.getValue());
			nGramFreqList.add(nGramFreqOutput);
		}
		// Return n-gram frequency list array
		return nGramFreqList;

	}

	// Method readStringData takes in one parameter. A string of the file directory
	// of the text file that was inputted for method getTextDirectory. It reads the
	// file from the inputted file directory and creates a string of the text file.
	// This string is then returned.
	// Reference https://www.youtube.com/watch?v=ScUJx4aWRi0&t=324s
	public String readStringData(String directory) throws Exception {
		// Returns string of the file directory of the inputted text file.
		String directoryData = Files.readString(Paths.get(directory));

		return directoryData;
	}

}
