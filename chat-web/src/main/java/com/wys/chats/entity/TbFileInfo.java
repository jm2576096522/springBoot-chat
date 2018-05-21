package com.wys.chats.entity;
import java.io.Serializable;
import java.util.Date;

/**
*  
*
*  Created by wangyanshu on '2018-05-18 00:23:05'.
*/
public class TbFileInfo implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
    * 文件编号（主键）
    */
    private int id;

    /**
    * 上传者编号
    */
    private int userId;

    /**
    * 接受者ID(群为群ID，用户为用户ID)
    */
    private int reserveId;

    /**
    * 文件名
    */
    private String fileName;

    /**
    * 文件内容
    */
    private String fileMsg;

    /**
    * 发送时间
    */
    private Date sendTime;

    /**
    * 文件状态（0无效，1有效）
    */
    private String fileState;

    /**
    * 文件类型
    */
    private String fileType;

    /**
    * 文件图片
    */
    private String fileImage;

    /**
    * 是否为群（0用户，1群）
    */
    private String isflock;


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

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMsg() {
        return fileMsg;
    }

    public void setFileMsg(String fileMsg) {
        this.fileMsg = fileMsg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getFileState() {
        return fileState;
    }

    public void setFileState(String fileState) {
        this.fileState = fileState;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public String getIsflock() {
        return isflock;
    }

    public void setIsflock(String isflock) {
        this.isflock = isflock;
    }

}