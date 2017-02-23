package eu.arcangelovicedomini.hashcode.oqr2017;

import eu.arcangelovicedomini.hashcode.oqr2017.FileReader.Data;

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
		if (args == null || args.length != 1) {
			throw new IllegalArgumentException("Wrong input. Pass as first (and only) argument "
					+ "the relative or absolute path of the file encoded in UTF-8");
		}
		
		FileReader reader = new FileReader(args[0]);
		Data data = reader.processFile();
	}
}
