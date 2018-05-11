package com.wys.chats.Controller;

/**
 * SystemCode
 * Created by HuangKai on 2017/8/29.
 */
public enum SystemCode {
	
	code_1000(1000, "操作成功", "success"),
	code_1001(1001, "参数异常", "parameter  error"),
	code_1005(1005, "文件已存在", "file already exist"),
	code_1006(1006, "路径不存在", "path does not exist"),
	code_1002(1002, "服务器异常", "Internal Error"),
	code_1003(1003, "验证不通过", "Validate No Pass"),
	code_1004(1004, "非法请求", "Validate No Pass"),
	code_1007(1007, "校验通过", "Check success"),
	code_1008(1008, "校验失败", "Check failure"),
	code_1009(1009, "没有绑定设备", "No binding device"),
	code_1010(1010, "病床上没有病人", "No patient in bed"),
	code_1011(1011, "尚未交班,无法统计历史交班记录", "No data"),
	code_1012(1012, "该功能配置异常,请先正确配置", "This feature is configured with exceptions"),
	code_1013(1013, "该操作已执行，请勿重复操作", "This operation has been executed, don't repeat please"),
	code_1014(1014, "交班类型与床号有重复,请修改", "The handoverType and bedNumber are repeated"),
	code_1015(1015, "选项已关联,请先解除关联", "The option has been associated, please disassociate first"),
	code_1016(1016, "该角色已经关联用户", "The role has been associated with the user"),
	code_1017(1017, "至少勾选一项", "Choose at least one"),
	code_1018(1018, "该用户已绑定为病床的责任护士,请先到用户所属病区解除绑定", "The user has been bound as the nurse of responsibility for the hospital bed. Please remove the binding from the patient's ward first"),
	code_1019(1019, "该病区尚未配置概览模版/暂无数据,请先配置", "An overview template has not been configured for this area"),
	code_1020(1020, "验证码输入错误", "Verification code error"),
	code_1021(1021, "用户名/密码错误", "Account or password error"),
	code_1022(1022, "原密码输入错误", "Original password input error");

	
	private SystemCode(int key, String value , String className) {
		this.key = key;
		this.value = value;
		this.className = className;
	}

	private int key;
	private String value;
	private String className;

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className){
		this.className = className;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}
