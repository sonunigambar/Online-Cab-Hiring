package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import traveller.paymentinfo;
import traveller.rate;

/**
 * Servlet implementation class carddetails
 */
@WebServlet("/carddetails")
public class carddetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public carddetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String tid = request.getParameter("tid");
		String driverid = request.getParameter("driverid");
		
		String cardno=request.getParameter("cardno");
		String pin=request.getParameter("pin");
		String expmonth=request.getParameter("expmonth");
		String expyear=request.getParameter("expyear");
		String cardholdername=request.getParameter("cardholdername");
		int amount=Integer.parseInt(request.getParameter("amount"));
		System.out.println(amount);
		System.out.println(driverid);
		
		PrintWriter out=response.getWriter();
		rate r=new rate();
		
		r.setCardno(cardno);
		r.setPin(pin);
		r.setExpmonth(expmonth);
		r.setExpyear(expyear);
		r.setCardholdername(cardholdername);
				
		int b = r.chkcarddt();
		
		PrintWriter pw = response.getWriter();
		pw.print("<body bgcolor='pink'>");
		
		if(b==-1)
			pw.print("<center>Invalid Card Details</center>");
		
		
		
		else if(b!=-2)
		{
			
			if(amount>b)
				out.print("<center>Insufficient Balance</center>");
			else
			{
				int cb = b - amount;
				
				r.setBalance(cb);
				
				int i = r.updatebalance();
				
				if(i!=0)
				{
					//response.sendRedirect("");
					
					paymentinfo pi=new paymentinfo();
					
					pi.setTravelid(tid);
					pi.setPstatus("Paid");
					
					int paymentinfo=pi.updatepaymentinfo();
					
					out.print("<center>transction successfull</center>");					
					
				}
			}
		}
		
		pw.print("<h1><a href=tlogin.html><center>Login</center></a></h1>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<h1><a href=homepage.html><center>Go To Home</center></a></h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
