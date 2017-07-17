package cn.feng.utils.sms.entity;

import java.util.List;

/**
 * 短信发送实体
 * 
 * @author Administrator
 *
 */
public class SendSms {

	// 企业id :企业ID，为空不需要
	private String userid;
	// 发送用户帐号 :用户帐号，由系统管理员
	private String account;
	// 发送帐号密码:用户账号对应的密码

	private String password;
	// 全部被叫号码:发信发送的目的号码.多个号码之间用半角逗号隔开 
	private List<String> mobile;
	// 发送内容: 短信的内容，内容需要UTF-8编码
	private String content;
	// 定时发送时间:为空表示立即发送，定时发送格式2010-10-24 09:08:10
	private String sendTime;
	// 发送任务命令
	private String action;
	// 扩展子号:请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多5位数。
	private String extno;

	private String[]demo;
	
	
	
	public String[] getDemo() {
		return demo;
	}

	public void setDemo(String[] demo) {
		this.demo = demo;
	}

	/** 获取企业id */
	public String getUserid() {
		return userid;
	}

	/** 设置企业id */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/** 获取 发送用户帐号 */
	public String getAccount() {
		return account;
	}

	/** 设置发送用户帐号 */
	public void setAccount(String account) {
		this.account = account;
	}

	/** 获取:发送帐号密码 */
	public String getPassword() {
		return password;
	}

	/** 设置:发送帐号密码 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 获取全部被叫号码 */
	public List<String> getMobile() {
		return mobile;
	}

	/** 设置 全部被叫号码 */
	public void setMobile(List<String> mobile) {
		this.mobile = mobile;
	}

	/** 获取 发送内容 */
	public String getContent() {
		return content;
	}

	/** 设置发送内容 */
	public void setContent(String content) {
		this.content = content;
	}

	/** 获取 定时发送时间 */
	public String getSendTime() {
		return sendTime;
	}

	/** 设置定时发送时间 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	/** 获取发送任务命令 */
	public String getAction() {
		return action;
	}

	/** 设置 发送任务命令 */
	public void setAction(String action) {
		this.action = action;
	}

	/** 获取扩展子号 */
	public String getExtno() {
		return extno;
	}

	/** 设置扩展子号 */
	public void setExtno(String extno) {
		this.extno = extno;
	}

}
