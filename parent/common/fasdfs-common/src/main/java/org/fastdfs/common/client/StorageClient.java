package org.fastdfs.common.client;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.fastdfs.common.data.Result;

public interface StorageClient {
	
	public Result<String> upload(File file, String fileName, byte storePathIndex) throws IOException;
	public Result<Boolean> delete(String group, String fileName) throws IOException;
	public Result<Boolean> setMeta(String group, String fileName, Map<String, String> meta) throws IOException;
	public Result<Map<String,String>> getMeta(String group, String fileName) throws IOException;
	public void close() throws IOException;

    /**
     * ָ�����ļ�id,��Ϊslave
     * @param file �ļ�
     * @param fileid ���ļ�id,��group,�� g1/M00/00/00/aaaabbbbccc.jpg
     * @param slavePrefix slave�ĺ�׺�� ��200x200,���յ��ļ���Ϊg1/M00/00/00/aaaabbbbccc_200x200.jpg
     * @param ext ��չ�ļ������Ϊnull,���Ϊnull�����fileid��ȡ
     * @param meta �ļ�Ԫ��ݣ�����Ϊnull
     * @return fileid ��group���ļ�fileid
     * @throws IOException
     */
    public Result<String> uploadSlave(File file, String fileid, String slavePrefix, String ext, Map<String, String> meta) throws IOException;
	public Result<String> uploadIO(InputStream file, long id, String fileName, byte storePathIndex) throws IOException;
    /**
     * check storage client socket is closed
     * @return boolean
     */
    public boolean isClosed();
}
