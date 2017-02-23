package eu.arcangelovicedomini.hashcode.oqr2017.data;

public class CacheServer {

	private Long id;
	private Long sizeMb;

	public CacheServer(Long id, Long sizeMb) {
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

}
