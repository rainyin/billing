package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.rainy.billing.dao.AbstractDao;

public abstract class AbstractDaoImpl<T> extends SqlSessionDaoSupport implements AbstractDao<T> {
	
	public String nameSpace = this.getClass().getName() + ".";

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(Long id) {
		return (T) this.getSqlSession().selectOne(nameSpace + "getEntityById", id);
	}

	@Override
	public void updateEntity(T t) {
		this.getSqlSession().update(nameSpace + "updateEntity", t);
	}
	
	@Override
	public void createEntity(T t) {
		this.getSqlSession().insert(nameSpace + "createEntity", t);
	}

	@Override
	public void deleteEntityById(Long id) {
		this.getSqlSession().delete(nameSpace + "deleteEntityById", id);
	}
	
	@Override
	public void deleteEntityBatch(Long[] id) {
		this.getSqlSession().delete(nameSpace + "deleteEntityBatch", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryEntity(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntity", param);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> pageQueryEntity(Object vo) {
		return this.getSqlSession().selectList(nameSpace + "pageQueryEntity", vo);
	}

}
