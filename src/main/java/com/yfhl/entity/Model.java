package com.yfhl.entity;

import java.util.Date;
import java.util.List;

import com.yfhl.common.PageInfo;

/**
 * 商品管理实体层模型信息
 * 
 * @author luans
 * @date 2015年1月6日
 *
 */
public class Model {

	private Integer mid;// 模型唯一编号

	private Integer uid;// 上传用户编号

	private String title;// 名称

	private Integer orderNo;// 排序

	private Float price;// 价格

	private String multiPrice;// 多种价格

	private Integer categoryId;// 所属类目ID

	private String texture;// 材质，tid数组序列化

	private String size;// 数组序列化

	private Integer sales;// 销量

	private Integer author;// 设计师ID

	private Integer description;// 描述

	private String idea;// 设计理念

	private Integer favoriteNum;// 商品被收藏数

	private Date addTime;// 添加时间

	private Integer recommend;// 1:推荐到首页 2：不推荐

	private String img;// 图片路径，数组序列化

	private String modelUrl;// 模型文件

	private Integer status;// 1: 审核中 2:展示中 3:已下架 4:暂不出售

	private String brand;// 品牌

	private String brandPlace;// 品牌属地

	private String deliveryTime;// 送货时间

	private Integer customization;// 1:可定制 0:不可定制

	private String customizationTip;// 可定制提示信息

	private String searchtext;// 全文索引

	private Integer modCategoryParentid;// 父类别ID

	private Integer modRepertory;// 库存

	private Integer modVisitcount;// 浏览数

	private Integer modShoppingcount;// 购物车：当前有多少量在购物车

	private Date modLastupttime;// 最后修改时间

	private String modTag;// 商品标签

	private String modDetail;// 商品详情

	private Integer modDdelstate;// 商品删除状态：1.正常；2.删除

	private String modServe;// 服务

	private String modFrom;// 货品产地

	private String modElement;// 商品成份

	private String modSize;// 商品尺寸

	private String modRemark;// 商品备注

	private String modWeight;// 商品重量
	
	private Integer modSelfDesigner;//商品来源：1：爱体验 2：设计师

	// 自定义属性
	private PageInfo pageInfo = new PageInfo();// 分页实体类

	private String condition;// 模糊查询条件
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
	private Integer markCategory;// 标记查询条件：1：按父级类别查询；2：按子级类别查询
	private Integer markRecommend;//标记是否推荐：1：推荐；2：推荐 
	private String designerName;// 设计师名字
	private String categoryName;// 类别名称
	private String designerAvatar;// 设计师头像路径
	private Integer condition_categoryid;// 条件查询时，存放商品类别ID
	private String condition_categoryName;// 条件查询时，存放商品类别名称
	private Integer condition_status;// 条件查询时，存放状态
	private Integer markOrder;// pc端条件排序方式：1最新；2人气；3价格从高到低；4价格从低到高；5是否可定制
	private float beginprice;// 按价格排序是开始价格
	private float endprice;// 按价格排序时结束价格
	private List<String> imgList;// 商品图片集合
	private List<String> tagList;// 商品标签集合
	private Integer dFavoriteNum;// 设计师被收藏数--
	private Integer mcId;// 用户收藏商品表ID:用于页面判断是否被用户收藏
	private String dbrandStory;//设计师品牌故事
	private List<ModelType> texttrueList;// 商品规格：材质List
	private List<ModelType> colorList;// 商品规格：颜色List
	private List<ModelType> sizeList;// 商品规格：尺寸List
	private String modelType;// 商品规格:添加商品的时候多种规格
	private Integer msId;// 购物车ID
	private Integer startIndex;//查询商品时，一次查询数量的开始值
	private Integer endIndex;//查询商品时，一次查询数量
	private String designerBrand;//根据品牌查询商品：PC端查询设计品牌下的商品用到

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getMultiPrice() {
		return multiPrice;
	}

	public void setMultiPrice(String multiPrice) {
		this.multiPrice = multiPrice;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getDescription() {
		return description;
	}

	public void setDescription(Integer description) {
		this.description = description;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public Integer getFavoriteNum() {
		return favoriteNum;
	}

	public void setFavoriteNum(Integer favoriteNum) {
		this.favoriteNum = favoriteNum;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrandPlace() {
		return brandPlace;
	}

	public void setBrandPlace(String brandPlace) {
		this.brandPlace = brandPlace;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getCustomization() {
		return customization;
	}

	public void setCustomization(Integer customization) {
		this.customization = customization;
	}

	public String getCustomizationTip() {
		return customizationTip;
	}

	public void setCustomizationTip(String customizationTip) {
		this.customizationTip = customizationTip;
	}

	public String getSearchtext() {
		return searchtext;
	}

	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}

	public Integer getModCategoryParentid() {
		return modCategoryParentid;
	}

	public void setModCategoryParentid(Integer modCategoryParentid) {
		this.modCategoryParentid = modCategoryParentid;
	}

	public Integer getModRepertory() {
		return modRepertory;
	}

	public void setModRepertory(Integer modRepertory) {
		this.modRepertory = modRepertory;
	}

	public Integer getModVisitcount() {
		return modVisitcount;
	}

	public void setModVisitcount(Integer modVisitcount) {
		this.modVisitcount = modVisitcount;
	}

	public Integer getModShoppingcount() {
		return modShoppingcount;
	}

	public void setModShoppingcount(Integer modShoppingcount) {
		this.modShoppingcount = modShoppingcount;
	}

	public Date getModLastupttime() {
		return modLastupttime;
	}

	public void setModLastupttime(Date modLastupttime) {
		this.modLastupttime = modLastupttime;
	}

	public String getModTag() {
		return modTag;
	}

	public void setModTag(String modTag) {
		this.modTag = modTag;
	}

	public String getModDetail() {
		return modDetail;
	}

	public void setModDetail(String modDetail) {
		this.modDetail = modDetail;
	}

	public Integer getModDdelstate() {
		return modDdelstate;
	}

	public void setModDdelstate(Integer modDdelstate) {
		this.modDdelstate = modDdelstate;
	}

	public String getModServe() {
		return modServe;
	}

	public void setModServe(String modServe) {
		this.modServe = modServe;
	}

	public String getModFrom() {
		return modFrom;
	}

	public void setModFrom(String modFrom) {
		this.modFrom = modFrom;
	}

	public String getModElement() {
		return modElement;
	}

	public void setModElement(String modElement) {
		this.modElement = modElement;
	}

	public String getModSize() {
		return modSize;
	}

	public void setModSize(String modSize) {
		this.modSize = modSize;
	}

	public String getModRemark() {
		return modRemark;
	}

	public void setModRemark(String modRemark) {
		this.modRemark = modRemark;
	}

	public String getModWeight() {
		return modWeight;
	}

	public void setModWeight(String modWeight) {
		this.modWeight = modWeight;
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

	public Integer getMarkCategory() {
		return markCategory;
	}

	public void setMarkCategory(Integer markCategory) {
		this.markCategory = markCategory;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDesignerAvatar() {
		return designerAvatar;
	}

	public void setDesignerAvatar(String designerAvatar) {
		this.designerAvatar = designerAvatar;
	}

	public Integer getCondition_categoryid() {
		return condition_categoryid;
	}

	public void setCondition_categoryid(Integer condition_categoryid) {
		this.condition_categoryid = condition_categoryid;
	}

	public String getCondition_categoryName() {
		return condition_categoryName;
	}

	public void setCondition_categoryName(String condition_categoryName) {
		this.condition_categoryName = condition_categoryName;
	}

	public Integer getCondition_status() {
		return condition_status;
	}

	public void setCondition_status(Integer condition_status) {
		this.condition_status = condition_status;
	}

	public Integer getMarkOrder() {
		return markOrder;
	}

	public void setMarkOrder(Integer markOrder) {
		this.markOrder = markOrder;
	}

	public float getBeginprice() {
		return beginprice;
	}

	public void setBeginprice(float beginprice) {
		this.beginprice = beginprice;
	}

	public float getEndprice() {
		return endprice;
	}

	public void setEndprice(float endprice) {
		this.endprice = endprice;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public Integer getdFavoriteNum() {
		return dFavoriteNum;
	}

	public void setdFavoriteNum(Integer dFavoriteNum) {
		this.dFavoriteNum = dFavoriteNum;
	}

	public Integer getMcId() {
		return mcId;
	}

	public void setMcId(Integer mcId) {
		this.mcId = mcId;
	}

	public List<ModelType> getTexttrueList() {
		return texttrueList;
	}

	public void setTexttrueList(List<ModelType> texttrueList) {
		this.texttrueList = texttrueList;
	}

	public List<ModelType> getColorList() {
		return colorList;
	}

	public void setColorList(List<ModelType> colorList) {
		this.colorList = colorList;
	}

	public List<ModelType> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<ModelType> sizeList) {
		this.sizeList = sizeList;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public Integer getMsId() {
		return msId;
	}

	public void setMsId(Integer msId) {
		this.msId = msId;
	}

	public Integer getMarkRecommend() {
		return markRecommend;
	}

	public void setMarkRecommend(Integer markRecommend) {
		this.markRecommend = markRecommend;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getModSelfDesigner() {
		return modSelfDesigner;
	}

	public void setModSelfDesigner(Integer modSelfDesigner) {
		this.modSelfDesigner = modSelfDesigner;
	}

	public String getDesignerBrand() {
		return designerBrand;
	}

	public void setDesignerBrand(String designerBrand) {
		this.designerBrand = designerBrand;
	}

	public String getDbrandStory() {
		return dbrandStory;
	}

	public void setDbrandStory(String dbrandStory) {
		this.dbrandStory = dbrandStory;
	}

	@Override
	public String toString() {
		return "Model [mid=" + mid + ", uid=" + uid + ", title=" + title
				+ ", orderNo=" + orderNo + ", price=" + price + ", multiPrice="
				+ multiPrice + ", categoryId=" + categoryId + ", texture="
				+ texture + ", size=" + size + ", sales=" + sales + ", author="
				+ author + ", description=" + description + ", idea=" + idea
				+ ", favoriteNum=" + favoriteNum + ", addTime=" + addTime
				+ ", recommend=" + recommend + ", img=" + img + ", modelUrl="
				+ modelUrl + ", status=" + status + ", brand=" + brand
				+ ", brandPlace=" + brandPlace + ", deliveryTime="
				+ deliveryTime + ", customization=" + customization
				+ ", customizationTip=" + customizationTip + ", searchtext="
				+ searchtext + ", modCategoryParentid=" + modCategoryParentid
				+ ", modRepertory=" + modRepertory + ", modVisitcount="
				+ modVisitcount + ", modShoppingcount=" + modShoppingcount
				+ ", modLastupttime=" + modLastupttime + ", modTag=" + modTag
				+ ", modDetail=" + modDetail + ", modDdelstate=" + modDdelstate
				+ ", modServe=" + modServe + ", modFrom=" + modFrom
				+ ", modElement=" + modElement + ", modSize=" + modSize
				+ ", modRemark=" + modRemark + ", modWeight=" + modWeight
				+ ", modSelfDesigner=" + modSelfDesigner + ", pageInfo="
				+ pageInfo + ", condition=" + condition + ", markManage="
				+ markManage + ", markCategory=" + markCategory
				+ ", markRecommend=" + markRecommend + ", designerName="
				+ designerName + ", categoryName=" + categoryName
				+ ", designerAvatar=" + designerAvatar
				+ ", condition_categoryid=" + condition_categoryid
				+ ", condition_categoryName=" + condition_categoryName
				+ ", condition_status=" + condition_status + ", markOrder="
				+ markOrder + ", beginprice=" + beginprice + ", endprice="
				+ endprice + ", imgList=" + imgList + ", tagList=" + tagList
				+ ", dFavoriteNum=" + dFavoriteNum + ", mcId=" + mcId
				+ ", texttrueList=" + texttrueList + ", colorList=" + colorList
				+ ", sizeList=" + sizeList + ", modelType=" + modelType
				+ ", msId=" + msId + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex + "]";
	}

	 
}