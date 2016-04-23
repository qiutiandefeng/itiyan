package com.yfhl.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfhl.entity.DesignerApply;
import com.yfhl.entity.DesignerCollection;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.User;

/**
 * 用户管理Service
 * 
 * @author luans
 * @date 2015年11月9日
 */

public interface UserService {

	/**
	 * 查询用户List
	 * 
	 * @param User
	 * @return List<User>
	 * @date 2015年11月9日
	 * @auther luans
	 */
	public List<User> queryList(User user);

	/**
	 * 分页查询用户List
	 * 
	 * @param User
	 * @return List<User>
	 * @date 2015年11月10日
	 * @auther luans
	 */
	public List<User> queryListByPage(User user);

	/**
	 * 
	 * 查询用户：根据条件查询用户
	 * 
	 * @param User
	 * @return User
	 * @date 2015年11月11日
	 * @auther luans
	 */
	public User queryUser(User user);

	/**
	 * 用户管理：添加用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月11日
	 * @auther luans
	 */
	public int insertSelective(User user);

	/**
	 * 用户管理：修改用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月12日
	 * @auther luans
	 */
	public int userUpdate(User user);

	/**
	 * 用户管理：删除用户
	 * 
	 * @param User
	 * @return int
	 * @date 2015年11月13日
	 * @auther luans
	 */
	public void userDel(User user);

	/**
	 * 用户管理：添加设计师
	 * 
	 * @param User
	 *            ,DesignerApply
	 * @return int
	 * @date 2015年11月16日
	 * @auther luans
	 */
	public int insert(User user, DesignerApply designerApply);

	/**
	 * 导出Excel：获取导出普通用户信息
	 * 
	 * @param User
	 * @return List<User>
	 * @date 2015年11月18日
	 * @auther luans
	 */
	public List<User> queryOutUser(User user);

	/**
	 * 用户管理：统计平台和微信端的总数
	 * 
	 * @param User
	 * @return User
	 * @date 2015年11月19日
	 * @auther luans
	 */
	public User queryUserCount(User user);

	/**
	 * 修改设计师收藏数:通过商品收藏表
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollectionBym(ModelCollection mCollection);

	/**
	 * 修改设计师收藏数:通过设计师收藏表
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int updateCollectionByd(DesignerCollection designerCollection);

	/**
	 * 查询最新添加的设计师：PC端首页显示设计师 (6名)
	 * 
	 * @return List<User>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<User> queryDesigners();

	/**
	 * 查询设计师所有品牌
	 * 
	 * @param String
	 * @return List<User>
	 * @date 2016年3月16日
	 * @auther luans
	 */
	public List<User> queryBrand(String condition);
	/**
	 * 修改用户的登陆状态
	 * 
	 * @param sysuser
	 * @return
	 */
	public int updateLoginState(User sysuser);

	public User getSelectUser(User user);

	/**
	 * 根据用户的时间段查询用户的增长数
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param groupId
	 *            用户分组： null：没有分组全部的用户， 1：普通用户， 2：管理员，3：供应商， 4：签约设计师
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月13日
	 */
	public int getCountUserByTime(String startTime, String endTime,
			String groupId);

	/**
	 * 根据设计师的签约成功，按时间段来查询 设计师的增长量
	 * 
	 * @param startTime
	 * @param endTime
	 * @param groupId
	 *            用户分组： null：没有分组全部的用户， 1：普通用户， 2：管理员，3：供应商， 4：签约设计师
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月16日
	 */
	public int getCountDesignerUserByTime(String startTime, String endTime,
			String groupId);

	/**
	 * 根据用户的编号查询用户
	 * 
	 * @param uid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月17日
	 */
	public User getUserByUid(Integer uid);

	/**
	 * 根据商品的Id查询所属的设计师
	 * 
	 * @param author
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月26日
	 */
	public User getAuthorByUId(Integer authorId);

	/**
	 * 根据登录用户名查询用户信息
	 * 
	 * @param name
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月8日
	 */
	public User getPwdByName(String username);

	/**
	 * 验证注册的用户手机号/邮箱是否重复
	 * 
	 * @param HttpServletRequest
	 * @return Map
	 * @date 2016年3月6日
	 * @auther luans
	 */
	public Integer checkSameName(String username);

	/**
	 * PC端前台：验证旧密码
	 * 
	 * @param User
	 * @return Integer
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public Integer checkoldPwdPC(User user) ;
	/**
	 * PC端前台：修改密码
	 * 
	 * @param User
	 * @return Integer
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public Integer changePwd(User user) ;

	/**
	 * 根据微信用户的openId查询用户
	 * @param openid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月21日
	 */
	public User getUserByopenId(String openid);

}
