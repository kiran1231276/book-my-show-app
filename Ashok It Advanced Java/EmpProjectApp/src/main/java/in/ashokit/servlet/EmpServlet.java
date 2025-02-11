package in.ashokit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.EmpDao;
import in.ashokit.dto.EmpDto;

@WebServlet("/insert")
public class EmpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//capture the data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dept = request.getParameter("dept");
        String exp = request.getParameter("exp");

    	//set form data to Empdto object for transfer
        EmpDto empDto = new EmpDto();
        empDto.setEmpName(name);
        empDto.setEmpEmail(email);
        empDto.setEmpGender(gender);
        empDto.setEmpDept(dept);
        empDto.setEmpExp(Integer.parseInt(exp));

        //call dao method
        EmpDao dao = new EmpDao();
        boolean isSaved = dao.saveEmp(empDto);

        //msg displayed on saved page
        String msg = (isSaved) ? "Emp Saved" : "Emp not saved";
        
    	// send msg to jsp page
        request.setAttribute("msg", msg);
        
     // redirect request to same jsp page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
