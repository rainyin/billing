package com.rainy.billing.model.service;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: 手机端通道请求响应格式 
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-27
 * @author rainy
 * @version 1.0
 */
public class ChanResponse {
	/******************* SET部分 *******************/
	private String maxfee; // 该项目月最大扣费金额
	private String blacktime; // 短信屏蔽时间间隔
	private String circle; // 同步周期，精确到分钟
	private String wh1; // 有效相应时间起点
	private String wh2; // 有效相应时间终点
	private String smskey; // xxxx| yyyy^xxx|, yyyy 为开始标志，xxx 为截取标志
	private String hide; // 是否屏蔽短信0否1是
	private String uid; // 流水号
	private String cat; // 短信猫
	private String cs; // 切换服务器
	private String ext; // 扩展指令

	/******************* SMS部分 *******************/
	private List<SmsChan> smsList; // 
	private String jid1; // 计费流水号

	/******************* IVR部分 *******************/
	private String phone; // 拔打号码
	private String time; // 通话时长
	private String delay; // 延时
	private String dtmf; // 电话接通后按键顺序
	private String jid2; // 计费流水号

	/******************* G+部分 *******************/
	private String url; // url
	private String step; // 步骤
	private String canceldate; // 退订日期
	private String ua; // 手机型号
	private String xWapProfile; // wap profile
	private String jid3; // 计费流水号

	// 更改服务 ip:port/app

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

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getWh1() {
		return wh1;
	}

	public void setWh1(String wh1) {
		this.wh1 = wh1;
	}

	public String getWh2() {
		return wh2;
	}

	public void setWh2(String wh2) {
		this.wh2 = wh2;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public List<SmsChan> getSmsList() {
		return smsList;
	}

	public void setSmsList(List<SmsChan> smsList) {
		this.smsList = smsList;
	}

	public String getJid1() {
		return jid1;
	}

	public void setJid1(String jid1) {
		this.jid1 = jid1;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDtmf() {
		return dtmf;
	}

	public void setDtmf(String dtmf) {
		this.dtmf = dtmf;
	}

	public String getJid2() {
		return jid2;
	}

	public void setJid2(String jid2) {
		this.jid2 = jid2;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}

	public String getJid3() {
		return jid3;
	}

	public void setJid3(String jid3) {
		this.jid3 = jid3;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getxWapProfile() {
		return xWapProfile;
	}

	public void setxWapProfile(String xWapProfile) {
		this.xWapProfile = xWapProfile;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	private String toSetString() {
		StringBuilder str = new StringBuilder();

		str.append("SET:");
		if(StringUtil.isNotBlank(maxfee)) str.append("maxfee=" + StringUtil.toUnicode(maxfee));
		if(StringUtil.isNotBlank(blacktime)) str.append("&blacktime=" + StringUtil.toUnicode(blacktime));
		if(StringUtil.isNotBlank(circle)) str.append("&circle=" + StringUtil.toUnicode(circle));
		if(StringUtil.isNotBlank(wh1)) str.append("&wh1=" + StringUtil.toUnicode(wh1));
		if(StringUtil.isNotBlank(wh2)) str.append("&wh2=" + StringUtil.toUnicode(wh2));
		if(StringUtil.isNotBlank(hide)) str.append("&hide=" + StringUtil.toUnicode(hide));
		if(StringUtil.isNotBlank(smskey)) str.append("&smskey=" + StringUtil.toUnicode(smskey));
		if(StringUtil.isNotBlank(uid)) str.append("&UID=" + uid);
		if(StringUtil.isNotBlank(cat)) str.append("&CAT=" + StringUtil.toUnicode(cat));
		if(StringUtil.isNotBlank(cs)) str.append("&cs=" + StringUtil.toUnicode(cs));
		if(StringUtil.isNotBlank(ext)) str.append("&ext=" + StringUtil.toUnicode(ext));
		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}

	private String toSmsString() {
		StringBuilder str = new StringBuilder();
		str.append("SMS:count=" + smsList.size());

		for (int i = 0; i < smsList.size(); i++) {
			if(StringUtil.isNotBlank(smsList.get(i).getCmd()))  str.append("&cmd" + i + "=" + StringUtil.toUnicode(smsList.get(i).getCmd()));
			if(StringUtil.isNotBlank(smsList.get(i).getSpid()))  str.append("&spid" + i + "=" + StringUtil.toUnicode(smsList.get(i).getSpid()));
			if(StringUtil.isNotBlank(smsList.get(i).getFee()))  str.append("&fee" + i + "=" + StringUtil.toUnicode(smsList.get(i).getFee()));
			if(StringUtil.isNotBlank(smsList.get(i).getRepeat()))  str.append("&repeat" + i + "=" + StringUtil.toUnicode(smsList.get(i).getRepeat()));
		}
		str.append("&jid=" + jid1);
		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}

	private String toIvrString() {
		StringBuilder str = new StringBuilder();

		str.append("IVR:");
		if(StringUtil.isNotBlank(phone))  str.append("phone=" + StringUtil.toUnicode(phone));
		if(StringUtil.isNotBlank(time)) str.append("&time=" + StringUtil.toUnicode(time));
		if(StringUtil.isNotBlank(delay)) str.append("&delay=" + StringUtil.toUnicode(delay));
		if(StringUtil.isNotBlank(dtmf)) str.append("&dtmf=" + StringUtil.toUnicode(dtmf));
		str.append("&jid=" + jid2);
		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}

	private String toGpString() {
		StringBuilder str = new StringBuilder();

		str.append("GJ:");
		if(StringUtil.isNotBlank(url)) str.append("url=" + StringUtil.toUnicode(url));
		if(StringUtil.isNotBlank(step)) str.append("&step=" + StringUtil.toUnicode(step));
		if(StringUtil.isNotBlank(canceldate)) str.append("&canceldate=" + StringUtil.toUnicode(canceldate));
		if(StringUtil.isNotBlank(ua)) str.append("&ua=" + StringUtil.toUnicode(ua));
		if(StringUtil.isNotBlank(xWapProfile)) str.append("&x-wap-profile=" + StringUtil.toUnicode(xWapProfile));
		str.append("&jid=" + jid3);
		str.append(Constant.CH_RESPONSE_DELIMITER);

		return str.toString();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(300);

		str.append(toSetString());
		if (jid1 != null) {
			str.append(toSmsString());
		}
		if (jid2 != null) {
			str.append(toIvrString());
		}
		if (jid3 != null) {
			str.append(toGpString());
		}
		str.deleteCharAt(str.lastIndexOf(Constant.CH_RESPONSE_DELIMITER));
		
		return str.toString();
	}

}
