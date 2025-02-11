package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectEmpWithAddress {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/myshop";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Pass@123";
	private static final String EMP_SELECT = "SELECT * FROM EMP e, EMP_ADDRESS a WHERE e.emp_id = a.emp_id and e.emp_id = ?";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int employeeId = sc.nextInt();
        
		PreparedStatement pstmt = con.prepareStatement(EMP_SELECT);

		 pstmt.setInt(1, employeeId);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
		}
		con.close();
	}
}
