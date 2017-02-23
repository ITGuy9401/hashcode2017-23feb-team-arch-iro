package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.List;

public class Endpoint {

	private Long id;
	private Long datacenterLatencyMs;
	private List<Connection> cacheConnections = new ArrayList<Connection>();
	private List<Request> requests = new ArrayList<Request>();

	public Endpoint(Long id, Long datacenterLatencyMs) {
		this.id = id;
		this.datacenterLatencyMs = datacenterLatencyMs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDatacenterLatencyMs() {
		return datacenterLatencyMs;
	}

	public void setDatacenterLatencyMs(Long datacenterLatencyMs) {
		this.datacenterLatencyMs = datacenterLatencyMs;
	}

	public List<Connection> getCacheConnections() {
		return cacheConnections;
	}

	public void setCacheConnections(List<Connection> cacheConnections) {
		this.cacheConnections = cacheConnections;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

}
