package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import traveller.traveller;
import traveller.travellingrequest;

/**
 * Servlet implementation class travelrequest
 */
@WebServlet("/travelrequest")
public class travelrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public travelrequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		
		HttpSession s=request.getSession();
		String n = (String)s.getAttribute("travellerid");
		
		String source = request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		travellingrequest tr=new travellingrequest();
		tr.setSource(source);
		tr.setDestination(destination);
		tr.setDate(date);
		tr.setTime(time);
		tr.setTravellerid(n);
		
		int r=tr.travelrequestinsert();
		
		pw.print("<body bgcolor='pink'>");

		
		if(r==1)
			pw.print("sucessfully regestration");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
