package in.ashokit;

import java.sql.Connection;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/myshop";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Pass@123";

	public static void main(String[] args) throws Exception {

		HikariConfig config = new HikariConfig();

		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);

		config.setMaximumPoolSize(20);
		config.setMinimumIdle(5);

		HikariDataSource datasource = new HikariDataSource(config);

		Connection con = datasource.getConnection();

		String sql = "INSERT INTO BOOKS VALUES (202, 'Django', 4500.00)";

		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

		System.out.println("RECORD INSERTED.....");
		con.close();
	}
}
