package com.yfhl.mapper;

import java.util.ArrayList;
import java.util.List;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelShopping;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.TradeDetail;

/**
 * 商品规格dao层
 * 
 * @date 2015年12月11日
 * @author luans
 *
 */
public interface ModelTypeMapper {

	/**
	 * 添加商品规格
	 * 
	 * @param ModelType
	 * @return int
	 * @date 2015年12月11日
	 * @auther luans
	 */
	public int insertSelective(ModelType record);

	/**
	 * 修改商品规格信息
	 * 
	 * @param record
	 * @return
	 * @author luans
	 */
	int updateByPrimaryKeySelective(ModelType record);

	/**
	 * 根据条件查询商品规格信息
	 * 
	 * @param ModelType
	 * @return List<ModelType>
	 * @date 2015年12月11日
	 * @auther luans
	 */
	public List<ModelType> queryModelType(ModelType modelType);

	/**
	 * 根据商品规格信息查询商品规格详细信息：价格
	 * 
	 * @param ModelType
	 * @return ModelType
	 * @date 2015年12月17日
	 * @auther luans
	 */
	public ModelType queryModelTypeByself(ModelType modelType);

	/**
	 * 查询商品规格信息：根据商品ID(group by)
	 * 
	 * @param ModelType
	 * @return ArrayList<ModelType>
	 * @date 2015年12月17日
	 * @auther luans
	 */
	public ArrayList<ModelType> queryModelTypeBymid(ModelType modelType);

	/**
	 * 根据购物车信息 查询商品规格
	 * 
	 * @param ModelShopping
	 * @return ModelType
	 * @author luans
	 * @date 2016年3月1日
	 */
	public ModelType queryModelByModelShopping(ModelShopping modelshopping);

	/**
	 * 根据订单详情信息查询商品规格
	 * 
	 * @param ModelShopping
	 * @return ModelType
	 * @author luans
	 * @date 2016年3月28日
	 */
	public ModelType queryModelByTradeDetail(TradeDetail detail);

	/**
	 * 根据商品ID外键，获取商品规格信息
	 * 
	 * @param Model
	 * @return List<ModelType>
	 * @author luans
	 * @date 2016年3月9日
	 */
	public List<ModelType> queryModelTypeBymodlid(Model model);

	/**
	 * 根据商品ID外键，获取尺寸信息：用于修改商品信息是回显商品规格
	 * 
	 * @param Model
	 * @return List<ModelType>
	 * @author luans
	 * @date 2016年3月9日
	 */
	public List<ModelType> querySizeBymodlid(Model model);

	/**
	 * 根据商品ID外键，获取材质信息：用于修改商品信息是回显商品规格
	 * 
	 * @param Model
	 * @return List<ModelType>
	 * @author luans
	 * @date 2016年3月9日
	 */
	public List<ModelType> queryTexttureBymodlid(Model model);

	/**
	 * 根据商品ID外键，删除商品规格信息，用于修改是重新添加
	 * 
	 * @param Model
	 * @return int
	 * @author luans
	 * @date 2016年3月10日
	 */
	public int delModelTypeByModid(Model model);

	/**
	 * 根据购物车信息查询商品规格ID
	 * 
	 * @param int
	 * @return int
	 * @author luans
	 * @date 2016年3月15日
	 */
	public int queryIDByModelShopping(ModelShopping modelShopping);

	/**
	 * 订单生成成功后，修改modelType表中对应商品的商品数量
	 * 
	 * @param TradeDetail
	 *            :qty、modeltypeId
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateModelTypeCount(TradeDetail tradeDetail);

	/**
	 * 根据订单详情中的modeltypeId和qty判断商品是否失效
	 * 
	 * @param TradeDetail
	 *            :qty、modeltypeId
	 * @return int
	 * @date 2016年3月31日
	 * @auther luans
	 */
	public int checkmodelUseBytdetail(TradeDetail tradeDetail);

	int deleteByPrimaryKey(Integer modtId);

	int insert(ModelType record);

	ModelType selectByPrimaryKey(Integer modtId);

	int updateByPrimaryKey(ModelType record);

	List<ModelType> getModelTypeAll();

	/**
	 * 根据商品的编号查询商品所有的规格
	 * 
	 * @param modtModid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月6日
	 */
	public List<ModelType> queryModelTypeListBymid(Integer modtModid);

}