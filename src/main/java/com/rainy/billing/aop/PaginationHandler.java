package com.rainy.billing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.rainy.billing.dao.impl.AbstractDaoImpl;
import com.rainy.billing.model.BaseVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Aspect
@Component
public class PaginationHandler {
	
	private static Log log = LogFactory.getLog(PaginationHandler.class);
	
	@Before(value="execution(* com.rainy.billing.dao..*.pageQuery*(..)) and target(dao) and args(page)")
	public void setPageInfo(JoinPoint jp,AbstractDaoImpl<?> dao,BaseVo page){

		String queryName = jp.getSignature().getName();
		Long totalRow = (Long)dao.getSqlSession().selectOne(dao.nameSpace+queryName+"Count", page);
		page.setPosStart((page.getPage() - 1) * page.getCount());
		if(totalRow!=null){
			page.setTotalCount(totalRow);
		}
		log.info("totalRow==" + totalRow);
	}

}
