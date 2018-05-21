package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:43:59'.
*/
public class TbRoleInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 角色编号（主键）
    */
    private int id;

    /**
    * 角色名
    */
    private String roleName;

    /**
    * 角色状态
    */
    private String roleState;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState;
    }

}