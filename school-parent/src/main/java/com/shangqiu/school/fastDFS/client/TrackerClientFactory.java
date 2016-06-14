package com.shangqiu.school.fastDFS.client;


import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.IOException;

public class TrackerClientFactory implements KeyedPooledObjectFactory<String,TrackerClient> {
	
	private Integer connectTimeout;
	private Integer networkTimeout;

	public TrackerClientFactory() {
		super();
	}
	
	public TrackerClientFactory(Integer connectTimeout, Integer networkTimeout) {
		super();
		this.connectTimeout = connectTimeout;
		this.networkTimeout = networkTimeout;
	}

	public PooledObject<TrackerClient> makeObject(String key){
		TrackerClient trackerClient = new TrackerClientImpl(key,connectTimeout,networkTimeout);
		PooledObject<TrackerClient> pooledTrackerClient = new DefaultPooledObject<TrackerClient>(trackerClient);
		return pooledTrackerClient;
	}

	public void destroyObject(String key, PooledObject<TrackerClient> pooledTrackerClient) throws IOException{
		TrackerClient trackerClient = pooledTrackerClient.getObject();
		trackerClient.close();
	}

	public boolean validateObject(String key, PooledObject<TrackerClient> p) {
		// TODO Auto-generated method stub
		return true;
	}

	public void activateObject(String key, PooledObject<TrackerClient> p)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void passivateObject(String key, PooledObject<TrackerClient> p)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	

}
