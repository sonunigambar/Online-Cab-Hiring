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

import traveller.paymentinfo;
import traveller.rate;
import traveller.travellingrequest;

/**
 * Servlet implementation class tstatus
 */
@WebServlet("/tstatus")
public class tstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tstatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//HttpSession s=request.getSession();
		//String travellerid=(String)s.getAttribute("travellerid");
		
		String travelid=request.getParameter("travelid");
		
		
		paymentinfo pi=new paymentinfo();
		pi.setTravelid(travelid);	
		int amount = pi.getamount();
		
		travellingrequest tr=new travellingrequest();
		tr.setTravelid(travelid);
		tr=tr.tstatus();
		
		request.setAttribute("tid", travelid);
		request.setAttribute("tstatus", tr);
		request.setAttribute("amount", amount);
			
		RequestDispatcher rd=request.getRequestDispatcher("/tstatus.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
