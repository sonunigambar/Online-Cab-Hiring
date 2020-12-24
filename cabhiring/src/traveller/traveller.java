package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class traveller 
{
	String uname,email,phno,adr,gender,pwd;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public int insert()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			PreparedStatement ps=conn.prepareStatement("select email from traveller");
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				if(email.equals(rs.getString("email")))
				{
					i=1;
					break;
				}
			}
			if(i==1)
			{
				return -1;
			}
			ps=conn.prepareStatement("insert into traveller(username,email,phno,address,gender,password)values(?,?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, phno);
			ps.setString(4, adr);
			ps.setString(5, gender);
			ps.setString(6, pwd);
			ps.executeUpdate();
			
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		}
	
	public Connection dbconnection()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			return conn;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String login()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select email from traveller where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String travellerid=rs.getString("email");
				return travellerid;
			
				
			}
			else
			{
				return "invalid";
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public traveller edit()
	{
		Connection con=dbconnection();
		if(con==null)
			return null;
		try {
			
			PreparedStatement ps=con.prepareStatement("select address,phno,password from traveller where email=?");
			ps.setString(1, email);
			
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			traveller t=new traveller();
			t.setAdr(rs.getString("address"));
			t.setPhno(rs.getString("phno"));
			t.setPwd(rs.getString("password"));
			return t;
			
	}catch(Exception t)
	{
		t.printStackTrace();
		return null;
		}
	}
	
	public int update()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		
		try 
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			PreparedStatement ps=conn.prepareStatement("update traveller set address=?,phno=?,password=? where email=?");
			
			ps.setString(4,email );
			ps.setString(1, adr);
			ps.setString(2, phno);
			ps.setString(3,pwd );
			ps.executeUpdate();
			
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}	

	}
	
	public String gettravelleremail()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select email from traveller");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String travelleremail=rs.getString("email");
				return travelleremail;
			
				
			}
			else
			{
				return "invalid";
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String travellerforgotpassword()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select password from traveller where email=?");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String n=rs.getString("password");
				return n;
			
				
			}
			else
			{
				return "invalid";
			}
			
			
		} 
			 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "null";
		}
		
	}


	public String gettravellerpno()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select phno from traveller where email=?");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String phoneno=rs.getString("phno");
				return phoneno;
			
				
			}
			else
			{
				return "invalid";
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
		

}
