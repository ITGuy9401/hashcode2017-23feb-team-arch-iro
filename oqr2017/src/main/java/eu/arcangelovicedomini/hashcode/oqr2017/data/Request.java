package eu.arcangelovicedomini.hashcode.oqr2017.data;

public class Request {

	private Long requests;
	private Endpoint endpoint;
	private Video video;

	public Request(Long requests, Endpoint endpoint, Video video) {
		this.requests = requests;
		this.endpoint = endpoint;
		this.video = video;
	}

	public Long getRequests() {
		return requests;
	}

	public void setRequests(Long requests) {
		this.requests = requests;
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
