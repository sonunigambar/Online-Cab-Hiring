package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class driver
{
	String name,email,phno,password;
	String date,time;
	String did,travelid;
	String source,destination;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getTravelid() {
		return travelid;
	}

	public void setTravelid(String travelid) {
		this.travelid = travelid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public int insert()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 	
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
						
			PreparedStatement Ps = conn.prepareStatement("select dmail from driver");
	    	
	    	ResultSet rs = Ps.executeQuery();
	    	
	    	int f=0;
	    	while(rs.next())
	    	{
	    		if(this.email.equals(rs.getString("dmail")))
	    		{
	    			f=1;
	    			break;
	    		}
	    	}
	    	
	    	if(f==1)
	    	{
	    		return -1;
	    	}	 
			 PreparedStatement ps=conn.prepareStatement("insert into driver(dname,dmail,dphno,dpassword) values(?,?,?,?)");
		
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phno);
			ps.setString(4, password);
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
		
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/xyz", "sonu", "sonu1234" ) ;
			return conn;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public String getdriveremail()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select did from driver");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String driveremail=rs.getString("did");
				return driveremail;
			
				
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
	
	public ArrayList getavailabledrivers()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select dmail from driver where dmail not in(select did from assigndriver where travelid in (select travelid from travellingrequest where date=?))");
			ps.setString(1,this.date);
			
			ResultSet rs=ps.executeQuery();
			
			ArrayList ar=new ArrayList();
			
			while(rs.next())
			{
				ar.add(rs.getString("dmail"));
			}
			return ar;
		
	}
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}
	}
	
	
	
	public int insertasigndriver()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 	
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
						
			 
			 PreparedStatement ps=conn.prepareStatement("insert into assigndriver(travelid,did) values(?,?)");
		
			ps.setString(1, travelid);
			ps.setString(2, did);

			ps.executeUpdate();
			
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		}
	
	
	
	
	public String dlogin()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select dname from driver where dmail=? and dpassword=?");
			ps.setString(1, did);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String n=rs.getString("dname");
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
	
	


/*public driver driverstatus()
	{
		Connection con=dbconnection();
		if(con==null)
			return null;
		try {
			
			PreparedStatement ps=con.prepareStatement("select travellingrequest.travelid,source,destination,date,time,travellingrequest.tid,assigndriver.did from travellingrequest,assigndriver where travellingrequest.travelid=assigndriver.travelid and assigndriver.did=?");
			ps.setString(1, did);
			
			//ArrayList ar=new ArrayList();
			ResultSet rs=ps.executeQuery();
			rs.next();
			driver dr=new driver();
			dr.setTravelid(rs.getString("travelid"));
			dr.setSource(rs.getString("source"));
			dr.setDestination(rs.getString("destination"));
			dr.setDate(rs.getString("date"));
			dr.setTime(rs.getString("time"));
			dr.setEmail(rs.getString("tid"));
			dr.setDid(rs.getString("did"));
			//ar.add(tr);
			
			return dr;
			
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
		}
	}*/
	
	
	
	public ArrayList driverstatus()
	{
		Connection con=dbconnection();
		if(con==null)
			return null;
		try {
			
			PreparedStatement ps=con.prepareStatement("select travellingrequest.travelid,source,destination,date,time,travellingrequest.tid,assigndriver.did from travellingrequest,assigndriver where travellingrequest.travelid=assigndriver.travelid and assigndriver.did=?");
			ps.setString(1, did);
			
			ArrayList ar=new ArrayList();
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				driver dr=new driver();
				dr.setTravelid(rs.getString("travelid"));
				dr.setSource(rs.getString("source"));
				dr.setDestination(rs.getString("destination"));
				dr.setDate(rs.getString("date"));
				dr.setTime(rs.getString("time"));
				dr.setEmail(rs.getString("tid"));
				dr.setDid(rs.getString("did"));
				ar.add(dr);
			}
			
			return ar;
			
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
		}
	}


	public String driverforgotpassword()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select dpassword from driver where dmail=?");
			ps.setString(1, did);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String dpassword=rs.getString("dpassword");
				return dpassword;
			
				
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


	public driver getpnodid()
	{
		Connection con=dbconnection();
		if(con==null)
			return null;
		try {
			
			PreparedStatement ps=con.prepareStatement("select driver.dphno,assigndriver.did from driver,assigndriver where assigndriver.did=driver.dmail and assigndriver.did=(select did from assigndriver where travelid=?)");

			ps.setString(1, travelid);
			
			//ArrayList ar=new ArrayList();
			ResultSet rs=ps.executeQuery();
			rs.next();
			driver dr=new driver();
			dr.setPhno(rs.getString("dphno"));
			dr.setDid(rs.getString("did"));
		
			return dr;
			
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
		}
	}



	
}
