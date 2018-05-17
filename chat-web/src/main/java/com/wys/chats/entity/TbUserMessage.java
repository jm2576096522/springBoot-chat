package com.wys.chats.entity;
import java.io.Serializable;
import java.util.Date;

/**
*  
*
*  Created by wangyanshu on '2018-05-17 23:31:43'.
*/
public class TbUserMessage implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 消息编号
    */
    private int id;

    /**
    * 用户编号
    */
    private int userId;

    /**
    * 好友编号
    */
    private int friendId;

    /**
    * 消息内容
    */
    private Object msgInfo;

    /**
    * 文件地址
    */
    private String resourceUrl;

    /**
    * 发送时间
    */
    private Date sendTime;

    /**
    * 消息状态（0未读，1已读）
    */
    private String msgState;


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

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
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

    public String getMsgState() {
        return msgState;
    }

    public void setMsgState(String msgState) {
        this.msgState = msgState;
    }

	@Override
	public String toString() {
		return "TbUserMessage [id=" + id + ", userId=" + userId + ", friendId=" + friendId + ", msgInfo=" + msgInfo
				+ ", resourceUrl=" + resourceUrl + ", sendTime=" + sendTime + ", msgState=" + msgState + "]";
	}

    
}