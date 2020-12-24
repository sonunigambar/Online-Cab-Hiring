package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import traveller.driver;
import traveller.traveller;

/**
 * Servlet implementation class Forgotpwd
 */
@WebServlet("/Forgotpwddriver")
public class Forgotpwddriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static final String mailserver = "smtp.gmail.com";
    private static final String correctPassword = "xxx";
    private String from, to, password, filename;
    private String ln, bcc, subject, body,pwd; 
    public Forgotpwddriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		//String othermail="rasmitabadhei15@gmail.com";
		PrintWriter pw=response.getWriter();
		driver d=new driver();
		d.setDid(email);
		String forgotpassword=d.driverforgotpassword();
		//pw.print(forgotpassword);
		pw.print("<body bgcolor='pink'>");
		
		
	try
		{

		response.setContentType("text/plain");	
        
	            	to = email;
	            	System.out.println(to);	            
	   
	            	ln="cabhiring10@gmail.com";
	            	from="cabhiring10@gmail.com";
	        
	            	pwd="327aa011";
	
	            subject = "password Notification";   
	            //}
	            
	            //if(key.equals("msg")) {
	            body = "You have got a password";   
	            //}	        
	        //} 
		       
                // Get system properties
               Properties props = System.getProperties();
                
                // Set up the mail server
                props.put("mail.smtp.host", mailserver);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.starttls.enable", "true");
                
                Authenticator auth=new SMTPAuthenticator(ln,pwd);
                
                // Get the email session
                //Session session = Session.getDefaultInstance(props, auth);
                
                Session session = Session.getInstance(props,auth);
                
                // Define the message
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
               
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                
              
                message.setSubject(subject);
                
                // Create the message part 
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(body +""+forgotpassword);
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
                pw.println("************Message Sent!************\n\n");
                
                Enumeration headerLines = message.getAllHeaderLines(); 
                while(headerLines.hasMoreElements()) {
                    pw.println((String)headerLines.nextElement());
                }
                pw.println("Message: " + body +""+forgotpassword);
            }	
            catch(Exception ex)
            {
                pw.print(ex.toString());
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
