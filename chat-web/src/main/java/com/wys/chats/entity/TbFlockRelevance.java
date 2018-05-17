package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:10:44'.
*/
public class TbFlockRelevance implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 关联编号
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
    * 备注
    */
    private String remark;

    /**
    * 是否发言（0禁言，1正常）
    */
    private int status;

    /**
    * 用户状态（0退群，1正常，2拉黑）
    */
    private int isdelete;

    /**
    * 群角色编号（群主，管理员，普通）
    */
    private int roleId;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}