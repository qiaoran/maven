package com.shangqiu.school.fastDFS.client;

import java.io.IOException;
import java.util.List;

import com.shangqiu.school.fastDFS.data.GroupInfo;
import com.shangqiu.school.fastDFS.data.Result;
import com.shangqiu.school.fastDFS.data.StorageInfo;
import com.shangqiu.school.fastDFS.data.UploadStorage;

public interface TrackerClient {

	public Result<UploadStorage> getUploadStorage() throws IOException;
	public Result<String> getUpdateStorageAddr(String group, String fileName) throws IOException;
	public Result<String> getDownloadStorageAddr(String group, String fileName) throws IOException;
	public Result<List<GroupInfo>> getGroupInfos() throws IOException;
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException;
	public void close() throws IOException;
	
}
