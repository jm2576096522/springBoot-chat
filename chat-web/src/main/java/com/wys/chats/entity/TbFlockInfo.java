package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:00:46'.
*/
public class TbFlockInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 群编号（主键）
    */
    private int id;

    /**
    * 群名称
    */
    private int name;

    /**
    * 群密码
    */
    private String password;

    /**
    * 创建人id
    */
    private int userId;

    /**
    * 群头像
    */
    private String image;

    /**
    * 全体是否发言（0禁言，1正常）
    */
    private int status;

    /**
    * 群状态（0解散，1正常，2密码加入，3拒绝加入）
    */
    private int isdelete;

    /**
    * 群公告
    */
    private Object remark;

    /**
    * 最大人数
    */
    private int maxNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

}