package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import traveller.paymentinfo;
import traveller.rate;
import traveller.traveller;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MailServ1
 */
@WebServlet("/MailServ1")
public class MailServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static final String mailserver = "smtp.gmail.com";
    private static final String correctPassword = "xxx";
    private String from, to, password, filename;
    private String ln, bcc, subject, body,pw; 
	
	
	
    public MailServ1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String did=(String)request.getAttribute("did");
		//String tid=(String)request.getAttribute("tid");
		String travellerid=(String)request.getAttribute("travellerid");
		String travelid=(String)request.getAttribute("tid");
		int fare=(int) request.getAttribute("fare");
		
		PrintWriter out = response.getWriter();
	
		paymentinfo pi=new paymentinfo();
		//System.out.println("----" + travelid);
		pi.setTravelid(travelid);
		pi.setAmount(fare);
		pi.setPstatus("DUE");
				
		int paymentinfo=pi.inserttopaymentinfo();
		

		
		
		//ServletOutputStream out = response.getOutputStream();
		
		
		try
		{

		response.setContentType("text/plain");	
        
	        //File dir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
	        //System.out.print(getServletContext().getAttribute("javax.servlet.context.tempdir"));
	        //System.out.print(dir.getAbsolutePath());

	        //MultipartRequest mR = new MultipartRequest(request, dir.getAbsolutePath(), 1000000);
				
	        //Enumeration e = mR.getParameterNames();
	        //while (e.hasMoreElements())
	        //{
	        //   String key = (String)e.nextElement();
	            
	            //from = "rajat.official@yahoo.in";
	            	            
	           // if(key.equals("to")) {
	           // to = mR.getParameter(key);
	            	to = did;
	            	System.out.println(to);
	            //}
	            
	           // if(key.equals("ln")) {
	           // ln = mR.getParameter(key);
	           // from = mR.getParameter(key);
	            	ln="cabhiring10@gmail.com";
	            	from="cabhiring10@gmail.com";
	            //}
	            
	            //if(key.equals("pw")) {
	            // pw = mR.getParameter(key);
	            pw="327aa011";
	            //}
	            
	            //if(key.equals("bcc")) {
	            //bcc = mR.getParameter(key);
	            //}
	            
	            //if(key.equals("subject")) {
	            subject = "Travel Notification";   
	            //}
	            
	            //if(key.equals("msg")) {
	            body = "You have got a jounrny .......   cost of this is...........";   
	            //}	        
	        //} 
		       
                // Get system properties
                Properties props = System.getProperties();
                
                // Set up the mail server
                props.put("mail.smtp.host", mailserver);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.starttls.enable", "true");
                
                Authenticator auth=new SMTPAuthenticator(ln,pw);
                
                // Get the email session
                //Session session = Session.getDefaultInstance(props, auth);
                
                Session session = Session.getInstance(props,auth);
                
                // Define the message
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                
                InternetAddress ia[] = new InternetAddress[2];
                ia[0] = new InternetAddress(travellerid);
                ia[1] = new InternetAddress(did);
                
                message.addRecipients(Message.RecipientType.TO, ia);
                
                //if(cc !=null && cc.length() != 0) {
                    //message.addRecipient(Message.RecipientType.CC, 
                    //new InternetAddress(cc));
                //}
                
                //if(bcc !=null && bcc.length() != 0) {
                   //message.addRecipient(Message.RecipientType.BCC, 
                   //new InternetAddress(bcc));
                //}
                message.setSubject(subject);
                
                // Create the message part 
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(body + fare+"rupees and your travelid is"+travelid);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                
                //Attached files
            /*    Enumeration files = mR.getFileNames();
                while(files.hasMoreElements()) 
                {
                    String name = (String)files.nextElement();
                    filename = mR.getFilesystemName(name);
                    String type = mR.getContentType(name);
                    File file = mR.getFile(name);
                    if(file != null) {    
                        String attachment = dir.getAbsolutePath()+"\\"+filename;
                        messageBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(attachment);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(filename);
                        multipart.addBodyPart(messageBodyPart);
                    }
                } */
                
                message.setContent(multipart);                 
                message.setSentDate(new Date());
                Transport.send(message);
                out.println("************Message Sent!************\n\n");
                
                Enumeration headerLines = message.getAllHeaderLines(); 
                while(headerLines.hasMoreElements()) {
                    out.println((String)headerLines.nextElement());
                }
                out.println("Message: " + body +""+fare+"rupees and your travelid is"+travelid);
            }	
            catch(Exception ex)
            {
                out.print(ex.toString());
                ex.printStackTrace();
            }
        }
        //else
        //{
        //    out.println("Bad password, go back and try again!");
        //}
	 
	
	private class SMTPAuthenticator extends javax.mail.Authenticator 
	{
		 //public PasswordAuthentication getPasswordAuthentication()
		 //{
		 //		String user="";
		 //		String pwd= "";
		 //		return new PasswordAuthentication(user,pwd);	
		 //}
			
			private PasswordAuthentication authentication;

	        public SMTPAuthenticator(String login, String password) {
	            authentication = new PasswordAuthentication(login, password);
	        }

	        protected PasswordAuthentication getPasswordAuthentication() {
	            return authentication;
	        }
	                

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			}

	}


