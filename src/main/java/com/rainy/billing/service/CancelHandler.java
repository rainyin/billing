package com.rainy.billing.service;

import com.rainy.billing.model.service.CancelRequest;

/**
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
public interface CancelHandler {
	
	String handle(CancelRequest cancelRequest);

}
