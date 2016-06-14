package com.shangqiu.school.fastDFS.command;


import java.io.IOException;
import java.net.Socket;

import com.shangqiu.school.fastDFS.data.Result;

public class CloseCmd extends AbstractCmd<Boolean> {
	
	public CloseCmd() {
		super();
		this.requestCmd = FDFS_PROTO_CMD_QUIT;
	}


	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		return new Result<Boolean>(SUCCESS_CODE,true);
	}


}
