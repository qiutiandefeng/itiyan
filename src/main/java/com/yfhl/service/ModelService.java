package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.TradeDetail;
import com.yfhl.entity.User;

/**
 * 商品管理Service层
 * 
 * @author luans
 * @date 2015年11月26日
 *
 */
public interface ModelService {

	/**
	 * 商品管理：分页查询商品List
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年11月26日
	 * @auther luans
	 */
	public List<Model> queryListByPage(Model model);

	/**
	 * 商品管理：添加商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年11月27日
	 * @auther luans
	 */
	public int insertSelective(Model record);

	/**
	 * 商品管理：根据条件查询商品信息
	 * 
	 * @param Model
	 * @return Model
	 * @date 2015年11月30日
	 * @auther luans
	 */
	public Model queryModel(Model model);

	/**
	 * 商品管理：修改商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年11月30日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(Model record);

	/**
	 * 商品管理：删除商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年12月1日
	 * @auther luans
	 */
	public int modelDel(Model record);

	/**
	 * 
	 * 商品管理：获取导出商品信息
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年12月2日
	 * @auther luans
	 */
	public List<Model> queryOutModel(Model model);

	/**
	 * 修改商品收藏值
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollection(ModelCollection modelCollection);

	/**
	 * 获取爱体验推荐产品信息
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public List<Model> queryRecommend(Model model);

	/**
	 * 商品管理：设置推荐
	 * 
	 * @param Model
	 * @return Integer
	 * @date 2016年3月11日
	 * @auther luans
	 */
	public Integer setRecommend(Model model);

	/**
	 * 商品管理：一键取消所有推荐
	 * 
	 * @return Integer
	 * @date 2016年3月11日
	 * @auther luans
	 */
	public Integer resetRecommend();

	/**
	 * 查询商品信息（推荐商品为0时，查询新最新添加的商品）
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2016年3月12日
	 * @auther luans
	 */
	public List<Model> queryModelforRecommend(Model model);

	/**
	 * 根据商品类别ID查询商品信息 :PC端首页更多产品（8件）
	 * 
	 * @param Integer
	 * @return List<Model>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<Model> queryModelByCategory(Integer categoeyId);

	/**
	 * 选择商品页面信息
	 * 
	 * @param Integer
	 * @return List<Model>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<Model> queryModelsel(String condition);

	/**
	 * 根据商品ID集合查询商品信息
	 * 
	 * @param List
	 *            <Integer>
	 * @return List<Model>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<Model> queryModelByIDList(List<Integer> list);
	
	/**
	 * 根据设计师品牌查询商品信息
	 * 
	 * @param String:设计师品牌
	 * @return List<Model>
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public List<Model> queryModelBybrand(String brand);
	/**
	 * 订单生成成功后，修改model表中对应商品的商品数量
	 * 
	 * @param TradeDetail:id、qty
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateModelCount(TradeDetail tradeDetail);
	/**
	 * 根据模型的Id 获取订单信息
	 * 
	 * @param id
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月26日
	 */
	public Model getModelBymId(Integer id);

	/**
	 * 根据时间段来查询商品 如果不按时间段查询就输入 null null
	 * 
	 * @param format
	 * @param format2
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月30日
	 */
	public int getCountModelByTime(String format, String format2);

	public List<Model> getModelAll();

	/**
	 * 获取单个类别中的所有商品
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	public List<Model> getModelCategoryList(Integer categoryId);
}
