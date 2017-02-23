package eu.arcangelovicedomini.hashcode.oqr2017;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import eu.arcangelovicedomini.hashcode.oqr2017.data.CacheServer;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Connection;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Request;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

public class FileReader {

	private final String path;
	private final Data returnData = new Data();

	public FileReader(String path) {
		super();
		this.path = path;
	}

	private static final String ERROR_FILE_READ = "Error while reading the file.";

	public static class Data {
		public Long videosNumber;
		public Long endpointsNumber;
		public Long requestDescriptionsNumber;
		public Long cacheServersNumber;
		public Long cacheServerCapacityMb;
		public List<CacheServer> cacheServers;
		public List<Endpoint> endpoints;
		public List<Video> videos;
	}

	public Data processFile() {
		String fileContent = "";
		try {
			File inputFile = new File(path);
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
					if (returnData.videosNumber == null) {
						returnData.videosNumber = value;
						returnData.videos = new ArrayList<Video>(value.intValue());
					} else if (returnData.endpointsNumber == null) {
						returnData.endpointsNumber = value;
						returnData.endpoints = new ArrayList<Endpoint>(value.intValue());
					} else if (returnData.requestDescriptionsNumber == null) {
						returnData.requestDescriptionsNumber = value;
					} else if (returnData.cacheServersNumber == null) {
						returnData.cacheServersNumber = value;
						returnData.cacheServers = new ArrayList<CacheServer>(value.intValue());
					} else if (returnData.cacheServerCapacityMb == null) {
						returnData.cacheServerCapacityMb = value;
						for (int j = 0; j < returnData.cacheServersNumber.intValue(); j++) {
							returnData.cacheServers.add(new CacheServer((long) j, returnData.cacheServerCapacityMb));
						}
					} else {
						throw new IllegalArgumentException("Too many argument for line one of the file");
					}
				}
			} else if (i == 1) {
				for (Long videoId = 0L; videoId.intValue() < dataset.length; videoId++) {
					Long videoSize = Long.parseLong(dataset[videoId.intValue()]);
					returnData.videos.add(new Video(videoId, videoSize));
				}
			} else {
				if (foundEndpoints < returnData.endpointsNumber) {
					Endpoint e = new Endpoint((long) foundEndpoints++, Long.parseLong(dataset[0]));
					lastEndpointLineNum = (long) i;
					Long cachesConnections = Long.parseLong(dataset[1]);
					while (i <= (lastEndpointLineNum + cachesConnections)) {
						dataset = lines[++i].split(" ");
						Connection c = new Connection(returnData.cacheServers.get(Integer.parseInt(dataset[0])), e,
								Long.parseLong(dataset[1]));
					}
					returnData.endpoints.add(e);
				} else {
					Request r = new Request(Long.parseLong(dataset[2]), returnData.endpoints.get(Integer.parseInt(dataset[1])),
							returnData.videos.get(Integer.parseInt(dataset[0])));
				}
			}
		}
		
		return returnData;
	}
}
