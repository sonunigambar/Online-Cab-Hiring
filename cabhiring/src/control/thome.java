package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forward
 */
@WebServlet("/thome")
public class thome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s=request.getSession();
		String travellerid=(String)s.getAttribute("travellerid"); 
		
		request.setAttribute("travellerid", travellerid);
		PrintWriter pw = response.getWriter() ;
		pw.print("<body bgcolor='pink'>");
		
		pw.print("<a href='travelrequest.html'><center>travelrequest </center></a>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
		
		pw.print("<a href='entertravelid.html'><center>Make Payment</center></a>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
		
		pw.print("<a href='myallrequest'><center>Show all request</center></a>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
			
		pw.print("<a href='edit' target='_blank'><center>Edit your profile</center></a>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
		
		pw.print("<a href='logout.jsp'><center>Log Out</center></a>");
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
