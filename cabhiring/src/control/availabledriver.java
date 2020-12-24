
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

/**
 * Servlet implementation class assigndriver
 */
@WebServlet("/availabledriver")
public class availabledriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public availabledriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		String rdate=request.getParameter("tdt");
		
		String travelid=request.getParameter("travelid");
		String travellerid=request.getParameter("travellerid");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		
		driver d = new driver();
		d.setDate(rdate);
		
		ArrayList ar = d.getavailabledrivers();
		
		request.setAttribute("drivers", ar);
		request.setAttribute("travelid", travelid);
		request.setAttribute("travellerid", travellerid);
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
		PrintWriter pw=response.getWriter();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showdrivers.jsp");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
