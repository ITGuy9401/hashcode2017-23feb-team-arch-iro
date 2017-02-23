package eu.arcangelovicedomini.hashcode.oqr2017;

import eu.arcangelovicedomini.hashcode.oqr2017.FileReader.Data;
import eu.arcangelovicedomini.hashcode.oqr2017.FileWriter.Output;

/**
 * Hashcode 2017 - Team arch-iro
 * 
 * Loader app
 * 
 * @author arch-iro
 * 
 */
public class App {

	public static void main(String[] args) {
		if (args == null || args.length != 2) {
			throw new IllegalArgumentException("Wrong input. Pass as first argument "
					+ "the relative or absolute path of the file encoded in UTF-8 and "
					+ "as second argument the relative or absolute path of the output file");
		}
		
		String inputFile = args[0];
		String outputFile = args[1];

		FileReader reader = new FileReader(inputFile);
		Data data = reader.processFile();
		
		Output output = new Output();
		//FIXME valorizzare output
		FileWriter writer = new FileWriter();
		try {
			writer.writeFile(output, outputFile);
		} catch (Throwable th) {
			throw new RuntimeException("Error while writing file: " + th.getMessage(), th);
		}
	}
}
