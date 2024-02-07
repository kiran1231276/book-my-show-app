package in.ashokit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		PrintWriter pw = resp.getWriter();
		pw.append("this is first servlet response");
		
		RequestDispatcher rd= req.getRequestDispatcher("secondServlet");
		//rd.forward(req, resp);
		rd.include(req, resp);
	}
}
