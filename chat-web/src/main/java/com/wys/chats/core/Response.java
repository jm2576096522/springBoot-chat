package com.wys.chats.core;


import java.io.Serializable;

/**
 * 响应参数类
 * <p>
 * Created by HuangKai on 2017/8/29.
 */
public class Response implements Serializable {

    private int status;
    private String msg;
    private Object data;

    public Response(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public Response(SystemCode status, Object data) {
        this(status.getKey(), status.getValue(), data);
    }

    public Response(int status, String msg, Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
