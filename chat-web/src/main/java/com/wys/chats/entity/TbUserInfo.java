package com.wys.chats.entity;

import java.io.Serializable;

/**
*  用户信息表
*
*  Created by xuxueli on '2018-05-16 22:50:01'.
*/
public class TbUserInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 用户编号(主键)
    */
    private int id;

    /**
    * 用户名
    */
    private String name;

    /**
    * 真实姓名
    */
    private String nickName;

    /**
    * 密码
    */
    private String password;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 身份证
    */
    private String idCard;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 图像地址
    */
    private String image;

    /**
    * 角色编号
    */
    private int roleId;

    /**
    * 用户状态（0删除，1正常，2停用）
    */
    private String isdelete;

    /**
    * 第三方接口ID
    */
    private String otherId;

    /**
    * 第三方接口name
    */
    private String otherName;

    /**
    * 第三方类型type
    */
    private String otherType;

    /**
    * 浏览量
    */
    private int viewCount;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

	@Override
	public String toString() {
		return "TbUserInfo [id=" + id + ", name=" + name + ", nickName=" + nickName + ", password=" + password
				+ ", email=" + email + ", idCard=" + idCard + ", phone=" + phone + ", image=" + image + ", roleId="
				+ roleId + ", isdelete=" + isdelete + ", otherId=" + otherId + ", otherName=" + otherName
				+ ", otherType=" + otherType + ", viewCount=" + viewCount + "]";
	}

}