package com.wys.chats.entity;
import java.io.Serializable;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:26:13'.
*/
public class TbIconInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 图片编号（主键）
    */
    private int id;

    /**
    * 图片名
    */
    private String name;

    /**
    * 类型(zip/image/exe)
    */
    private String type;

    /**
    * 图标地址
    */
    private String url;

    /**
    * 图片状态（0无效，1有效）
    */
    private String state;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}