package com.rainy.billing;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-18
 * @author rainy
 * @version 1.0
 */
public class Constant {

	public static final String INITIAL_PASSWD = "123456"; //用户初始密码
	public static final Long INITIAL_ID = -1L; // entity id 初始值
	public static final String AREA_DELIMITER = "_"; // areaLink 分隔符
	
	public static final String CH_RESPONSE_DELIMITER = "\n"; // 通道请求返回值分隔符
	public static final String SMS_KEY_DELIMITER = "|"; // 屏蔽关键字分隔符
	public static final String SMS_NUM_DELIMITER = "@"; // 下行号码结尾符
	
	public static final int SEQUENCE_SIZE = 30; // sequence 缓存大小
	public static final String SEQUENCE_UID = "UID"; // 流水号 sequence
	public static final int SEQUENCE_UID_LENGTH = 6; // 流水号长度
	public static final String UID_PREFIX = "0001"; // 流水号序列号前缀
	public static final String SEQUENCE_JID = "JID"; // 计费流水号 sequence
	public static final int SEQUENCE_JID_LENGTH = 12; // 计费流水号长度

	
}
