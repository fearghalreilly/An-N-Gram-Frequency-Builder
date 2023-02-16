package ie.atu.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NGramOutputter {

//Method nGramFreqOutputCreation takes in 2 parameters. A list string which is the outputted n-gram frequency and the inputted output file location. It loops through each line of the n-gram frequency list string. Each time it loops, it writes the output to the inputted n-gram frequency output file directory.
	public void nGramFreqOutputCreation(List<String> frequencys, String outputPath) {

		try {
			// File Output
			// Creates a Bufferdwriter object. Then writes the output to the file output
			// directory that was inputted in method getOutputFile. The outputted file will
			// be in CSV format titled ngramOutputG00411386.csv.
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath + "/ngramOutputG00411386.csv"));
			// Loops through the array. On each loop, it creates a new line and outputs each
			// ngram frequency to file ngramOutputG00411386.csv. It is saved in the inputted
			// output file directory.
			for (String frequency : frequencys) {
				// Write
				writer.write("\n" + frequency);
			}
			// Close writer
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
