package com.shangqiu.school.fastDFS.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import com.shangqiu.school.fastDFS.command.CloseCmd;
import com.shangqiu.school.fastDFS.command.Command;
import com.shangqiu.school.fastDFS.command.GroupInfoCmd;
import com.shangqiu.school.fastDFS.command.QueryDownloadCmd;
import com.shangqiu.school.fastDFS.command.QueryUpdateCmd;
import com.shangqiu.school.fastDFS.command.QueryUploadCmd;
import com.shangqiu.school.fastDFS.command.StorageInfoCmd;
import com.shangqiu.school.fastDFS.data.GroupInfo;
import com.shangqiu.school.fastDFS.data.Result;
import com.shangqiu.school.fastDFS.data.StorageInfo;
import com.shangqiu.school.fastDFS.data.UploadStorage;

public class TrackerClientImpl implements TrackerClient{
	
	private Socket socket;
	private String host;
	private Integer port;
	private Integer connectTimeout;
	private Integer networkTimeout;

	public TrackerClientImpl(String address,Integer connectTimeout, Integer networkTimeout){
		super();
		String[] hostport = address.split(":");
		this.host = hostport[0];
		this.port = Integer.valueOf(hostport[1]);
		this.connectTimeout = connectTimeout;
		this.networkTimeout = networkTimeout;
	}
	
	private Socket getSocket() throws IOException{
		if(socket==null){
			socket = new Socket();
			socket.setSoTimeout(networkTimeout);
			socket.connect(new InetSocketAddress(host, port),connectTimeout);
		}
		return socket;
	}
	

	public void close() throws IOException{
		Socket socket = getSocket();
		Command<Boolean> command = new CloseCmd();
		command.exec(socket);
		socket.close();
		socket = null;
	}

	
	public Result<UploadStorage> getUploadStorage() throws IOException{
		Socket socket = getSocket();
		Command<UploadStorage> command = new QueryUploadCmd();
		return command.exec(socket);
	}
	
	public Result<String> getUpdateStorageAddr(String group,String fileName) throws IOException{
		Socket socket = getSocket();
		Command<String> cmd = new QueryUpdateCmd(group,fileName);
		return cmd.exec(socket);
	}
	
	public Result<String> getDownloadStorageAddr(String group,String fileName) throws IOException{
		Socket socket = getSocket();
		Command<String> cmd = new QueryDownloadCmd(group,fileName);
		return cmd.exec(socket);
	}
	
	public Result<List<GroupInfo>> getGroupInfos() throws IOException{
		Socket socket = getSocket();
		Command<List<GroupInfo>> cmd = new GroupInfoCmd();
		return cmd.exec(socket);
	}
	
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException{
		Socket socket = getSocket();
		Command<List<StorageInfo>> cmd = new StorageInfoCmd(group);
		return cmd.exec(socket);
	}
	
}
