package com.rainy.billing.util;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.service.SmsChan;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-9
 * @author rainy
 * @version 1.0
 */
public class HandlerUtil {
	
	public static String constructNumStr(String str) {
		StringBuilder target = new StringBuilder();

		target.append(str);
		target.append(Constant.SMS_NUM_DELIMITER);
		
		return target.toString();
	}
	
	/**
	 * 根据短信通道，构造相应的响应参数
	 * @param smsList 短信通道集合
	 * @param smsChans 期望的短信通道响应集合
	 * @return
	 */
	public static String constructSmsChan(List<SmsChannel> smsList, List<SmsChan> smsChans) {
		StringBuilder smsKey = new StringBuilder(100);
		for(SmsChannel smsChannel : smsList) {
			smsChans.add(new SmsChan(smsChannel.getInstruction(), smsChannel.getPort(), smsChannel.getFeeStandard().toString(),smsChannel.getSendTimes().toString()));
			if(StringUtil.isNotBlank(smsChannel.getShieldKey()) && smsKey.indexOf(smsChannel.getShieldKey()) < 0) {
				if(smsKey.length() > 0){
					smsKey.append(Constant.SMS_KEY_DELIMITER);
				}
				smsKey.append(smsChannel.getShieldKey());
			}
			if(StringUtil.isNotBlank(smsChannel.getPort()) && smsKey.indexOf(smsChannel.getPort()) < 0) {
				if(smsKey.length() > 0) {
					smsKey.append(Constant.SMS_KEY_DELIMITER);
				}
				smsKey.append(constructNumStr(smsChannel.getPort()));
			}
		}

		return smsKey.toString();
	}

}
