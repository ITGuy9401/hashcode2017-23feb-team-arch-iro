package eu.arcangelovicedomini.hashcode.oqr2017.data;

public class Connection {

	private CacheServer cacheServer;
	private Endpoint endpoint;
	private Long latencyMs;

	public Connection(CacheServer cacheServer, Endpoint endpoint, Long latencyMs) {
		super();
		setCacheServer(cacheServer);
		setEndpoint(endpoint);
		this.latencyMs = latencyMs;
	}

	public CacheServer getCacheServer() {
		return cacheServer;
	}

	public void setCacheServer(CacheServer cacheServer) {
		cacheServer.addConnection(this);
		this.cacheServer = cacheServer;

	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		endpoint.addCacheConnection(this);
		this.endpoint = endpoint;
	}

	public Long getLatencyMs() {
		return latencyMs;
	}

	public void setLatencyMs(Long latencyMs) {
		this.latencyMs = latencyMs;
	}

}
