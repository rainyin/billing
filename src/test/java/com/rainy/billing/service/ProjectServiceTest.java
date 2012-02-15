package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Project;
import com.rainy.billing.model.ProjectVo;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class ProjectServiceTest extends AbstractServiceTest {
	
	@Autowired
	private ProjectService projectService;
	
	private Project createProject(){
		Project project = new Project();
		project.setName("test");
		
		projectService.operateProject(project);
		return project;
	}
	
	@Test
	public void testGetProjectById(){
		Project project = projectService.getProjectById(1L);
		
		print("testGetProjectById: project=" + project);
	}
	
	@Test
	public void testCreateProject(){
		Project project = createProject();
		
		print("testCreateProject: project=" + project);
	}
	
	@Test
	public void testUpdateProject(){
		Project project = createProject();
		project.setName("122121");
		projectService.updateProject(project);
		
		print("testUpdateProject: project=" + project);
	}
	
	@Test
	public void testDeleteProject(){
		Project project = createProject();
		projectService.deleteProject(project.getId());
		
		print("testDeleteProject: id=" + project.getId());
	}
	
	@Test
	public void testQueryProjectByName(){
		Project project = createProject();
		List<Project> list = projectService.queryProjectByName(project.getName());
		
		print("testQueryProjectByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryProject(){
		ProjectVo vo = new ProjectVo();
		vo.setName(createProject().getName());
		List<Project> list = projectService.pageQueryProject(vo);
		
		print("testPageQueryProject: size=" + list.size());
	}
	
	@Test
	public void testAllCustomer(){
		String str = projectService.allCustomerToString();
		
		print("testAllCustomer: str=" + str);
	}
}
