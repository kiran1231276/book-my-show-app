
package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBooks {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/myshop";

	private static final String DB_UNAME = "root";

	private static final String DB_PWD = "Pass@123";

	private static final String SELECT_SQL = "SELECT * FROM BOOKS WHERE BOOK_ID=104";

	public static void main(String[] args) throws Exception {

		// Step-1 : Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step-2 : Get DB Connection
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		// Step-3 : Create Statement
		Statement stmt = con.createStatement();

		// Step-4 : Execute Query
		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		// Step-5 : Process Result
		if (rs.next()) {
			int bookid = rs.getInt("BOOK_ID");
			String name = rs.getString("BOOK_NAME");
			double price = rs.getDouble("BOOK_PRICE");

			System.out.println(bookid);
			System.out.println(name);
			System.out.println(price);
		} else {
			System.out.println("No Records Found");
		}
		// System.out.println("Retrieve data :: " + rs);

		// Step-6 : Close Connection
		con.close();

	}
}
