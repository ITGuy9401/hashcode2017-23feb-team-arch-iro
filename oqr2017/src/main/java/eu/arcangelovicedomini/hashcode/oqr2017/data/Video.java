package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.List;

public class Video implements Comparable<Video> {
	private Long id;
	private Long sizeMb;
	private List<Request> requests = new ArrayList<Request>();

	public Video(Long id, Long sizeMb) {
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

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public int compareTo(Video o) {
		return id.compareTo(o.getId());
	}

}
