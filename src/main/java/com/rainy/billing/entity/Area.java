package com.rainy.billing.entity;

import com.rainy.billing.Constant;
import com.rainy.billing.enumeration.AreaLevel;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Area extends BaseEntity {

	private String name;
	private String cmCode;
	private String cuCode;
	private AreaLevel level = AreaLevel.ONE;
	private Long parentId = Constant.INITIAL_ID;
	private String areaLink;

	// 非持久化字段
	private Integer treeLevel = 0;
	private Boolean leaf = true;
	private Boolean treeExpaned = false;
	private Boolean associated = false; // 是否被通道关联

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AreaLevel getLevel() {
		return level;
	}

	public void setLevel(AreaLevel level) {
		this.level = level;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getAreaLink() {
		return areaLink;
	}

	public void setAreaLink(String areaLink) {
		this.areaLink = areaLink;
	}

	public Boolean is1stLevel() {
		if (parentId == null
				|| parentId.longValue() == Constant.INITIAL_ID.longValue()) {
			return true;
		}
		return false;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Integer getTreeLevel() {
		if (areaLink != null) {
			treeLevel = areaLink.split(Constant.AREA_DELIMITER).length - 1;
		}
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	public Boolean getTreeExpaned() {
		return treeExpaned;
	}

	public void setTreeExpaned(Boolean treeExpaned) {
		this.treeExpaned = treeExpaned;
	}

	public Boolean getAssociated() {
		return associated;
	}

	public void setAssociated(Boolean associated) {
		this.associated = associated;
	}

	public String getCmCode() {
		return cmCode;
	}

	public void setCmCode(String cmCode) {
		this.cmCode = cmCode;
	}

	public String getCuCode() {
		return cuCode;
	}

	public void setCuCode(String cuCode) {
		this.cuCode = cuCode;
	}

}
