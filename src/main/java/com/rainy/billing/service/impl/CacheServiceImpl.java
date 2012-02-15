package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.rainy.billing.dao.ProjectDao;
import com.rainy.billing.entity.Project;
import com.rainy.billing.service.CacheService;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-1
 * @author rainy
 * @version 1.0
 */
@Service
public class CacheServiceImpl extends BaseService implements CacheService {

	private Cache projectCache;
	private Object projectMutex = new Object();
	@Autowired
	private ProjectDao projectDao;
	
	@SuppressWarnings("unused")
	private void initProjectCache() {
		log.info("load all project");
		List<Project> projects = projectDao.queryEntity(new HashMap<String, Object>());
		for(Project pro : projects) {
			Element projectElement = new Element(pro.getId(), pro);
			projectCache.put(projectElement);
		}
	}
	
	private Project addProject(Long projectId) {
		Project project = projectDao.getEntityById(projectId);
		if(project == null) {
			log.info("project not exist with id: " + projectId);
			return null;
		}
		
		Element projectElement = new Element(projectId, project);
		projectCache.put(projectElement);
		
		log.info("project not hit");
		return project;
	}
 
	@Override
	public Project getProject(Long projectId) {
		synchronized(projectMutex) {
			Element projectElement = projectCache.get(projectId);
			if(projectElement == null){
				return addProject(projectId);
			}
			return (Project)projectElement.getValue();
		}
	}

	@Override
	public void removeProject(Long projectId) {
		log.info("project is removed from cache : " + projectId);
		synchronized(projectMutex) {
			projectCache.remove(projectId);
		}
	}

	public void setProjectCache(Cache projectCache) {
		this.projectCache = projectCache;
	}
	
}
