package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.MySequenceDao;
import com.rainy.billing.entity.MySequence;
import com.rainy.billing.service.SequenceService;
import com.rainy.billing.util.DateUtil;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-8
 * @author rainy
 * @version 1.0
 */
@Service
public class SequenceServiceImpl extends BaseService implements SequenceService {
	
	private static Map<String, Sequence> sequences = new HashMap<String, Sequence>();
	
	@Autowired
	private MySequenceDao mySequenceDao;
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		sequences.put(Constant.SEQUENCE_UID, new Sequence(Constant.SEQUENCE_UID, Constant.SEQUENCE_SIZE));
		sequences.put(Constant.SEQUENCE_JID, new Sequence(Constant.SEQUENCE_JID, Constant.SEQUENCE_SIZE));
		// 日期如果发生变化则重置UID sequence
		MySequence mySequence = mySequenceDao.getEntityByName(Constant.SEQUENCE_UID);
		String updateAt = DateUtil.formatDate(mySequence.getUpdatedAt());
		String now = DateUtil.formatDate(DateUtil.getCurrentDate());
		if(!updateAt.equals(now)) {
			mySequence.setSequence(1L);
			mySequenceDao.updateEntity(mySequence);
		}
	}

	class Sequence {

		private String name;
		private Long curValue;
		private Long maxValue;
		private int cacheSize;
		
		Sequence(String name, int cacheSize) {
			this.name = name;
			this.cacheSize = cacheSize;
			loadSequence();
		}
		
		private void loadSequence() {
			log.info("load sequence: " + name);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("name", name);
			param.put("size", cacheSize);
			
			curValue = mySequenceDao.getSequence(param);
			maxValue = curValue + cacheSize;
		}
		
		public synchronized Long getNextValue() {
			if(curValue >= maxValue) {
				log.info("current sequence: " + curValue);
				loadSequence();			
			} 
			return curValue++;
		}

	}

	@Override
	public String retrieveJid() {
		Long seq = sequences.get(Constant.SEQUENCE_JID).getNextValue();
		return StringUtil.addZero(seq.toString(), Constant.SEQUENCE_JID_LENGTH);
	}

	@Override
	public String retrieveUid() {
		Long seq = sequences.get(Constant.SEQUENCE_UID).getNextValue();
		String dateStr = DateUtil.formatCurrentDate();
		String suffix = StringUtil.addZero(seq.toString(), Constant.SEQUENCE_UID_LENGTH);
		return dateStr + Constant.UID_PREFIX + suffix;
	}

}
