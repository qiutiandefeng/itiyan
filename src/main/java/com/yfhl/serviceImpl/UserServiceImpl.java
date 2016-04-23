package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.DesignerApply;
import com.yfhl.entity.DesignerCollection;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.User;
import com.yfhl.mapper.DesignerApplyMapper;
import com.yfhl.mapper.UserMapper;
import com.yfhl.service.UserService;

/**
 * 用户管理ServiceImpl实现类
 * 
 * @author luans
 * @date 2015年11月9日
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	public UserMapper userMapper;// 注入用户dao层实例对象
	@Resource
	public DesignerApplyMapper designerApplyMapper;// 注入申请设计师dao层实例对象

	/**
	 * 查询用户List
	 * 
	 * @param user
	 * @return List<User>
	 * @date 2015年11月9日
	 * @auther luans
	 */
	public List<User> queryList(User user) {

		return userMapper.queryList(user);
	}

	/**
	 * 分页查询用户List
	 * 
	 * @param user
	 * @return List<User>
	 * @date 2015年11月10日
	 * @auther luans
	 */
	public List<User> queryListByPage(User user) {
		System.out.println("进入分页查询ServiceImpl");
		return userMapper.queryListByPage(user);
	}

	/**
	 * 
	 * 查询用户：根据条件查询用户
	 * 
	 * @param User
	 * @return User
	 * @date 2015年11月11日
	 * @auther luans
	 */
	public User queryUser(User user) {
		return userMapper.queryUser(user);
	}

	/**
	 * 用户管理：添加用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月11日
	 * @auther luans
	 */
	public int insertSelective(User user) {
		// 添加用户是数据库中的默认字段设置
		user.setdFavoriteNum(0);// 设计师被收藏数：默认为0
		// SimpleDateFormat df = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式df.format(new Date())
		user.setApplyDesigner(1);// 1: 非申请状态 2:申请中
		user.setWxpOpenid("");
		user.setWxUnionid("");
		user.setRegTime(new Date());// 注册时间
		user.setDelState(2);// 状态：1删除；2正常
		user.setGroupId(1);// 1：普通用户 2：管理员 3：供应商 4：签约设计师

		return userMapper.insertSelective(user);
	}

	/**
	 * 用户管理：修改用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月12日
	 * @auther luans
	 */
	public int userUpdate(User user) {
		return userMapper.userUpdate(user);
	}

	/**
	 * 用户管理：删除用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月13日
	 * @auther luans
	 */
	public void userDel(User user) {

		userMapper.userDel(user);
	}

	/**
	 * 用户管理：添加设计师
	 * 
	 * @param User
	 *            ,DesignerApply
	 * @return int
	 * @date 2015年11月16日
	 * @auther luans
	 */
	public int insert(User user, DesignerApply designerApply) {
		// 添加用户是数据库中的默认字段设置
		designerApply.setApplydState(1); // 申请状态：1: 申请中 2：已签约 3：未签约
		designerApply.setApplydTime(new Date());// 申请时间
		if (user.getUid() == 0) {// 添加设计师：如果还不是用户，则先添加成为用户

			// 先添加成为用户
			user.setUsername(designerApply.getApplydUsername());// 用户名
			user.setRealname(designerApply.getRealname());//真实姓名
			user.setdUsername(designerApply.getApplydDname());// 设计师名字
			user.setAvatar(designerApply.getApplydAvatar());// 头像路径
			user.setdBrand(designerApply.getApplydBrand());// 品牌
			user.setApplyReason(designerApply.getApplyReason());//品牌故事
			//user.setdField(designerApply.getField());// 设计领域
			user.setdTag(designerApply.getApplydDtag());// 标签
			//user.setEmail(designerApply.getApplydEmail());// 邮箱
			user.setdAddress(designerApply.getApplydAddress());// 所在地
			user.setStudioStatus(1);// 申请状态：1: 申请中 2：已签约 3：未签约

			this.insertSelective(user);// 添加用户：用户的id会封装到实体类中，可以直接获取
			System.out.println("刚刚插入的用户的ID:"+user.getUid());
			designerApply.setUid(user.getUid());
		}
		return designerApplyMapper.insert(designerApply);
	}

	/**
	 * 导出Excel：获取导出普通用户信息
	 * 
	 * @param User
	 * @return List<User>
	 * @date 2015年11月18日
	 * @auther luans
	 */
	public List<User> queryOutUser(User user) {
		return userMapper.queryOutUser(user);
	}

	/**
	 * 用户管理：统计平台和微信端的总数
	 * 
	 * @param User
	 * @return User
	 * @date 2015年11月19日
	 * @auther luans
	 */
	public User queryUserCount(User user) {
		return userMapper.queryUserCount(user);
	}

	/**
	 * 修改设计师收藏数:通过商品收藏表
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollectionBym(ModelCollection mCollection) {
		return userMapper.updateCollectionBym(mCollection);
	}

	/**
	 * 修改设计师收藏数:通过设计师收藏表
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollectionByd(DesignerCollection designerCollection) {
		return userMapper.updateCollectionByd(designerCollection);
	}

	/**
	 * 查询最新添加的设计师：PC端首页显示设计师 (6名)
	 * 
	 * @return List<User>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<User> queryDesigners() {
		return userMapper.queryDesigners();
	}

	/**
	 * 查询设计师所有品牌
	 * 
	 * @param String
	 * @return List<User>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<User> queryBrand(String condition) {
		return userMapper.queryBrand(condition);
	}

	public User getSelectUser(User user) {
		return userMapper.getSelectUser(user);
	}

	// 15601312825 song

	public int updateLoginState(User sysuser) {

		return userMapper.updateByPrimaryKey(sysuser);
	}

	public int getCountUserByTime(String startTime, String endTime,
			String groupId) {
		return userMapper.getCountUserByTime(startTime, endTime, groupId);
	}

	public int getCountDesignerUserByTime(String startTime, String endTime,
			String groupId) {
		return userMapper.getCountDesignerUserByTime(startTime, endTime,
				groupId);

	}

	public User getUserByUid(Integer uid) {
		return userMapper.getUserByUid(uid);
	}

	public User getAuthorByUId(Integer authorId) {
		return userMapper.getAuthorByUId(authorId);
	}

	/**
	 * 根据登录用户名查询用户信息
	 * 
	 * @param name
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月8日
	 */
	public User getPwdByName(String username) {
		return userMapper.getPwdByName(username);
	}

	/**
	 * 验证注册的用户手机号/邮箱是否重复
	 * 
	 * @param HttpServletRequest
	 * @return Map
	 * @date 2016年3月6日
	 * @auther luans
	 */
	public Integer checkSameName(String username) {
		return userMapper.checkSameName(username);
	}

	/**
	 * PC端前台：验证旧密码
	 * 
	 * @param User
	 * @return Integer
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public Integer checkoldPwdPC(User user) {
		return userMapper.checkoldPwdPC(user);
	}

	/**	
	 * PC端前台：修改密码
	 * 
	 * @param User
	 * @return Integer
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public Integer changePwd(User user) {
		return userMapper.changePwd(user);
	}

	/**
	 * 根据微信用户的openId查询用户
	 * @param openid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月21日
	 */
	@Override
	public User getUserByopenId(String openid) {
		
		return userMapper.getUserByopenId(openid);
		
	}
}
