package org.fastdfs.common.client;


import org.fastdfs.common.command.AbstractCmd;

/**
 * �ṩһЩ���õĵķ���
 * Created by sunbaoming on 2014/6/23.
 */
public abstract class AbstractClient {

    protected String[] splitFileId(String fileid) {
        return AbstractCmd.splitFileId(fileid);
    }
}
