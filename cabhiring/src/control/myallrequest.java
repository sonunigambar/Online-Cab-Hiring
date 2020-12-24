package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import traveller.travellerrequest;
import traveller.travellingrequest;

/**
 * Servlet implementation class myallrequest
 */
@WebServlet("/myallrequest")
public class myallrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myallrequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s=request.getSession();
		String travellerid = (String)s.getAttribute("travellerid");
		
		//String tid = request.getParameter("tid");
		
		travellerrequest tr=new travellerrequest();
		tr.setTravellerid(travellerid);
		
		//tr.setTravelid(travelid);
		
		ArrayList ar=tr.myallrequest();
		
		request.setAttribute("myallrequest",ar);
		
		RequestDispatcher rd=request.getRequestDispatcher("/myrequest.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
