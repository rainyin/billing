package com.rainy.billing.model.service;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-9
 * @author rainy
 * @version 1.0
 */
public class SmsChan {

	private String cmd; // 通道指令
	private String spid; // 通道短信发送端口
	private String fee; // 该通道扣费金额（分）
	private String repeat; // 短信发送次数

	public SmsChan(String cmd, String spid, String fee, String repeat) {
		this.cmd = cmd;
		this.spid = spid;
		this.fee = fee;
		this.repeat = repeat;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

}