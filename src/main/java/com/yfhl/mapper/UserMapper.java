package com.yfhl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.DesignerCollection;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.User;

/**
 * 用户管理Dao层
 * 
 * @author luans
 * @date 2015年11月9日
 */
public interface UserMapper {

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
	 * @auther:luans
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
	 * 设计师管理：审核
	 * 
	 * @param User
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public void densignerApplyPass(User user);

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
	 * 修改设计师收藏数:通过设计师收藏表
	 * 
	 * @param designerCollection
	 * @return
	 * @auther luans
	 */
	public int updateCollectionByd(DesignerCollection designerCollection);

	/**
	 * 修改设计师收藏数:通过商品收藏表
	 * 
	 * @param mCollection
	 * @return
	 * @auther luans
	 */
	public int updateCollectionBym(ModelCollection mCollection);

	/**
	 * 验证注册的用户手机号/邮箱是否重复
	 * 
	 * @param HttpServletRequest
	 * @return Map
	 * @date 2016年3月6日
	 * @auther luans
	 */
	public Integer checkSameName(@Param("username") String username);

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
	public List<User> queryBrand(@Param("condition")String condition);
	
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
	 * 根据用户的条件查询
	 * 
	 * @param user
	 * @return
	 * @author Chris
	 */
	public User getSelectUser(User user);

	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	User selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeyWithBLOBs(User record);

	int updateByPrimaryKey(User record);

	public Object updateLoginState(String valueOf, int i);

	public int getCountUserByTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("groupId") String groupId);

	public int getCountDesignerUserByTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("groupId") String groupId);

	public User getUserByUid(Integer uid);

	/**
	 * 根据商品编号查询商品所属的设计师
	 * 
	 * @param mid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月26日
	 */
	public User getAuthorByUId(Integer mid);

	/**
	 * 根据登录用户名查询用户信息
	 * 
	 * @param name
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月8日
	 */
	public User getPwdByName(@Param("username") String username);

	/**
	 * 根据微信用户的openId查询用户
	 * @param openid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月21日
	 */
	public User getUserByopenId(String openid);
}