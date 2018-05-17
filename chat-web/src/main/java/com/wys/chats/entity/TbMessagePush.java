package com.wys.chats.entity;
import java.io.Serializable;
import java.util.Date;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:29:37'.
*/
public class TbMessagePush implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 
    */
    private int id;

    /**
    * 推送标题
    */
    private String title;

    /**
    * 推送内容
    */
    private String msg;

    /**
    * 推送类型（0管理员可见，1为VIP，2为普通）
    */
    private String type;

    /**
    * 推送时间
    */
    private Date time;

    /**
    * 推送（状态0删除，1有效，2无效）
    */
    private String state;

    /**
    * 发布者id
    */
    private int userId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}