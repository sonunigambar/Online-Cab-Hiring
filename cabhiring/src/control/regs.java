package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traveller.traveller;

/**
 * Servlet implementation class regs
 */
@WebServlet("/regs")
public class regs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String phno=request.getParameter("pno");
		String address=request.getParameter("adr");
		String gender=request.getParameter("gender");
		String pwd=request.getParameter("pwd");
		
		traveller e = new traveller();
		
		e.setUname(username);
		e.setEmail(email);
		e.setPhno(phno);
		e.setAdr(address);
		e.setGender(gender);
		e.setPwd(pwd);
		int r=e.insert();
		PrintWriter pw = response.getWriter();
		pw.print("<body bgcolor='pink'>");
		
		if(r==1)
			
			pw.print("<center>sucessfully regestration</center>");
		if(r==-1)
		pw.print("<center>this emailid have already exist</center>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<a href='homepage.html'><center>Go To Home </center></a>");    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
