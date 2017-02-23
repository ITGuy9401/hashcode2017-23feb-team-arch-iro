package eu.arcangelovicedomini.hashcode.oqr2017;

import java.io.File;
import java.util.List;

import eu.arcangelovicedomini.hashcode.oqr2017.data.CacheServer;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

/**
 * Loader app
 * 
 * @author arch-iro
 */
public class App {

	private static Long videosNumber;
	private static Long endpointsNumber;
	private static Long requestDescriptionsNumber;
	private static Long cacheServersNumber;
	private static Long cacheServerCapacityMb;
	private static List<CacheServer> chacheServers;
	private static List<Endpoint> endpoints;
	private static List<Video> videos;

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			throw new IllegalArgumentException(
					"Wrong input. Pass as first (and only) argument " 
							+ "the relative or absolute path of the file");
		}
		
		File inputFile = new File(args[0]);
	}
}
