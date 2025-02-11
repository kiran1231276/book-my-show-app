package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.ashokit.dto.EmpDto;
import in.ashokit.util.ConnectionFactory;

public class EmpDao {

	private static final String INSERT_SQL = "INSERT INTO emp_table (emp_name, emp_email, emp_gender, emp_dept, emp_exp) VALUES (?, ?, ?, ?, ?)";

	public boolean saveEmp(EmpDto empDto) {
		int count = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

			pstmt.setString(1, empDto.getEmpName());
			pstmt.setString(2, empDto.getEmpEmail());
			pstmt.setString(3, empDto.getEmpGender());
			pstmt.setString(4, empDto.getEmpDept());
			pstmt.setInt(5, empDto.getEmpExp());

			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0;
	}

	public List<EmpDto> getEmps(EmpDto empDto) {

		StringBuilder sql = new StringBuilder("select * from emp_table where 1=1");
		List<EmpDto> emps = new ArrayList<>();

		try {
			if (empDto.getEmpDept() != null && !empDto.getEmpDept().equals("")) {
				sql.append("and emp_dept=?");
			}
			if (empDto.getEmpGender() != null && !empDto.getEmpGender().equals("")) {
				sql.append("and emp_gender=?");
			}
			if (empDto.getEmpExp() != null) {
				sql.append("and emp_exp=?");
			}

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			int index = 1;
			if (empDto.getEmpDept() != null && !empDto.getEmpDept().equals("")) {
				pstmt.setString(index, empDto.getEmpDept());
				index++;
			}
			if (empDto.getEmpGender() != null && !empDto.getEmpGender().equals("")) {
				pstmt.setString(index, empDto.getEmpGender());
				index++;
			}
			if (empDto.getEmpExp() != null) {
				pstmt.setInt(index, empDto.getEmpExp());
				index++;
			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setEmpId(rs.getInt("emp_id"));
				dto.setEmpName(rs.getString("emp_name"));
				dto.setEmpEmail(rs.getString("emp_email"));
				dto.setEmpGender(rs.getString("emp_gender"));
				dto.setEmpDept(rs.getString("emp_dept"));
				dto.setEmpExp(rs.getInt("emp_exp"));

				emps.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}
}
