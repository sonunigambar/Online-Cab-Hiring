package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traveller.driver;
import traveller.traveller;

/**
 * Servlet implementation class dregs
 */
@WebServlet("/dregs")
public class dregs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dregs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String password=request.getParameter("password");
		
		driver d=new driver();
		
		d.setName(name);
		d.setEmail(email);
		d.setPhno(phno);
		d.setPassword(password);
		
		int r=d.insert();
		PrintWriter pw = response.getWriter();
		pw.print("<body bgcolor='pink'>");
		
		if(r==1)
			pw.print("<center>sucessfully regestration</center>");
			pw.print("<br>");
			pw.print("<br>");
			pw.print("<a href='homepage.html'><center>Go To Home </center></a>");
		if(r==-1)
			pw.print("<center>email already exist</center>");
			pw.print("<br>");
			pw.print("<br>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
