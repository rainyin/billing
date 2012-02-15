package com.rainy.billing.pagination;

/**
 * 
 * Title: <br>
 * Description: 需要分页的 entity 实现此接口
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-20
 * @author rainy
 * @version 1.0
 */
public interface Pageable {
	
	RowData toRow();
	
}
