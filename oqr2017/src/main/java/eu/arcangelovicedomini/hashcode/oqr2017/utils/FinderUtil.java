package eu.arcangelovicedomini.hashcode.oqr2017.utils;

import java.util.HashMap;
import java.util.Map;

import eu.arcangelovicedomini.hashcode.oqr2017.FileReader.Data;
import eu.arcangelovicedomini.hashcode.oqr2017.data.CacheServer;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Request;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

public class FinderUtil {
	
	private static Map<Endpoint, Map<Video, Long>> videoRequests = new HashMap<>();
	private static Map<Endpoint, Map<CacheServer, Long>> cacheServerLatency = new HashMap<>();
	
	public static void initializer(Data data) {
		for (Endpoint endpoint : data.endpoints) {
			if (videoRequests.get(endpoint) == null) {
				videoRequests.put(endpoint, new HashMap<>());
			}
			for (Request r : endpoint.getRequests()) {
				videoRequests.get(endpoint).put(r.getVideo(), r.getRequests());
			}
		}
	}
	
	public static Long findRequestForVideo(Endpoint e, Video v) {
		return videoRequests.get(e).get(v);
	}
	
	public static Long getLatency(Endpoint e, CacheServer s) {
		return cacheServerLatency.get(e).get(s);
	}
}
