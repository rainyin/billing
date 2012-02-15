package com.rainy.billing.util;

import java.util.HashMap;
import java.util.Map;

import com.rainy.billing.enumeration.Carrier;

/**
 * Title: <br>
 * Description: 匹配运营商用
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
public class CarrierMatcherUtil {
	
	private static final Map<String, Carrier> CARRIERS = new HashMap<String, Carrier>();
	
	static {		
		CARRIERS.put("46000", Carrier.CMCC);
		CARRIERS.put("46002", Carrier.CMCC);
		CARRIERS.put("46007", Carrier.CMCC);
		
		CARRIERS.put("46001", Carrier.CUCC);	
	}
	
	public static Carrier getKeyByValue(String carrierCode) {
		return CARRIERS.get(carrierCode);
	}

}
