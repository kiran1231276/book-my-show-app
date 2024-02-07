package in.ashokit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;

public class EmpHikeOnRole {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/myshop";

	private static final String DB_UNAME = "root";

	private static final String DB_PWD = "Pass@123";
	
	private static final String SELECT_SQL = "SELECT * FROM EMPLOYEE";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Emp Hike For Hr Dept :: ");
		double HrDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike For Sales Dept :: ");
		double SalesDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike For Admin Dept :: ");
		double AdminDeptHike = sc.nextDouble();
		
		System.out.println("Enter Emp Hike For Security Dept :: ");
		double SecurityDeptHike = sc.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		String UPDATE_SAL_SQL = "UPDATE EMPLOYEE SET EMP_SALARY=EMP_SALARY + (EMP_SALARY * ?) / 100 WHERE EMP_DEPT=?";

		PreparedStatement pstmt = con.prepareStatement(UPDATE_SAL_SQL);
		
			pstmt.setDouble(1, HrDeptHike);
			pstmt.setString(2, "HR");
			pstmt.executeUpdate();
			
			pstmt.setDouble(1, SalesDeptHike);
			pstmt.setString(2, "Sales");
			pstmt.executeUpdate();
		
			pstmt.setDouble(1, AdminDeptHike);
			pstmt.setString(2, "Admin");
			pstmt.executeUpdate();
			
			pstmt.setDouble(1, SecurityDeptHike);
			pstmt.setString(2, "Security");
			pstmt.executeUpdate();

		System.out.println("Update completed....");
		con.close();
	}
}


