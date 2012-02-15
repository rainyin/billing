package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

public interface AbstractDao<T> {
	
	T getEntityById(Long id);
	
	void createEntity(T t);

	void updateEntity(T t);

	void deleteEntityById(Long id);
	
	void deleteEntityBatch(Long[] id);

	List<T> queryEntity(Map<String, Object> param);
	
	List<T> pageQueryEntity(Object vo);
}
