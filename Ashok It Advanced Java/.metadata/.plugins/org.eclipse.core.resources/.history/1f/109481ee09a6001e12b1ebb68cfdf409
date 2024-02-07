package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ashokit.dto.UserDto;
import in.ashokit.util.ConnectionFactory;

public class UserDao {

	private static final String INSERT_SQL = "INSERT INTO user_tbl (user_name, user_email, user_phno) VALUES (?, ?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM user_tbl";
	 private static final String DELETE_SQL = "DELETE FROM user_tbl WHERE user_id = ?";
	    private static final String UPDATE_SQL = "UPDATE user_tbl SET user_name = ?, user_email = ?, user_phno = ? WHERE user_id = ?";
	public boolean saveUser(UserDto userDto) {
		boolean isSaved = false;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getUserEmail());
			pstmt.setLong(3, userDto.getUserPhno());

			int count = pstmt.executeUpdate();
			isSaved = count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}

	public List<UserDto> getUsers() {
		List<UserDto> users = new ArrayList<>();
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_SQL);

			while (rs.next()) {
				UserDto user = new UserDto();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserPhno(rs.getLong("user_phno"));

				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	 public boolean deleteUserById(int userId) {
	        boolean isDeleted = false;
	        try {
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pstmt = con.prepareStatement(DELETE_SQL);
	            pstmt.setInt(1, userId);
	            int count = pstmt.executeUpdate();
	            isDeleted = count > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isDeleted;
	    }

	    public boolean updateUser(UserDto userDto) {
	        boolean isUpdated = false;
	        try {
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL);
	            pstmt.setString(1, userDto.getUserName());
	            pstmt.setString(2, userDto.getUserEmail());
	            pstmt.setLong(3, userDto.getUserPhno());
	            pstmt.setInt(4, userDto.getUserId());
	            int count = pstmt.executeUpdate();
	            isUpdated = count > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isUpdated;
	    }
}
