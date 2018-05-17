package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:43:24'.
*/
public class TbUserGroupInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 分组编号
    */
    private int id;

    /**
    * 用户编号
    */
    private int userId;

    /**
    * 分组名
    */
    private String userGroupName;

    /**
    * 分组状态（0 删除、1正常）
    */
    private String userGroupStatus;


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

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserGroupStatus() {
        return userGroupStatus;
    }

    public void setUserGroupStatus(String userGroupStatus) {
        this.userGroupStatus = userGroupStatus;
    }

}