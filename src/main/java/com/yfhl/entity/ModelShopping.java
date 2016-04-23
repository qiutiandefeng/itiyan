package com.yfhl.entity;

import java.util.Date;

/**
 * 购物车实体类
 * 
 * @date 2015年12月21日
 * @author luans
 *
 */
public class ModelShopping {

	private Integer msId;// 购物车主键ID

	private Integer msModelid;// 商品ID

	private String msModelname;// 商品名称

	private String msModelbrand;// 商品品牌

	private String msModelimg;// 商品图片

	private String msModtexture;// 商品材质

	private String msModcolor;// 商品颜色

	private String msModsize;// 商品尺寸

	private Integer msModcount;// 商品数量

	private Float msModprice;// 商品单价

	private Float msModtransport;// 商品运费

	private Integer msUid;// 用户iD

	private Date msAddtime;// 添加时间

	private Integer msSelfDesigner;// 商品来源：1：爱体验 2：设计师

	// 自定义字段
	private Integer markType;// 操作类型：1添加购物车；2：删除购物车
	private Float countPrice;// 商品总价
	private Integer marker_count;// 修改商品数量：1：减少 2：添加
	private Integer marker_state;// 购物车信息状态：1：正常 ；2：库存不足；3：商品下架

	public Integer getMsId() {
		return msId;
	}

	public void setMsId(Integer msId) {
		this.msId = msId;
	}

	public Integer getMsModelid() {
		return msModelid;
	}

	public void setMsModelid(Integer msModelid) {
		this.msModelid = msModelid;
	}

	public String getMsModelname() {
		return msModelname;
	}

	public void setMsModelname(String msModelname) {
		this.msModelname = msModelname == null ? null : msModelname.trim();
	}

	public String getMsModelbrand() {
		return msModelbrand;
	}

	public void setMsModelbrand(String msModelbrand) {
		this.msModelbrand = msModelbrand == null ? null : msModelbrand.trim();
	}

	public String getMsModelimg() {
		return msModelimg;
	}

	public void setMsModelimg(String msModelimg) {
		this.msModelimg = msModelimg;
	}

	public String getMsModtexture() {
		return msModtexture;
	}

	public void setMsModtexture(String msModtexture) {
		this.msModtexture = msModtexture == null ? null : msModtexture.trim();
	}

	public String getMsModcolor() {
		return msModcolor;
	}

	public void setMsModcolor(String msModcolor) {
		this.msModcolor = msModcolor == null ? null : msModcolor.trim();
	}

	public String getMsModsize() {
		return msModsize;
	}

	public void setMsModsize(String msModsize) {
		this.msModsize = msModsize == null ? null : msModsize.trim();
	}

	public Integer getMsModcount() {
		return msModcount;
	}

	public void setMsModcount(Integer msModcount) {
		this.msModcount = msModcount;
	}

	public Float getMsModprice() {
		return msModprice;
	}

	public void setMsModprice(Float msModprice) {
		this.msModprice = msModprice;
	}

	public Integer getMsUid() {
		return msUid;
	}

	public void setMsUid(Integer msUid) {
		this.msUid = msUid;
	}

	public Date getMsAddtime() {
		return msAddtime;
	}

	public void setMsAddtime(Date msAddtime) {
		this.msAddtime = msAddtime;
	}

	public Integer getMarkType() {
		return markType;
	}

	public void setMarkType(Integer markType) {
		this.markType = markType;
	}

	public Float getMsModtransport() {
		return msModtransport;
	}

	public void setMsModtransport(Float msModtransport) {
		this.msModtransport = msModtransport;
	}

	public Float getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(Float countPrice) {
		this.countPrice = countPrice;
	}

	public Integer getMarker_count() {
		return marker_count;
	}

	public void setMarker_count(Integer marker_count) {
		this.marker_count = marker_count;
	}

	public Integer getMarker_state() {
		return marker_state;
	}

	public void setMarker_state(Integer marker_state) {
		this.marker_state = marker_state;
	}

	public Integer getMsSelfDesigner() {
		return msSelfDesigner;
	}

	public void setMsSelfDesigner(Integer msSelfDesigner) {
		this.msSelfDesigner = msSelfDesigner;
	}

	@Override
	public String toString() {
		return "ModelShopping [msId=" + msId + ", msModelid=" + msModelid
				+ ", msModelname=" + msModelname + ", msModelbrand="
				+ msModelbrand + ", msModelimg=" + msModelimg
				+ ", msModtexture=" + msModtexture + ", msModcolor="
				+ msModcolor + ", msModsize=" + msModsize + ", msModcount="
				+ msModcount + ", msModprice=" + msModprice
				+ ", msModtransport=" + msModtransport + ", msUid=" + msUid
				+ ", msAddtime=" + msAddtime + ", msSelfDesigner="
				+ msSelfDesigner + ", markType=" + markType + ", countPrice="
				+ countPrice + ", marker_count=" + marker_count
				+ ", marker_state=" + marker_state + "]";
	}

}