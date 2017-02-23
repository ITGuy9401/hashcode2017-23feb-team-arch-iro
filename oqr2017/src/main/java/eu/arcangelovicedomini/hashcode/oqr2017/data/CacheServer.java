package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {

	private Long id;
	private Long sizeMb;
	private List<Connection> connections = new ArrayList<Connection>();

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

}
