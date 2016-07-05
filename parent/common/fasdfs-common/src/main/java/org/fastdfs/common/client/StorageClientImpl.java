package org.fastdfs.common.client;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

import org.fastdfs.common.command.ActiveTestCmd;
import org.fastdfs.common.command.CloseCmd;
import org.fastdfs.common.command.Command;
import org.fastdfs.common.command.DeleteCmd;
import org.fastdfs.common.command.GetMetaDataCmd;
import org.fastdfs.common.command.SetMetaDataCmd;
import org.fastdfs.common.command.UploadCmd;
import org.fastdfs.common.command.UploadSlaveCmd;
import org.fastdfs.common.data.Result;

public class StorageClientImpl extends AbstractClient implements StorageClient {

    private Socket socket;
    private String host;
    private Integer port;
    private Integer connectTimeout ;
    private Integer networkTimeout;

    private Socket getSocket() throws IOException {
        if (socket == null) {
            socket = new Socket();
            socket.setSoTimeout(networkTimeout);
            socket.connect(new InetSocketAddress(host, port), connectTimeout);
        }
        return socket;
    }



    public StorageClientImpl(String address, Integer connectTimeout, Integer networkTimeout) {
        super();
        String[] hostport = address.split(":");
        this.host = hostport[0];
        this.port = Integer.valueOf(hostport[1]);
        this.connectTimeout = connectTimeout;
        this.networkTimeout = networkTimeout;
    }

    public void close() throws IOException {
        Socket socket = getSocket();
        Command<Boolean> command = new CloseCmd();
        command.exec(socket);
        socket.close();
        socket = null;
    }

    public Result<String> uploadSlave(File file, String fileid, String slavePrefix, String ext, Map<String, String> meta) throws IOException {
        Socket socket = getSocket();
        UploadSlaveCmd uploadSlaveCmd = new UploadSlaveCmd(file,fileid,slavePrefix,ext);
        Result<String> result = uploadSlaveCmd.exec(socket);

        if (meta != null) {
            String[] tupple = super.splitFileId(fileid);
            if (tupple != null) {
                String group = tupple[0];
                String fileName = tupple[1];
                this.setMeta(group, fileName, meta);
            }
        }
        return result;
    }

    public Result<String> upload(File file, String fileName, byte storePathIndex) throws IOException {
        Socket socket = getSocket();
        UploadCmd uploadCmd = new UploadCmd(file, fileName, storePathIndex);
        return uploadCmd.exec(socket);
    }

    public Result<String> uploadIO(InputStream file, long id, String fileName, byte storePathIndex) throws IOException{
        Socket socket = getSocket();
        UploadCmd uploadCmd = new UploadCmd(file,id, fileName, storePathIndex);
        return uploadCmd.execIO(socket);
    }



    public Result<Boolean> delete(String group, String fileName) throws IOException {
        Socket socket = getSocket();
        DeleteCmd deleteCmd = new DeleteCmd(group, fileName);
        return deleteCmd.exec(socket);
    }

    public Result<Boolean> setMeta(String group, String fileName,
                                   Map<String, String> meta) throws IOException {
        Socket socket = getSocket();
        SetMetaDataCmd setMetaDataCmd = new SetMetaDataCmd(group, fileName, meta);
        return setMetaDataCmd.exec(socket);
    }

    public Result<Map<String, String>> getMeta(String group, String fileName)
            throws IOException {
        Socket socket = getSocket();
        GetMetaDataCmd getMetaDataCmd = new GetMetaDataCmd(group, fileName);
        return getMetaDataCmd.exec(socket);
    }


    /**
     * check storage client socket is closed
     *
     * @return boolean
     */
    public boolean isClosed() {

        if (this.socket == null) {
            return true;
        }

        if (this.socket.isClosed()){
            return true;
        }else {
            //����fastdfs��Active_Test_Cmd������ͨ��
            ActiveTestCmd atcmd = new ActiveTestCmd();
            try {
                Result<Boolean> result = atcmd.exec(getSocket());
                //True,��ʾ��������
                if(result.getData()){
                    return false;
                }else {
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //���쳣��ֱ�Ӷ���������ӣ������ӳػ���
            return true;
        }
    }

}
