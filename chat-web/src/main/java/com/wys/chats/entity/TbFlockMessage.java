package com.wys.chats.entity;
import java.io.Serializable;
import java.util.Date;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:05:06'.
*/
public class TbFlockMessage implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 编号
    */
    private int id;

    /**
    * 用户编号
    */
    private int userId;

    /**
    * 群编号
    */
    private int flockId;

    /**
    * 消息内容
    */
    private Object msgInfo;

    /**
    * 文件资源
    */
    private String resourceUrl;

    /**
    * 发送时间
    */
    private Date sendTime;

    /**
    * 已读用户编号（逗号分割用户编号）
    */
    private String readUserId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlockId() {
        return flockId;
    }

    public void setFlockId(int flockId) {
        this.flockId = flockId;
    }

    public Object getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(Object msgInfo) {
        this.msgInfo = msgInfo;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getReadUserId() {
        return readUserId;
    }

    public void setReadUserId(String readUserId) {
        this.readUserId = readUserId;
    }

}