package com.shangqiu.school.fastDFS.client;


import com.shangqiu.school.fastDFS.command.AbstractCmd;

/**
 * �ṩһЩ���õĵķ���
 * Created by sunbaoming on 2014/6/23.
 */
public abstract class AbstractClient {

    protected String[] splitFileId(String fileid) {
        return AbstractCmd.splitFileId(fileid);
    }
}
