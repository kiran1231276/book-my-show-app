package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TxManagement {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/myshop";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Pass@123";
	private static final String EMP_INSERT = "INSERT INTO EMP VALUES(?,?,?)";
	private static final String EMP_ADDR_INSERT = "INSERT INTO EMP_ADDRESS VALUES(?,?,?,?)";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		// By Default conn - autoCommit mode is true

		con.setAutoCommit(false);

		try {
			PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
			pstmt.setInt(1, 101);
			pstmt.setString(2, "John");
			pstmt.setDouble(3, 1000.00);

			pstmt.executeUpdate();

			pstmt = con.prepareStatement(EMP_ADDR_INSERT);
			pstmt.setString(1, "Hyd");
			pstmt.setString(2, "TG");
			pstmt.setString(3, "India");
			pstmt.setInt(4, 101);

			pstmt.executeUpdate();

			con.commit();

			System.out.println("Records Inserted...");

		} catch (Exception e) {
			System.out.println("Transcation Rolled Back....");
			con.rollback();
		}
		con.close();
	}
}
