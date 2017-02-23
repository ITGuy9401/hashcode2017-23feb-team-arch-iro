package eu.arcangelovicedomini.hashcode.oqr2017;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import eu.arcangelovicedomini.hashcode.oqr2017.FileReader.Data;
import eu.arcangelovicedomini.hashcode.oqr2017.data.CacheServer;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Connection;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Request;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

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
