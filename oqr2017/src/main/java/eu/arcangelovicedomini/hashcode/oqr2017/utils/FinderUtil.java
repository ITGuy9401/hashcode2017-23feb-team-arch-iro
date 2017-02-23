package eu.arcangelovicedomini.hashcode.oqr2017.utils;

import java.util.HashMap;
import java.util.Map;

import eu.arcangelovicedomini.hashcode.oqr2017.FileReader.Data;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Endpoint;
import eu.arcangelovicedomini.hashcode.oqr2017.data.Video;

public class FinderUtil {
	
	private static Map<Endpoint, Map<Video, Long>> videoRequests = new HashMap<>();
	
	public static void initializer(Data data) {
		
	}
	
	public static Long findRequestForVideo(Endpoint e, Video v) {
		return videoRequests.get(e).get(v).longValue();
	}
}
