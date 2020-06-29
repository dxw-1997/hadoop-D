package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import Moder.admin;
import Moder.user;

public class userDao extends baseDao{
	public  user login(user usertmp) {
		user users = null;
		try {
			String sql = "select id,name,password,createDate from user where name = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setObject(1,usertmp.getName());
		    ps.setObject(2, usertmp.getPassword());
		    ResultSet set = ps.executeQuery();
		    if(set.next()) {
		    	users = new user();
		    	users.setId(set.getInt("id"));
		    	users.setName(set.getString("name"));
		    	users.setPassword(set.getString("password"));
		    	users.setCreateDate(set.getString("createDate"));
		    	
		}
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return users;
	}
	public String creaUser(String name,String password) {
		String sql = "insert into user(name,password) values(?,?)";
		QueryRunner runner = new QueryRunner();
		try {
			int i = runner.update(conn, sql, name,password);
			if(i>0) {
				return "添加成功！";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return "添加失败！";
	}
	public String updapass(user us,String newpassword) {
		PreparedStatement ps = null;
		int id = 0;
		String s = "修改失败";
		try {
			String sql = "select id,name,password,createDate from user where  password = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, us.getPassword());
			ResultSet set = ps.executeQuery();
			if(!set.next()) {
				return "修改失败".toString();
			}
			id = set.getInt("id");
			String sql1 = "update user set password = ? where id = ?";
			ps = conn.prepareStatement(sql1);
			ps.setObject(1, newpassword);
			ps.setObject(2, id);
			int update = ps.executeUpdate();
			if(update>0) {
				s = "修改成功";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return s;
	}
	public String deleteUser(String name) {
		String sql = "delete from user where name = ?";
		QueryRunner runner = new QueryRunner();
		try {
			int i = runner.update(conn, sql, name);
			if(i>0) {
				return "删除成功！";
			}
		} catch (Exception e) {
			
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return "删除失败！";
	}
	public  user search(user usertmp) {
		user users = null;
		try {
			String sql = "select id,name,password,createDate from user where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setObject(1,usertmp.getName());
		    ResultSet set = ps.executeQuery();
		    if(set.next()) {
		    	users = new user();
		    	users.setId(set.getInt("id"));
		    	users.setName(set.getString("name"));
		    	users.setPassword(set.getString("password"));
		    	users.setCreateDate(set.getString("createDate"));
		    	
		}
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return users;
	}
	@Test
	public void test() {
		userDao dao = new userDao();
		user usertmp = new user();
		usertmp.setName("dxw1997");
		user search = dao.search(usertmp);
		
		System.out.println(search);
	}
}
