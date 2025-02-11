package in.ashokit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static HikariDataSource ds = null;

	public static Connection getConnection() throws Exception {
		if (ds == null) {
			File file = new File("I:\\Ashok It Advanced Java\\UserWebApp\\dbConfig.properties");
			FileInputStream fis = new FileInputStream(file);

			Properties p = new Properties();
			p.load(fis);

			HikariConfig config = new HikariConfig();
			config.setUsername(p.getProperty("db.username"));
			config.setPassword(p.getProperty("db.password"));
			config.setJdbcUrl(p.getProperty("db.url"));
			config.setDriverClassName(p.getProperty("db.driver"));

			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}
}
