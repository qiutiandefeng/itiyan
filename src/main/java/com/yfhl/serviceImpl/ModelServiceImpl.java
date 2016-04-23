package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.TradeDetail;
import com.yfhl.entity.User;
import com.yfhl.mapper.ModelMapper;
import com.yfhl.service.ModelService;

/**
 * 商品管理Service实现类层
 * 
 * @author luans
 * @date 2015年11月26日
 *
 */
@Service
@Transactional
public class ModelServiceImpl implements ModelService {

	@Resource
	public ModelMapper modelMapper;// 注入商品dao层实例对象

	/**
	 * 商品管理：分页查询商品List
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年11月26日
	 * @auther luans
	 */
	public List<Model> queryListByPage(Model model) {
		return modelMapper.queryListByPage(model);
	}

	/**
	 * 商品管理：添加商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年11月27日
	 * @auther luans
	 */
	public int insertSelective(Model record) {
		// 添加默认字段信息
		record.setAddTime(new Date());// 添加时间
		record.setModDdelstate(1);// 商品删除状态：1.正常；2.删除
		record.setStatus(2);// 商品状态：1: 审核中 2:展示中 3:已下架 4:暂不出售'
//		if (record.getUid() == null || "".equals(record.getUid())) {
//
//			record.setUid(1);// 如果是管理员登录，设置默认值爱体验品牌
//			record.setAuthor(1);
//		}
		record.setTexture("123");
		record.setSize("123");
		if (record.getModelUrl() == null || "".equals(record.getModelUrl())) {
			record.setModelUrl("123");// 管理员添加没有模型路径
		}
		// 添加商品：接收返回值添加的主键ID,然后添加商品规格
		int result = modelMapper.insertSelective(record);

		return result;
	}

	/**
	 * 商品管理：修改商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年11月30日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(Model record) {
		return modelMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 商品管理：删除商品
	 * 
	 * @param Model
	 * @return int
	 * @date 2015年12月1日
	 * @auther luans
	 */
	public int modelDel(Model model) {
		return modelMapper.modelDel(model);
	}

	/**
	 * 商品管理：根据条件查询商品信息
	 * 
	 * @author luans
	 */
	public Model queryModel(Model model) {
		System.out.println("ServiceImpl层：" + model.toString());
		return modelMapper.queryModel(model);
	}

	/**
	 * 
	 * 商品管理：获取导出商品信息
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年12月2日
	 * @auther luans
	 */
	public List<Model> queryOutModel(Model model) {
		return modelMapper.queryOutModel(model);
	}

	/**
	 * 修改商品收藏值
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollection(ModelCollection modelCollection) {
		return modelMapper.updateCollection(modelCollection);
	}

	/**
	 * 根据模型的Id 查询订单信息
	 */
	public Model getModelBymId(Integer id) {
		return modelMapper.getModelBymId(id);
	}

	public int getCountModelByTime(String format, String format2) {
		return modelMapper.getCountModelByTime(format, format2);
	}

	/**
	 * 获取爱体验推荐产品信息
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public List<Model> queryRecommend(Model model) {
		return modelMapper.queryRecommend(model);
	}

	/**
	 * 商品管理：设置推荐
	 * 
	 * @param Model
	 * @return Integer
	 * @date 2016年3月11日
	 * @auther luans
	 */
	public Integer setRecommend(Model model) {
		model.setModLastupttime(new Date());// 设置商品最后修改时间
		return modelMapper.setRecommend(model);
	}

	/**
	 * 商品管理：一键取消所有推荐
	 * 
	 * @return Integer
	 * @date 2016年3月11日
	 * @auther luans
	 */
	public Integer resetRecommend() {
		Model model = new Model();
		model.setModLastupttime(new Date());
		return modelMapper.resetRecommend(model);
	}

	/**
	 * 查询商品信息（推荐商品为0时，查询新最新添加的商品）
	 * 
	 * @param Model
	 * @return List<Model>
	 * @date 2016年3月12日
	 * @auther luans
	 */
	public List<Model> queryModelforRecommend(Model model) {
		return modelMapper.queryModelforRecommend(model);
	}

	/**
	 * 根据商品类别ID查询商品信息 :PC端首页更多产品（8件）
	 * 
	 * @param Integer
	 * @return List<Model>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<Model> queryModelByCategory(Integer categoeyId) {

		return modelMapper.queryModelByCategory(categoeyId);
	}

	/**
	 * 选择商品页面信息
	 * 
	 * @param Integer
	 * @return List<Model>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<Model> queryModelsel(String condition) {
		return modelMapper.queryModelsel(condition);
	}

	/**
	 * 根据商品ID集合查询商品信息
	 * 
	 * @param List
	 *            <Integer>
	 * @return List<Model>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<Model> queryModelByIDList(List<Integer> list) {
		return modelMapper.queryModelByIDList(list);
	}

	/**
	 * 根据设计师品牌查询商品信息
	 * 
	 * @param String
	 *            :设计师品牌
	 * @return List<Model>
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public List<Model> queryModelBybrand(String brand) {
		return modelMapper.queryModelBybrand(brand);
	}

	/**
	 * 订单生成成功后，修改model表中对应商品的商品数量
	 * 
	 * @param TradeDetail
	 *            :id、qty
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateModelCount(TradeDetail tradeDetail) {
		return modelMapper.updateModelCount(tradeDetail);
	}

	/**
	 * 获取所有的商品 用来修改基本信息
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月9日
	 */
	public List<Model> getModelAll() {
		return modelMapper.getModelAll();
	}

	/**
	 * 获取单个类别中的所有商品
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	@Override
	public List<Model> getModelCategoryList(Integer categoryId) {
		return modelMapper.getModelCategoryList(categoryId);
	}
}
