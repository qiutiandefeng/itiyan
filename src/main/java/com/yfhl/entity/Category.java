package com.yfhl.entity;

import java.util.List;

/**
 * 商品类目实体类
 * 
 * @author luans
 * @date 2015年11月23日
 *
 */
public class Category {
	private Integer categoryId;// 类目唯一编号

	private String title;// 类目名称

	private Integer parentId;// 父类ID

	private Integer cgOrder;// 同一类别下的排序

	// 自定义字段
	private String condition;// 模糊查询条件
	List<Category> list;// 一级目录用于存放二级目录
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
	private Integer markMoveType;// 标记移动类型：1：上移；2：下移

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getCgOrder() {
		return cgOrder;
	}

	public void setCgOrder(Integer cgOrder) {
		this.cgOrder = cgOrder;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	public Integer getMarkMoveType() {
		return markMoveType;
	}

	public void setMarkMoveType(Integer markMoveType) {
		this.markMoveType = markMoveType;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title
				+ ", parentId=" + parentId + ", cgOrder=" + cgOrder
				+ ", condition=" + condition + ", list=" + list
				+ ", markManage=" + markManage + ", markMoveType="
				+ markMoveType + "]";
	}

}