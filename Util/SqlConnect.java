package Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class SqlConnect {
	
	public static Connection getcon(){
		Connection conn = null;
		try {
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.config");
			Properties pro = new Properties();
			pro.load(is);
			DataSource source = DruidDataSourceFactory.createDataSource(pro);
			conn = source.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public void closecon(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void test() {
		Connection getcon = getcon();
		System.out.println(getcon);
	}

}
