package Dao;

import java.sql.Connection;

import Util.SqlConnect;

public class baseDao {
	public  Connection conn = SqlConnect.getcon();
}
