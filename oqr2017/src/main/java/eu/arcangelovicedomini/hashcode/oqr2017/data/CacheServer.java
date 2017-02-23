package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheServer {

	private Long id;
	private Long sizeMb;
	private List<Connection> connections = new ArrayList<Connection>();
	private Map<Long, CacheEntry> longVideoMap = new HashMap<>();

	public CacheServer(Long id, Long sizeMb) {
		super();
		this.id = id;
		this.sizeMb = sizeMb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSizeMb() {
		return sizeMb;
	}

	public void setSizeMb(Long sizeMb) {
		this.sizeMb = sizeMb;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connection) {
		this.connections = connection;
	}
	
	public void addConnection(Connection c) {
		this.connections.add(c);
	}

	public CacheEntry getCacheEntry(Long id) {
		return longVideoMap.get(id);
	}

	public CacheEntry putCacheEntry(Long id, Video video, long score) {
		return longVideoMap.put(video.getId(), new CacheEntry(video, score));
	}

	public CacheEntry removeCacheEntry(Long id) {
		return longVideoMap.remove(id);
	}
}
