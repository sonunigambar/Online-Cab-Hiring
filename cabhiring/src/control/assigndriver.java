package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traveller.driver;
import traveller.rate;

/**
 * Servlet implementation class assigndriver
 */
@WebServlet("/assigndriver")
public class assigndriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assigndriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String travelid=request.getParameter("travelid");
		String driverid=request.getParameter("driverid");
		String travellerid=request.getParameter("travellerid");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		
		driver d=new driver();
		
		d.setTravelid(travelid);
		d.setDid(driverid);
		
		int r=d.insertasigndriver();
		PrintWriter pw = response.getWriter();
		pw.print("<body bgcolor='pink'>");
		pw.print(driverid);
		pw.print(travelid);
		
		if(r==1)
			pw.print("go to assigndriver table");
		
		
		request.setAttribute("tid", travelid);
		request.setAttribute("did", driverid);
		request.setAttribute("travellerid", travellerid);
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
		
		
		rate rt=new rate();
		
		rt.setSource(source);
		rt.setDestination(destination);
		int fare = rt.getfare();
		
		request.setAttribute("fare", fare);
		
		RequestDispatcher rd=request.getRequestDispatcher("/MailServ1");
		rd.forward(request, response);
		
	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
