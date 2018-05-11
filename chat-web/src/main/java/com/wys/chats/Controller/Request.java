package com.wys.chats.Controller;

import java.io.Serializable;

/**
 * request请求参数类
 *
 * Created by HuangKai on 2017/8/29.
 */
@SuppressWarnings("serial")
public class Request implements Serializable{
	
	public String id ;
	public String admId;
	public String data;
	private String bedCode;
	private Integer currPage=1;
	private Integer pageSize=10;
	private String type;
	private String keyword;
	private String wardId;
	private String userId;
	private String pid;
	private boolean yesOrNo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getBedCode() {
		return bedCode;
	}

	public void setBedCode(String bedCode) {
		this.bedCode = bedCode;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isYesOrNo() {
		return yesOrNo;
	}

	public void setYesOrNo(boolean yesOrNo) {
		this.yesOrNo = yesOrNo;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


}