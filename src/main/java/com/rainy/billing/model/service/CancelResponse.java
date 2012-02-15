package com.rainy.billing.model.service;

import com.rainy.billing.Constant;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: 手机端退订G+响应格式 
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-9
 * @author rainy
 * @version 1.0
 */
public class CancelResponse {

	/******************* SET部分 *******************/
	private String maxfee; // 该项目月最大扣费金额
	private String blacktime; // 短信屏蔽时间间隔
	private String smskey; // xxxx| yyyy^xxx|, yyyy 为开始标志，xxx 为截取标志
	private String hide; // 是否屏蔽短信0否1是

	/******************* G+部分 *******************/
	private String count;
	private String cmd; // 通道指令
	private String spid; // 通道短信发送端口
	private String fee; // 该通道扣费金额（分）
	private String repeat; // 短信发送次数

	public String getMaxfee() {
		return maxfee;
	}

	public void setMaxfee(String maxfee) {
		this.maxfee = maxfee;
	}

	public String getBlacktime() {
		return blacktime;
	}

	public void setBlacktime(String blacktime) {
		this.blacktime = blacktime;
	}

	public String getSmskey() {
		return smskey;
	}

	public void setSmskey(String smskey) {
		this.smskey = smskey;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	private String toSetString() {
		StringBuilder str = new StringBuilder();

		str.append("SET:");
		if(StringUtil.isNotBlank(maxfee))  str.append("maxfee=" + StringUtil.toUnicode(maxfee));
		if(StringUtil.isNotBlank(blacktime))  str.append("&blacktime=" + StringUtil.toUnicode(blacktime));
		if(StringUtil.isNotBlank(smskey))  str.append("&smskey=" + StringUtil.toUnicode(smskey));
		if(StringUtil.isNotBlank(hide))  str.append("&hide=" + StringUtil.toUnicode(hide));
		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}

	private String toGpString() {
		StringBuilder str = new StringBuilder();

		str.append("SMS:count=1");
		if(StringUtil.isNotBlank(cmd))  str.append("&cmd0=" + StringUtil.toUnicode(cmd));
		if(StringUtil.isNotBlank(spid))  str.append("&spid0=" + StringUtil.toUnicode(spid));
		if(StringUtil.isNotBlank(fee))  str.append("&fee0=0");
		if(StringUtil.isNotBlank(repeat))  str.append("&repeat0=1");

		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(300);

		str.append(toSetString());
		str.append(toGpString());
		
		str.deleteCharAt(str.lastIndexOf(Constant.CH_RESPONSE_DELIMITER));
		
		return str.toString();
	}

}
