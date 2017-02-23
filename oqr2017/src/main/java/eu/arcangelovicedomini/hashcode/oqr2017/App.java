package eu.arcangelovicedomini.hashcode.oqr2017;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import eu.arcangelovicedomini.hashcode.oqr2017.data.CacheServer;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Connection;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

/**
 * Hashcode 2017 - Team arch-iro
 * 
 * Loader app
 * 
 * @author Arcangelo Vicedomini
 * 
 */
public class App {

	private static final String ERROR_FILE_READ = "Error while reading the file.";

	private static Long videosNumber;
	private static Long endpointsNumber;
	private static Long requestDescriptionsNumber;
	private static Long cacheServersNumber;
	private static Long cacheServerCapacityMb;
	private static List<CacheServer> cacheServers;
	private static List<Endpoint> endpoints;
	private static List<Video> videos;

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			throw new IllegalArgumentException("Wrong input. Pass as first (and only) argument "
					+ "the relative or absolute path of the file encoded in UTF-8");
		}
		String fileContent = "";
		try {
			File inputFile = new File(args[0]);
			FileInputStream fis = new FileInputStream(inputFile);
			fileContent = IOUtils.toString(fis, "UTF-8");
		} catch (Throwable th) {
			throw new IllegalArgumentException(ERROR_FILE_READ, th);
		}

		String[] lines = fileContent.split("\n");

		Long lastEndpointLineNum = null;
		Long lastEndpointConnections = null;
		int foundEndpoints = 0;

		for (int i = 0; i < lines.length; i++) {
			String[] dataset = lines[i].split(" ");
			if (i == 0) {
				for (String data : dataset) {
					Long value = Long.parseLong(data);
					if (videosNumber == null) {
						videosNumber = value;
						videos = new ArrayList<Video>(value.intValue());
					} else if (endpointsNumber == null) {
						endpointsNumber = value;
						endpoints = new ArrayList<Endpoint>(value.intValue());
					} else if (requestDescriptionsNumber == null) {
						requestDescriptionsNumber = value;
					} else if (cacheServersNumber == null) {
						cacheServersNumber = value;
					} else if (cacheServerCapacityMb == null) {
						cacheServerCapacityMb = value;
						for (int j = 0; j < cacheServersNumber.intValue(); j++) {
							cacheServers.add(new CacheServer((long) j, cacheServerCapacityMb));
						}
					} else {
						throw new IllegalArgumentException("Too many argument for line one of the file");
					}
				}
			} else if (i == 1) {
				for (Long videoId = 0L; videoId.intValue() < dataset.length; videoId++) {
					Long videoSize = Long.parseLong(dataset[videoId.intValue()]);
					videos.add(new Video(videoId, videoSize));
				}
			} else {
				if (foundEndpoints < endpointsNumber) {
					Endpoint e = new Endpoint((long) foundEndpoints++, Long.parseLong(dataset[0]));
					lastEndpointLineNum = (long) i;
					Long cachesConnections = Long.parseLong(dataset[1]);
					while (i <= (lastEndpointLineNum + cachesConnections)) {
						dataset = lines[++i].split(" ");
						Connection c = new Connection(cacheServers.get(Integer.parseInt(dataset[0])), e,
								Long.parseLong(dataset[1]));
					}
				} else {

				}
			}
		}
	}
}
