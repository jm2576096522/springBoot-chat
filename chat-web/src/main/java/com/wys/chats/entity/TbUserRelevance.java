package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-17 23:41:55'.
*/
public class TbUserRelevance implements Serializable {
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
    * 好友编号
    */
    private int friendId;

    /**
    * 分组编号
    */
    private int userGroupId;

    /**
    * 备注
    */
    private String remark;

    /**
    * 上线提醒（0不提醒，1提醒）
    */
    private String reminder;

    /**
    * 状态表（0不在线，1在线，2忙碌，3隐身）
    */
    private int status;

    /**
    * 
    */
    private int isdelete;


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

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

}