package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import traveller.driver;
import traveller.traveller;
import traveller.travellingrequest;

/**
 * Servlet implementation class dlogin
 */
@WebServlet("/dlogin")
public class dlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String demail=request.getParameter("email");
		String dpassword=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		driver d=new driver();
		d.setDid(demail);
		d.setPassword(dpassword);
		
		String r=d.dlogin();
		if(r.equals("invalid"))
			pw.print("invalid user id/password");
		else if(r.equals("null")!=true){
		System.out.print(r);
		//pw.print("<center><a href=dstatus?did=demail>Status</a></center>");	
		}
		request.setAttribute("did",demail);
		RequestDispatcher rd = request.getRequestDispatcher("dstatus");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
