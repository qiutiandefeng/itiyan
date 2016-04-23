package com.yfhl.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelShopping;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.TradeDetail;
import com.yfhl.mapper.ModelTypeMapper;
import com.yfhl.service.ModelTypeService;

/**
 * 商品规格SeviceImpl实现类层
 * 
 * @date 2015年12月11日
 * @author luans
 *
 */
@Service
@Transactional
public class ModelTypeServiceImpl implements ModelTypeService {
	@Resource
	public ModelTypeMapper modelTypeMapper;// 注入商品规格dao层实例对象

	/**
	 * 添加商品规格
	 * 
	 * @param ModelType
	 * @date 2015年12月11日
	 * @auther luans
	 */
	public int addModelType(ModelType modelType) {

		return modelTypeMapper.insertSelective(modelType);

	}

	/**
	 * 根据条件查询商品规格信息
	 * 
	 * @param ModelType
	 * @return List<ModelType>
	 * @date 2015年12月11日
	 * @auther luans
	 */
	public List<ModelType> queryModelType(ModelType modelType) {

		return modelTypeMapper.queryModelType(modelType);

	}

	/**
	 * 根据商品规格信息查询商品规格详细信息：价格
	 * 
	 * @param ModelType
	 * @return ModelType
	 * @date 2015年12月17日
	 * @auther luans
	 */
	public ModelType queryModelTypeByself(ModelType modelType) {
		return modelTypeMapper.queryModelTypeByself(modelType);
	}

	/**
	 * 查询商品规格信息：根据商品ID(group by)
	 * 
	 * @param ModelType
	 * @return ArrayList<ModelType>
	 * @date 2015年12月17日
	 * @auther luans
	 */
	public ArrayList<ModelType> queryModelTypeBymid(ModelType modelType) {

		return modelTypeMapper.queryModelTypeBymid(modelType);
	}

	/**
	 * 根据购物车信息 查询商品规格
	 * 
	 * @param ModelShopping
	 * @return ModelType
	 * @author luans
	 * @date 2016年3月1日
	 */
	public ModelType queryModelByModelShopping(ModelShopping modelshopping) {
		return modelTypeMapper.queryModelByModelShopping(modelshopping);
	}

	/**
	 * 根据订单详情信息查询商品规格
	 * 
	 * @param ModelShopping
	 * @return ModelType
	 * @author luans
	 * @date 2016年3月28日
	 */
	public ModelType queryModelByTradeDetail(TradeDetail detail) {
		return modelTypeMapper.queryModelByTradeDetail(detail);
	}

	/**
	 * 根据商品ID外键，获取商品规格信息
	 * 
	 * @param Model
	 * @return String
	 * @author luans
	 * @date 2016年3月9日
	 */
	public String queryModelTypeBymodlid(Model model) {
		List<ModelType> list = modelTypeMapper.queryModelTypeBymodlid(model);
		ModelType modelType = new ModelType();
		String modelTypelist = "";
		for (int i = 0; i < list.size(); i++) {
			modelType = list.get(i);
			modelTypelist = modelTypelist + modelType.getModtTexture() + ";";
			modelTypelist = modelTypelist + modelType.getModtSize() + ";";
			modelTypelist = modelTypelist + modelType.getModtPrice() + ";";
			modelTypelist = modelTypelist + modelType.getModtRepertory() + ";";
			modelTypelist = modelTypelist + modelType.getModtImg() + ";";
			modelTypelist = modelTypelist + modelType.getModtId() + ";;";

		}
		if ("".equals(modelTypelist)) {

		} else {
			modelTypelist = modelTypelist.substring(0,
					modelTypelist.length() - 2);
		}
		return modelTypelist;
	}

	/**
	 * 根据商品ID外键，获取尺寸信息：用于修改商品信息是回显商品规格
	 * 
	 * @param Model
	 * @return String
	 * @author luans
	 * @date 2016年3月9日
	 */
	public String querySizeBymodlid(Model model) {

		List<ModelType> size = modelTypeMapper.querySizeBymodlid(model);
		ModelType modelType = new ModelType();
		String sizeList = "";
		for (int i = 0; i < size.size(); i++) {
			modelType = size.get(i);
			sizeList = sizeList + modelType.getModtSize() + ";";
			sizeList = sizeList + modelType.getSizeMarker() + ";;";
		}
		if ("".equals(sizeList)) {

		} else {
			sizeList = sizeList.substring(0, sizeList.length() - 2);
		}
		return sizeList;
	}

	/**
	 * 根据商品ID外键，获取材质信息：用于修改商品信息是回显商品规格
	 * 
	 * @param Model
	 * @return List<ModelType>
	 * @author luans
	 * @date 2016年3月9日
	 */
	public String queryTexttureBymodlid(Model model) {
		List<ModelType> textture = modelTypeMapper.queryTexttureBymodlid(model);
		ModelType modelType = new ModelType();
		String texttureList = "";
		System.out.println("材质：" + textture.size());
		for (int i = 0; i < textture.size(); i++) {
			modelType = textture.get(i);
			System.out.println("luans" + modelType.toString());
			texttureList = texttureList + modelType.getModtTexture() + ";";
			texttureList = texttureList + modelType.getTexttureMarker() + ";";
			texttureList = texttureList + modelType.getModtImg() + ";;";
		}
		if ("".equals(texttureList)) {

		} else {
			texttureList = texttureList.substring(0, texttureList.length() - 2);
		}
		return texttureList;
	}

	/**
	 * 根据商品ID外键，删除商品规格信息，用于修改是重新添加
	 * 
	 * @param Model
	 * @return int
	 * @author luans
	 * @date 2016年3月10日
	 */
	public int delModelTypeByModid(Model model) {
		return modelTypeMapper.delModelTypeByModid(model);
	}

	/**
	 * 订单生成成功后，修改modelType表中对应商品的商品数量
	 * 
	 * @param TradeDetail
	 *            :qty、modeltypeId
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateModelTypeCount(TradeDetail tradeDetail) {
		return modelTypeMapper.updateModelTypeCount(tradeDetail);
	}

	/**
	 * 根据购物车信息查询商品规格ID
	 * 
	 * @param int
	 * @return int
	 * @author luans
	 * @date 2016年3月15日
	 */
	public int queryIDByModelShopping(ModelShopping modelShopping) {
		return modelTypeMapper.queryIDByModelShopping(modelShopping);
	}

	/**
	 * 根据订单详情中的modeltypeId和qty判断商品是否失效
	 * 
	 * @param TradeDetail
	 *            :qty、modeltypeId
	 * @return int
	 * @date 2016年3月31日
	 * @auther luans
	 */
	public int checkmodelUseBytdetail(TradeDetail tradeDetail) {
		return modelTypeMapper.checkmodelUseBytdetail(tradeDetail);
	}

	public int deleteByPrimaryKey(Integer modtId) {
		return modelTypeMapper.deleteByPrimaryKey(modtId);
	}

	public int insertSelective(ModelType record) {

		return modelTypeMapper.insertSelective(record);
	}

	public List<ModelType> getModelTypeAll() {
		return modelTypeMapper.getModelTypeAll();
	}

	public ModelType selectByPrimaryKey(Integer modtId) {
		return modelTypeMapper.selectByPrimaryKey(modtId);
	}

	public int insert(ModelType record) {
		return modelTypeMapper.insert(record);
	}

	public int updateByPrimaryKeySelective(ModelType record) {
		return modelTypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ModelType record) {
		return modelTypeMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据商品的编号查询商品所有的规格
	 * 
	 * @param modtModid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月6日
	 */
	@Override
	public List<ModelType> queryModelTypeListBymid(Integer modtModid) {
		return modelTypeMapper.queryModelTypeListBymid(modtModid);
	}

}
