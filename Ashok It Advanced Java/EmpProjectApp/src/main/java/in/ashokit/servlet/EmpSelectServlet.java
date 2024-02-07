package in.ashokit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.EmpDao;
import in.ashokit.dto.EmpDto;

@WebServlet("/select")
public class EmpSelectServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capture the data
      
        String gender = request.getParameter("gender");
        String dept = request.getParameter("dept");
        String exp = request.getParameter("exp");

    	//set form data to Empdto object for transfer
        EmpDto empDto = new EmpDto();
        empDto.setEmpGender(gender);
        empDto.setEmpDept(dept);

        
        if(!exp.equals("")) {
        empDto.setEmpExp(Integer.parseInt(exp));
        }
        
        //call dao method
        EmpDao EmpDao = new EmpDao();
        List<EmpDto> emps = EmpDao.getEmps(empDto);
        
        
    	// send msg to jsp page
        request.setAttribute("emps", emps);
        
     // redirect request to same jsp page
        request.getRequestDispatcher("/emps.jsp").forward(request, response);
	}

}
