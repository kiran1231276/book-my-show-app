package in.ashokit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.UserDao;
import in.ashokit.dto.UserDto;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		List<UserDto> users = userDao.getUsers();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/ViewUsers.jsp").forward(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//capture the data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");

		//set form data to userdto object for transfer
		UserDto userDto = new UserDto();
		userDto.setUserName(name);
		userDto.setUserEmail(email);
		userDto.setUserPhno(Long.parseLong(phno));

		//call dao method
		UserDao dao = new UserDao();
		boolean isSaved = dao.saveUser(userDto);

		//msg displayed on saved page
		String msg = null;
		if (isSaved) {
			msg = "User Saved";
		} else {
			msg = "User not saved";
		}

		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		String action = request.getParameter("action");

	    if (action != null && action.equals("edit")) {
	        String userIdStr = request.getParameter("userId");
	        if (userIdStr != null && !userIdStr.isEmpty()) {
	            int userId = Integer.parseInt(userIdStr);
	            response.sendRedirect(request.getContextPath() + "/editUser.jsp?id=" + userId);
	            return;
	        }
	    }
		
	}	
}
