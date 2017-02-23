package eu.arcangelovicedomini.hashcode.oqr2017;

import java.io.File;
import java.io.FileOutputStream;

import eu.arcangelovicedomini.hashcode.oqr2017.FileWriter.Output.ServerInfo;

public class FileWriter {

	public static class Output {
		public static class ServerInfo {
			public Long serverId;
			public Long[] videoIds;
		}

		public ServerInfo[] infos;
	}
	
	public void writeFile(Output output, String filePath) throws Exception {
		int numberOfServerUsed = output.infos.length;
		StringBuilder sb = new StringBuilder();
		
		sb.append(numberOfServerUsed).append("\n");
		
		for (int i = 0; i < numberOfServerUsed; i++) {
			ServerInfo serverInfo = output.infos[i];
			sb.append(serverInfo.serverId);
			for(Long id : serverInfo.videoIds) {
				sb.append(" ").append(id);
			}
			sb.append("\n");
		}
		
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(sb.toString().getBytes());
		fos.close();
	}
}
