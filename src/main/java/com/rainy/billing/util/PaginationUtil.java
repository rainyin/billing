package com.rainy.billing.util;

import java.util.ArrayList;
import java.util.List;

import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-20
 * @author rainy
 * @version 1.0
 */
public class PaginationUtil {
	
	public static List<String> createCell(Object id, String... props) {
		List<String> cell = new ArrayList<String>();
		cell.add(id.toString());
		for(String prop : props) {
			cell.add(prop);
		}
		return cell;
	}
	
	public static List<RowData> entityToRow(List<? extends Pageable> entities){
		List<RowData> rows = new ArrayList<RowData>();
		Integer index = 1;
		for(Pageable entity : entities){
			rows.add(entity.toRow());
			index++;
		}
		
		return rows;
	}

}
