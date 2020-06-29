package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import Moder.admin;

public class adminDao extends baseDao {
	public  admin login(admin admin) {
		admin adm = null;
		try {
			String sql = "select id,name,password,createDate from admin where name = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setObject(1,admin.getName());
		    ps.setObject(2, admin.getPassword());
		    ResultSet set = ps.executeQuery();
		    if(set.next()) {
		    	adm = new admin();
		    	adm.setId(set.getInt("id"));
		    	adm.setName(set.getString("name"));
		    	adm.setPassword(set.getString("password"));
		    	adm.setCreateDate(set.getString("createDate"));
		    	
		}
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return adm;
	}
	public String updapass(admin admin,String newpassword) {
		PreparedStatement ps = null;
		int id = 0;
		String s = "修改失败";
		try {
			String sql = "select id,name,password,createDate from admin where  password = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, admin.getPassword());
			ResultSet set = ps.executeQuery();
			if(!set.next()) {
				return "修改失败".toString();
			}
			id = set.getInt("id");
			String sql1 = "update admin set password = ? where id = ?";
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
	@Test
	public void test() {
		admin admintmp = new admin();
		admintmp.setPassword("123456");
		String s = "123";
		String updapass = updapass(admintmp, s);
		System.out.println(updapass);
	}
}
