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

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		
		String address=request.getParameter("adr");
		String phno=request.getParameter("phno");
		String pwd=request.getParameter("pwd");
		
		traveller t=new traveller();
		t.setEmail(travellerid);
		t.setAdr(address);
		t.setPhno(phno);
		t.setPwd(pwd);
		
		int r = t.update();
		
		PrintWriter pw = response.getWriter();
		pw.print("<body bgcolor='pink'>");
		
		if(r==1)
			pw.print("<br>");
			pw.print("<br>");
			pw.print("<center>Sucessfully Updated</center>");
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
