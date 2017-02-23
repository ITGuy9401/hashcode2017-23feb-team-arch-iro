package eu.arcangelovicedomini.hashcode.oqr2017.data;

import java.util.ArrayList;
import java.util.List;

public class Endpoint {

	private Long id;
	private Long datacenterLatencyMs;
	private List<Connection> cacheConnections = new ArrayList<Connection>();
	private List<Request> requests = new ArrayList<Request>();

	public Endpoint(Long id, Long datacenterLatencyMs) {
		super();
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

	public void addCacheConnection(Connection c) {
		this.cacheConnections.add(c);
	}

	public void addRequest(Request r) {
		this.requests.add(r);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Endpoint endpoint = (Endpoint) o;

		return id != null ? id.equals(endpoint.id) : endpoint.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
