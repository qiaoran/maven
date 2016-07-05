package org.fastdfs.common.command;


import java.io.IOException;
import java.net.Socket;

import org.fastdfs.common.data.Result;

public class ActiveTestCmd extends AbstractCmd<Boolean> {

	public ActiveTestCmd() {
		super();
		this.requestCmd = FDFS_PROTO_CMD_ACTIVE_TEST;
	}

	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
        Response response = response(socket.getInputStream());
        if(response.isSuccess()) {
            return new Result<Boolean>(SUCCESS_CODE,true);
        }else {
            return new Result<Boolean>(response.getCode(),false);
        }
	}
}
