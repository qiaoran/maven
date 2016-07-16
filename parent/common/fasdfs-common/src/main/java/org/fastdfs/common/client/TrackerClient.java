package org.fastdfs.common.client;

import java.io.IOException;
import java.util.List;

import org.fastdfs.common.data.GroupInfo;
import org.fastdfs.common.data.Result;
import org.fastdfs.common.data.StorageInfo;
import org.fastdfs.common.data.UploadStorage;

public interface TrackerClient {

	public Result<UploadStorage> getUploadStorage() throws IOException;
	public Result<String> getUpdateStorageAddr(String group, String fileName) throws IOException;
	public Result<String> getDownloadStorageAddr(String group, String fileName) throws IOException;
	public Result<List<GroupInfo>> getGroupInfos() throws IOException;
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException;
	public void close() throws IOException;
	
}
