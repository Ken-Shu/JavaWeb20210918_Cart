package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/web";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1234568");	
			System.out.println(conn.isClosed());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

}
