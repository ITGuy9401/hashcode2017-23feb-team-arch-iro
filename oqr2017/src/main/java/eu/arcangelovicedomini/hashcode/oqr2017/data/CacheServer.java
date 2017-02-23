package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {

	private Long id;
	private Long sizeMb;
	private List<Connection> connection = new ArrayList<Connection>();

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

	public List<Connection> getConnection() {
		return connection;
	}

	public void setConnection(List<Connection> connection) {
		this.connection = connection;
	}

}
