package com.yfhl.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.Texture;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年12月10日 上午10:06:22
 * 类说明
 */
public class PHPToJavaDao {
	
	public List<Model> getModelAll() throws Exception {
		List<Model> ts = new ArrayList<Model>();
		try {
			Connection conn = DBConnection.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select mid,texture,size from hs_model");
			while(rs.next()){
				Model m = new Model();
				m.setMid(rs.getInt(1));
				m.setTexture(rs.getString(2));
				m.setSize(rs.getString(3));
				ts.add(m);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ts;
	
	}

	public List<Texture> selectByPrimaryKey(Integer valueOf) {
		List<Texture> ts = new ArrayList<Texture>();
		try {
			Connection conn = DBConnection.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from hs_texture where tid="+valueOf);
			while(rs.next()){
				Texture t = new Texture();
				t.setTid(rs.getInt(1));
				t.setTitle(rs.getString(2));
				t.setDescription(rs.getString(3));
				t.setDescr(rs.getString(4));
				t.setImg(rs.getString(5));
				t.setPrice(rs.getFloat(6));
				t.setTextureColor(rs.getString(7));
				ts.add(t);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ts;
	
	}

	public int insertSelective(ModelType modelType) {
		int flag = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement  rs = conn.prepareStatement("insert into hs_modeltype value(?,?,?,?,?,?,?,?,?)");
			rs.setInt(1, modelType.getModtModid()); //设置参数1，创建id为5的数据
			rs.setFloat(2, modelType.getModtPrice());;
			rs.setInt(3, modelType.getModtRepertory());//设置参数2，name 为小明
			rs.setString(4, modelType.getModtImg());
			rs.setString(5, modelType.getModtColor());
			rs.setString(6,modelType.getModtColorDesc());
			rs.setString(7, modelType.getModtTexture());
			rs.setString(8, modelType.getModtSize());
			rs.setInt(9, modelType.getModtDelstate());
			flag = rs.executeUpdate();			//执行更新
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
