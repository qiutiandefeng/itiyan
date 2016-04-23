package com.yfhl.entity;

import java.util.Date;

import com.yfhl.common.PageInfo;
/**
 * banner表
 * 
 * @author luans
 * @date 2016年3月16日
 *
 */
public class Banner {
	
    private Integer bannerid;//banner表主键ID

    private String banName;//banner名字

    private Integer banOrder;//排序

    private Integer banStation;//显示位置：1:PC端；2微信移动端；3：同步

    private String banImgurl;//图片

    private Date banAddtime;//添加时间

    private Integer banState;//状态：1展示中；2：未展示

    private Integer banNewopen;//是否打开新窗口：1：打开新窗口；2：不打开新窗口

    private Integer banDelete;//删除状态：1：正常；2：删除
	
	private Integer banModcount;//商品数量

	private String banUrlpath;//商品id字符串（链接地址）

	// 自定义属性
	private PageInfo pageInfo = new PageInfo();// 分页实体类
	private String condition;// 模糊查询条件
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
	private Integer banStation_sel;//条件查询时，按照显示位置查询
	
    public Integer getBannerid() {
        return bannerid;
    }

    public void setBannerid(Integer bannerid) {
        this.bannerid = bannerid;
    }

    public String getBanName() {
        return banName;
    }

    public void setBanName(String banName) {
        this.banName = banName == null ? null : banName.trim();
    }

    public Integer getBanOrder() {
        return banOrder;
    }

    public void setBanOrder(Integer banOrder) {
        this.banOrder = banOrder;
    }

    public Integer getBanStation() {
        return banStation;
    }

    public void setBanStation(Integer banStation) {
        this.banStation = banStation;
    }

    public String getBanImgurl() {
        return banImgurl;
    }

    public void setBanImgurl(String banImgurl) {
        this.banImgurl = banImgurl == null ? null : banImgurl.trim();
    }

    public Date getBanAddtime() {
        return banAddtime;
    }

    public void setBanAddtime(Date banAddtime) {
        this.banAddtime = banAddtime;
    }

    public Integer getBanState() {
        return banState;
    }

    public void setBanState(Integer banState) {
        this.banState = banState;
    }

    public Integer getBanNewopen() {
        return banNewopen;
    }

    public void setBanNewopen(Integer banNewopen) {
        this.banNewopen = banNewopen;
    }

    public Integer getBanDelete() {
        return banDelete;
    }

    public void setBanDelete(Integer banDelete) {
        this.banDelete = banDelete;
    }

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	public Integer getBanStation_sel() {
		return banStation_sel;
	}

	public void setBanStation_sel(Integer banStation_sel) {
		this.banStation_sel = banStation_sel;
	}

	public Integer getBanModcount() {
		return banModcount;
	}

	public void setBanModcount(Integer banModcount) {
		this.banModcount = banModcount;
	}

	public String getBanUrlpath() {
		return banUrlpath;
	}

	public void setBanUrlpath(String banUrlpath) {
		this.banUrlpath = banUrlpath;
	}

	@Override
	public String toString() {
		return "Banner [bannerid=" + bannerid + ", banName=" + banName
				+ ", banOrder=" + banOrder + ", banStation=" + banStation
				+ ", banImgurl=" + banImgurl + ", banAddtime=" + banAddtime
				+ ", banState=" + banState + ", banNewopen=" + banNewopen
				+ ", banDelete=" + banDelete + ", banModcount=" + banModcount
				+ ", banUrlpath=" + banUrlpath + ", pageInfo=" + pageInfo
				+ ", condition=" + condition + ", markManage=" + markManage
				+ ", banStation_sel=" + banStation_sel + "]";
	}
 
}