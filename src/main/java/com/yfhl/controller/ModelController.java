package com.yfhl.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Banner;
import com.yfhl.entity.Category;
import com.yfhl.entity.Comment;
import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.Recent;
import com.yfhl.entity.User;
import com.yfhl.service.BannerService;
import com.yfhl.service.CategoryService;
import com.yfhl.service.CommentService;
import com.yfhl.service.DesignerCollectionService;
import com.yfhl.service.ModelCollectionService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.RecentService;
import com.yfhl.service.UserService;
import com.yfhl.util.CodeUtil;

/**
 * 商品管理Controller
 * 
 * @author luans
 * @date 2015年11月26日
 */
@Controller
@RequestMapping("modelController")
public class ModelController {
	@Resource
	public ModelService modelServiceImpl;// 注入商品Service层实例对象
	@Resource
	public CategoryService categoryServiceImpl;// 注入商品类别Service层实例对象
	@Resource
	public ModelTypeService modelTypeServiceImpl;// 注入商品类别Service层实例对象
	@Resource
	public CommentService commentServiceImpl;// 注入商品评论Service层实例对象
	@Resource
	public ModelCollectionService modelCollectionServiceImpl;// 注入商品收藏Service层实例对象
	@Resource
	public DesignerCollectionService designerCollectionServiceImpl;// 注入设计师收藏Service层实例对象
	@Resource
	public UserService userServiceImpl;// 注入用户Service层实例
	@Resource
	public BannerService bannerService;// 注入bannerService层实例

	@Resource
	public RecentService recentService;// 注如最近浏览Service层实例

	/**
	 * 商品管理：分页查询商品List
	 * 
	 * @param Model
	 * @return ModelAndView
	 * @date 2015年11月26日
	 * @auther luans
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(Model model) {

		// 处理条件查询时条件乱码问题
		model = turnCode(model);
		ModelAndView mv = new ModelAndView();
		model.getPageInfo().setPageSize(10);
		List<Model> list = modelServiceImpl.queryListByPage(model);

		mv.addObject("list", list);
		mv.addObject("model", model);
		mv.setViewName("/manager/goodsManage/goodsList");
		return mv;
	}

	/**
	 * 商品管理：去商品操作页面：添加、编辑
	 * 
	 * @param Model
	 * @return ModelAndView
	 * @date 2015年12月4日
	 * @auther luans
	 */
	@RequestMapping("gotoModelManage")
	public ModelAndView gotoModelManage(Model model) {
		// 处理条件查询时条件乱码问题
		model = turnCode(model);
		ModelAndView mv = new ModelAndView();
		if (model.getMarkManage() == 1) {// 去添加商品页面
			mv.addObject("model", model);
			mv.setViewName("/manager/goodsManage/goodsManage1");
		} else if (model.getMarkManage() == 2) {// 去编辑商品页面
			// 获取编辑信息
			Model mo = modelServiceImpl.queryModel(model);
			String modelTypeList = modelTypeServiceImpl
					.queryModelTypeBymodlid(model);
			String sizeList = modelTypeServiceImpl.querySizeBymodlid(model);
			String texttureList = modelTypeServiceImpl
					.queryTexttureBymodlid(model);
			System.out.println("商品规格有多少种：" + modelTypeList);
			System.out.println("商品尺寸有多少种：" + sizeList);
			System.out.println("商品材质有多少种：" + texttureList);
			mo.setMarkManage(model.getMarkManage());
			System.out.println("修改之前的信息：" + mo.toString());
			mo.setPageInfo(model.getPageInfo());
			mo.setCondition(model.getCondition());
			mo.setMarkCategory(model.getMarkCategory());
			mo.setCondition_categoryid(model.getCondition_categoryid());
			mo.setCondition_categoryName(model.getCondition_categoryName());
			mo.setCondition_status(model.getCondition_status());
			mo.setModSelfDesigner(model.getModSelfDesigner());
			mv.addObject("model", mo);
			mv.addObject("modelTypeList", modelTypeList);
			mv.addObject("sizeList", sizeList);
			mv.addObject("texttureList", texttureList);
			mv.setViewName("/manager/goodsManage/goodsManage1");
		} else if (model.getMarkManage() == 3) { // 去查看商品页面
			// 获取编辑信息
			Model mo = modelServiceImpl.queryModel(model);
			mo.setMarkManage(model.getMarkManage());
			mo.setPageInfo(model.getPageInfo());
			mo.setCondition(model.getCondition());
			mo.setMarkCategory(model.getMarkCategory());
			mo.setCondition_categoryid(model.getCondition_categoryid());
			mo.setCondition_categoryName(model.getCondition_categoryName());
			mo.setCondition_status(model.getCondition_status());
			mo.setModSelfDesigner(model.getModSelfDesigner());
			mv.addObject("model", mo);
			mv.setViewName("/manager/goodsManage/goodsManage1");
		}
		return mv;
	}

	/**
	 * 商品操作：添加、编辑
	 * 
	 * @param Model
	 * @return ModelAndView
	 * @date 2015年11月27日
	 * @auther luans
	 */
	@RequestMapping("modelManage")
	public ModelAndView modelManage(Model model) {
		// 处理条件查询时条件乱码问题
		model = turnCode(model);
		int result = 0;
		if (model.getMarkManage() == 1) {// 添加商品页面
			System.out.println("进入添加model:" + model.toString());
			// 商品添加成功后返回添加的商品ID
			result = modelServiceImpl.insertSelective(model);
			String[] modeltypeArraySum = model.getModelType().split(";;;");
			ModelType modeltype = new ModelType();
			modeltype.setModtModid(model.getMid());
			modeltype.setModtDelstate(1);
			for (int i = 0; i < modeltypeArraySum.length; i++) {
				String[] modeltypeArray = modeltypeArraySum[i].split(";;");
				for (int j = 0; j < modeltypeArray.length; j++) {
					modeltype.setModtTexture(modeltypeArray[0]);
					modeltype.setModtSize(modeltypeArray[1]);
					modeltype.setModtPrice(Float.parseFloat(modeltypeArray[2]));
					modeltype.setModtRepertory(Integer
							.parseInt(modeltypeArray[3]));
					modeltype.setModtImg(modeltypeArray[4]);
					modeltype.setSizeMarker(modeltypeArray[5]);
					modeltype.setTexttureMarker(modeltypeArray[6]);
				}
				// 添加商品规格信息
				result = modelTypeServiceImpl.addModelType(modeltype);
			}
			if (result == 0) {
				System.out.println("添加商品出现问题了~~");
			}

		} else if (model.getMarkManage() == 2) {// 编辑商品页面
			// 获取编辑信息
			System.out.println("修改之后的信息：" + model.toString());
			modelServiceImpl.updateByPrimaryKeySelective(model);
			String[] modeltypeArraySum = model.getModelType().split(";;;");
			ModelType modeltype = new ModelType();
			modeltype.setModtModid(model.getMid());
			modeltype.setModtDelstate(1);
			// 删除之前的商品规格信息
			result = modelTypeServiceImpl.delModelTypeByModid(model);
			System.out.println("删除的信息数量：" + result);
			for (int i = 0; i < modeltypeArraySum.length; i++) {
				String[] modeltypeArray = modeltypeArraySum[i].split(";;");
				for (int j = 0; j < modeltypeArray.length; j++) {
					modeltype.setModtTexture(modeltypeArray[0]);
					modeltype.setModtSize(modeltypeArray[1]);
					modeltype.setModtPrice(Float.parseFloat(modeltypeArray[2]));
					modeltype.setModtRepertory(Integer
							.parseInt(modeltypeArray[3]));
					modeltype.setModtImg(modeltypeArray[4]);
					modeltype.setSizeMarker(modeltypeArray[5]);
					modeltype.setTexttureMarker(modeltypeArray[6]);
				}
				// 重新添加商品规格信息
				result = modelTypeServiceImpl.addModelType(modeltype);
			}
			if (result == 0) {
				System.out.println("添加商品出现问题了~~");
			}
		}
		Model m = new Model();
		m.setModSelfDesigner(model.getModSelfDesigner());
		return queryList(m);
	}

	/**
	 * 商品管理：删除商品
	 * 
	 * @param Model
	 * @return ModelAndView
	 * @date 2015年12月1日
	 * @auther luans
	 */
	@RequestMapping("modelDel")
	public ModelAndView modelDel(Model model) {

		modelServiceImpl.modelDel(model);

		return queryList(model);
	}

	/**
	 * 商品管理：设置推荐
	 * 
	 * @param Model
	 * @return Integer
	 * @date 2016年3月11日
	 * @auther luans
	 */
	@RequestMapping("setRecommend")
	@ResponseBody
	public Integer setRecommend(Model model) {
		System.out.println("设置推荐:" + model.toString());
		int result = modelServiceImpl.setRecommend(model);
		return result;
	}

	/**
	 * 商品管理：一键取消所有推荐
	 * 
	 * @return ModelAndView
	 * @date 2016年3月15日
	 * @auther luans
	 */
	@RequestMapping("resetRecommend")
	public ModelAndView resetRecommend() {
		modelServiceImpl.resetRecommend();
		return queryList(new Model());
	}

	/**
	 * 后台：添加商品时选择品牌页面
	 * 
	 * @return ModelAndView
	 * @date 2016年3月16日
	 * @auther luans
	 */
	@RequestMapping("queryBrand")
	public ModelAndView queryBrand(String condition) {
		ModelAndView mv = new ModelAndView();
		List<User> brandList = userServiceImpl.queryBrand(condition);

		mv.addObject("condition", condition);
		mv.addObject("brandList", brandList);
		mv.setViewName("/manager/userManage/sel_brand");
		return mv;
	}

	/**
	 * 后台：查询选择商品页面信息
	 * 
	 * @return ModelAndView
	 * @date 2016年3月16日
	 * @auther luans
	 */
	@RequestMapping("queryModelsel")
	public ModelAndView queryModelsel(String condition, String oldmodelids) {
		ModelAndView mv = new ModelAndView();
		List<Model> modelList = modelServiceImpl.queryModelsel(condition);
		mv.addObject("modelList", modelList);
		mv.addObject("condition", condition);
		mv.addObject("oldmodelids", oldmodelids);
		mv.setViewName("/manager/generalize/sel_model");
		return mv;
	}

	/**
	 * PC端前台：获取列表展示页面信息
	 * 
	 * @param Model
	 *            ,HttpServletRequest
	 * @return ModelAndView
	 * @date 2015年12月8日
	 * @auther luans
	 */
	@RequestMapping("gotoModelListPC")
	public ModelAndView gotoModelListPC(Model model, HttpServletRequest request) {
		System.out.println("进入gotoModelListPC" + model.toString());

		ModelAndView mv = new ModelAndView();
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int uid = 0;
		if (userid != null && !"".equals(userid)) {
			uid = Integer.parseInt(userid);
			model.setUid(uid);
		}
		System.out.println("yonghuID:" + userid);
		// 1.查询所有商品类别
		List<Category> categoryList = categoryServiceImpl
				.queryCategory(new Category());// 查询所有商品类别
		model.getPageInfo().setPageSize(20);
		// 2.1.查询展示商品信息
		List<Model> modelList = modelServiceImpl.queryListByPage(model);
		if (modelList.size() == 0) {// 如果没有商品符合条件的商品时：显示推荐的商品
			// modelList= modelServiceImpl.queryRecommend(model);
		}
		// 2.2整理商品展示信息
		this.modelListHandle(modelList, model.getUid());

		// 3.查询最近浏览商品
		List<Recent> recentList = new ArrayList<Recent>();
		if (uid != 0) {
			recentList = recentModel(uid);
		}
		// 4.将商品类别放入Session，公共调用
		this.setCategorySession(request);
		
		mv.addObject("modelList", modelList);
		mv.addObject("categoryList", categoryList);
		mv.addObject("recentList", recentList);
		mv.addObject("model", model);
		mv.setViewName("/pc/goodsManage/goodsList");
		return mv;
	}

	/**
	 * PC端前台：获取商品详细信息
	 * 
	 * @param Model
	 *            ,Comment
	 * @return ModelAndView
	 * @date 2015年12月11日
	 * @auther luans
	 */
	@RequestMapping("gotoModelDetailPC")
	public ModelAndView gotoModelDetailPC(HttpServletRequest request,
			Model model, Comment comment) {
		System.out.println("进入商品详情：" + model.toString());
		System.out.println("评论comment:" + comment.toString());
		System.out.println("结果：" + model == null);
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int uid = 0;
		if (userid != null && !"".equals(userid)) {
			uid = Integer.parseInt(userid);
			model.setUid(uid);
			comment.setUid(uid);
		}
		ModelAndView mv = new ModelAndView();
		// 1.查询商品详细
		Model mo = modelServiceImpl.queryModel(model);
		// 2.整理商品详细信息
		this.modelHandle(mo);
		// 3.查询商品评论信息
		comment.setMid(mo.getMid());
		comment.getPageInfo().setPageSize(4);
		List<Comment> commentList = commentServiceImpl.queryListByPage(comment);
		System.out.println("评论个数：" + commentList.size());
		// 4.查询商品规格信息
		mo = this.modelTypeHandel(mo);
		System.out.println("商品详情：" + mo.toString());
		// 5.商品收藏
		ModelCollection modelCollection = new ModelCollection();
		modelCollection.setMcModelid(mo.getMid());// 商品ID
		if (model.getUid() == null) {
			modelCollection.setMcUserid(0);
		} else {
			modelCollection.setMcUserid(uid);
		}
		modelCollection.setMcDesignerid(mo.getAuthor());// 设计师ID
		if (modelCollectionServiceImpl.queryCount(modelCollection) > 0) {
			mo.setMcId(modelCollectionServiceImpl.queryId(modelCollection));
		}
		System.out.println("商品收藏表ID:" + mo.getMcId());

		System.out.println("modelCollection:" + modelCollection.toString());
		System.out.println("123:" + mo.toString());
		// 6.1.获取爱体验推荐商品
		model.setStartIndex(0);
		model.setEndIndex(21);
		List<Model> recommendList = modelServiceImpl.queryRecommend(model);
		// 6.2.整理推荐商品信息
		this.modelListHandle(recommendList, model.getUid());
		// 7.添加最近浏览
		if (uid != 0) {
			Recent recent = new Recent();
			recent.setrUid(uid);
			recent.setrMid(model.getMid());
			// 判断是否有浏览过，有的话修改浏览时间
			int result = recentService.updateRecent(recent);
			if (result == 0) {
				recentService.insertSelective(recent);
			}
		}
		// 8.将商品类别放入Session，公共调用
		this.setCategorySession(request);
		
		mv.addObject("model", mo);
		mv.addObject("comment", comment);
		mv.addObject("commentList", commentList);
		mv.addObject("recommendList", recommendList);
		mv.setViewName("/pc/goodsManage/goodsDetail");
		return mv;
	}

	/**
	 * PC端前台：跳转到首页
	 * 
	 * @return ModelAndView
	 * @date 2016年2月18日
	 * @auther luans
	 */
	@RequestMapping("gotoModelPC")
	public ModelAndView gotoModelPC(HttpServletRequest request) {
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int uid = 0;
		if (userid != null && !"".equals(userid)) {
			uid = Integer.parseInt(userid);
		}
		System.out.println("进入首页");
		ModelAndView mv = new ModelAndView();
		Model model = new Model();
		model.setStartIndex(0);
		model.setEndIndex(10);
		// 1.1.查询本周推荐商品
		List<Model> recommendList = modelServiceImpl.queryRecommend(model);
		if (recommendList.size() == 0) {
			recommendList = modelServiceImpl.queryModelforRecommend(model);
		}
		// 1.2.整理推荐商品信息
		this.modelListHandle(recommendList, 0);
		// 2.查询更多产品
		// Map<String, List<Model>> modelmap = new HashMap<String,
		// List<Model>>();
		List<List<Model>> modellist = new ArrayList<List<Model>>();// 商品集合
		List<Model> list = new ArrayList<Model>();
		// 2.1查询商品类别
		List<Category> categoryList = categoryServiceImpl
				.queryCategoryForIndex();
		Category category = new Category();
		for (int i = 0; i < categoryList.size(); i++) {
			category = categoryList.get(i);
			list = modelServiceImpl.queryModelByCategory(category
					.getCategoryId());
			list = this.modelListHandle(list, uid);// 整理商品展示信息
			modellist.add(list);
			// modelmap.put(category.getTitle(), list);
		}
		// 3.查询设计师
		List<User> designerList = userServiceImpl.queryDesigners();
		// 4.查询banner
		List<Banner> bannerList = bannerService.queryBannerforPC();
		// 5.将商品类别放入Session，公共调用
		this.setCategorySession(request);

		mv.addObject("bannerList", bannerList);
		mv.addObject("recommendList", recommendList);
		mv.addObject("designerList", designerList);
		mv.addObject("modellist", modellist);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("/pc/index");
		return mv;
	}

	/**
	 * PC端前台：首页本周推荐点击More
	 * 
	 * @return List<Model>
	 * @date 2016年3月12日
	 * @auther luans
	 */
	@RequestMapping("queryRecommendMore")
	@ResponseBody
	public List<Model> queryRecommendMore(Model model) {

		List<Model> recommendList = modelServiceImpl.queryRecommend(model);
		// 整理推荐商品信息
		this.modelListHandle(recommendList, 0);
		return recommendList;
	}

	/**
	 * PC端前台：banner跳转链接
	 * 
	 * @return ModelAndView
	 * @date 2016年3月17日
	 * @auther luans
	 */
	@RequestMapping("gotoBannerList")
	public ModelAndView gotoBannerList(String modelids) {
		ModelAndView mv = new ModelAndView();
		String[] array = modelids.split(";");
		List<Integer> modelidsList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			modelidsList.add(Integer.parseInt(array[0]));
		}

		List<Model> modelList = modelServiceImpl
				.queryModelByIDList(modelidsList);
		// 2.整理商品展示信息
		this.modelListHandle(modelList, 0);
		mv.addObject("modelList", modelList);
		mv.setViewName("/pc/goodsManage/goodsList");
		return mv;
	}

	/**
	 * 内部自定义方法：1.商品信息乱码转换
	 * 
	 * @param Model
	 * @return Model
	 * @date 2015年11月26日
	 * @auther luans
	 */
	public Model turnCode(Model model) {
		// 实例化编码工具类
		CodeUtil codeUtil = new CodeUtil();
		// 1.商品类别名称乱码
		if (model.getCondition_categoryName() != null
				&& !"".equals(model.getCondition_categoryName())
				&& codeUtil.isMessyCode(model.getCondition_categoryName())) {
			try {
				String cname = new String(model.getCondition_categoryName()
						.getBytes("ISO-8859-1"), "utf-8");
				model.setCondition_categoryName(cname);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 2.模糊查询条件乱码
		if (model.getCondition() != null && !"".equals(model.getCondition())
				&& codeUtil.isMessyCode(model.getCondition())) {
			try {
				String cname = new String(model.getCondition().getBytes(
						"ISO-8859-1"), "utf-8");
				model.setCondition(cname);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return model;
	}

	/**
	 * 自定义内部方法：2.整理商品列表展示信息
	 * 
	 * @param List
	 *            <Model>,Integer
	 * @return List<Model>
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public List<Model> modelListHandle(List<Model> list, Integer uid) {
		if (uid == null) {
			uid = 0;
		}
		Model model = new Model();
		ModelCollection mCollection = new ModelCollection();
		mCollection.setMcUserid(uid);

		for (int i = 0; i < list.size(); i++) {
			// 显示第一张商品图片
			model = list.get(i);
			list.get(i).setImg(model.getImg().split(";")[0]);
			// 查询用户收藏商品的id
			mCollection.setMcModelid(model.getMid());
			mCollection.setMcDesignerid(model.getAuthor());
			if (modelCollectionServiceImpl.queryCount(mCollection) > 0) {
				list.get(i).setMcId(
						modelCollectionServiceImpl.queryId(mCollection));
			}

		}
		// 处理设计师是否被收藏状态

		return list;
	}

	/**
	 * 内部自定义方法：3.查询最近浏览商品
	 * 
	 * @param User
	 * @return List<Recent>
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public List<Recent> recentModel(Integer uid) {
		List<Recent> recentList = new ArrayList<Recent>();
		// 根据用户ID查询用户最近浏览记录
		Recent recent = new Recent();
		recent.setrUid(uid);
		recentList = recentService.queryRecent(recent);
		if (recentList.size() == 0) {// 用户无最近浏览记录
			System.out.println("无最近浏览记录");
		} else if (recentList.size() != 0) {
			Recent r = new Recent();
			for (int i = 0; i < recentList.size(); i++) {
				r = recentList.get(i);
				if (r.getModelImg() != null && !"".equals(r.getModelImg())) {
					String[] imgs = r.getModelImg().split(";");
					recentList.get(i).setModelImg(imgs[0]);// 显示第一张图片
				}
			}
		}
		return recentList;
	}

	/**
	 * 内部自定义方法：4.整合商品详细信息
	 * 
	 * @param Model
	 * @return Model
	 * @date 2015年12月15日
	 * @auther luans
	 */
	public Model modelHandle(Model mo) {
		// 1.将商品图片转化成List集合形式
		if (mo.getImg() != null && !"".equals(mo.getImg())) {
			System.out.println("mo.getImg()=" + mo.getImg());
			String[] imgArray = mo.getImg().split(";");
			System.out.println("imgArray.length=" + imgArray.length);
			List<String> imglist = new ArrayList<String>();
			for (int i = 0; i < imgArray.length; i++) {
				imglist.add(imgArray[i]);
			}
			mo.setImgList(imglist);
		}
		// 2.将商品标签转化成List集合形式
		if (mo.getModTag() != null && !"".equals(mo.getModTag())) {
			System.out.println("mo.getModTag()=" + mo.getModTag());
			String[] tagArray = mo.getModTag().split(";");
			System.out.println("标签个数：" + tagArray.length);
			List<String> tagList = new ArrayList<String>();
			for (int j = 0; j < tagArray.length; j++) {

				tagList.add(tagArray[j]);
			}
			mo.setTagList(tagList);
		}
		return mo;
	}

	/**
	 * 自定义内部方法：5.整理商品规格信息
	 * 
	 * @param Model
	 * @return Model
	 * @date 2015年12月16日
	 * @auther luans
	 */
	public Model modelTypeHandel(Model mo) {
		List<ModelType> modeltypeList = new ArrayList<ModelType>();
		ModelType modeltype = new ModelType();
		modeltype.setModtModid(mo.getMid());
		modeltype.setMarkSel(1);// 材质
		modeltypeList = modelTypeServiceImpl.queryModelTypeBymid(modeltype);
		if (modeltypeList.size() > 0) {
			mo.setTexttrueList(modeltypeList);
		}
		modeltype.setMarkSel(2);// 尺寸
		modeltypeList = modelTypeServiceImpl.queryModelTypeBymid(modeltype);
		if (modeltypeList.size() > 0) {
			mo.setSizeList(modeltypeList);
		}

		return mo;
	}

	/**
	 * 自定义内部方法：5.设置公共商品类别Session值
	 * 
	 * @param Model
	 * @date 2016年3月30日
	 * @auther luans
	 */
	public void setCategorySession(HttpServletRequest request) {
		HttpSession sessions = request.getSession();
		// 查询商品类别
		List<Category> categoryList = categoryServiceImpl
				.queryCategoryForIndex();
		sessions.setAttribute("categoryListForHander", categoryList);// 将商品类别放入Session，公共调用
	}
}
