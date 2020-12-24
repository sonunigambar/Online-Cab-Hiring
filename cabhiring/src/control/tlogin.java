package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import traveller.traveller;

/**
 * Servlet implementation class login
 */
@WebServlet("/tlogin")
public class tlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter pw = response.getWriter() ;	
		
		traveller tr=new traveller();
		tr.dbconnection();
		tr.setEmail(email);
		tr.setPwd(password);
		String travellerid=tr.login();
		if(travellerid.equals("invalid"))
			pw.print("invalid user id/password");
		else if(travellerid.equals("null")!=true){
			
			HttpSession  s=request.getSession();
			s.setAttribute("travellerid", travellerid);
			
			response.sendRedirect("thome");		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
