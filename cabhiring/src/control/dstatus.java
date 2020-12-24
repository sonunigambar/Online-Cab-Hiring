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

import traveller.driver;
import traveller.travellingrequest;

/**
 * Servlet implementation class dstatus
 */
@WebServlet("/dstatus")
public class dstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dstatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String did = (String)request.getAttribute("did");
		PrintWriter pw=response.getWriter();
		//pw.print(did);
		driver dr=new driver();
		dr.setDid(did);
		ArrayList ar=dr.driverstatus();
		request.setAttribute("dstatus", ar);
		request.setAttribute("did", did);
		
		RequestDispatcher rd=request.getRequestDispatcher("/dstatus.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
