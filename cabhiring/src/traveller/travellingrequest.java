package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class travellingrequest {
	String source,destination,date,time,travelid,travellerid,tstatus;

	public String getTravellerid() {
		return travellerid;
	}

	public void setTravellerid(String travellerid) {
		this.travellerid = travellerid;
	}

	public String getTravelid() {
		return travelid;
	}

	public void setTravelid(String travelid) {
		this.travelid = travelid;
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



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}
	
	
	public int travelrequestinsert()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
				
		try 
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			PreparedStatement ps=conn.prepareStatement("SELECT travelid FROM travellingrequest ORDER BY travelid DESC");
			ResultSet rs=ps.executeQuery();
			
			
			String e;
			String en="";
			
			if(rs.next())
			{
			e=rs.getString(1).substring(1);
			int n = Integer.parseInt(e);
			n++;			

			if(n<10)
			  en="E"+"0000"+n;

			if(n>=10 && n<100 )
			  en="E"+"000"+n;

			if(n>=100 && n<1000 )
			  en="E"+"00"+n;

			if(n>=1000 && n<10000 )
			  en="E"+"0"+n;

			if(n>=10000 && n<100000 )
			  en="E"+ n;
			}
			else
				en="E00001";
			
			System.out.println(en);
		
			ps = conn.prepareStatement("insert into travellingrequest(source,destination,date,time,travelid,tid) values(?,?,?,?,?,?)");
			
			ps.setString(1, source);
			ps.setString(2, destination);
			ps.setString(3, date);
			ps.setString(4, time);
			ps.setString(5, en);
			ps.setString(6, travellerid);
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
	
	public ArrayList getdetails()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		try
		{
			PreparedStatement ps=con.prepareStatement("select travelid,source,destination,date,time,tid from travellingrequest where travelid not in(select travelid from assigndriver)");
			ResultSet rs=ps.executeQuery();
			
			ArrayList ar=new ArrayList();
			
			while(rs.next())
			{
				travellingrequest tr=new travellingrequest();
				tr.setTravelid(rs.getString("travelid"));
				tr.setSource(rs.getString("source"));
				tr.setDestination(rs.getString("destination"));
				tr.setDate(rs.getString("date"));
				tr.setTime(rs.getString("time"));
				tr.setTravellerid(rs.getString("tid"));
				
				ar.add(tr);
			}
			return ar;
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}
	}
	
	
	public  String gettime()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select date from travellingrequest");
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()==true)
			{
				String date=rs.getString("date");
				return date;
			}
			return date;
		
	}
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}
	}
	
	public travellingrequest tstatus()
	{
		Connection con=dbconnection();
		if(con==null)
			return null;
		try {
			
			PreparedStatement ps=con.prepareStatement("select source,destination,date,time from travellingrequest where travelid=?");
			ps.setString(1, travelid);
			
			//ArrayList ar=new ArrayList();
			ResultSet rs=ps.executeQuery();
			rs.next();
			travellingrequest tr=new travellingrequest();
			
			tr.setSource(rs.getString("source"));
			tr.setDestination(rs.getString("destination"));
			tr.setDate(rs.getString("date"));
			tr.setTime(rs.getString("time"));
			//ar.add(tr);
			
			return tr;
			
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
		}
	}

	public String assigneddriverfortraveller()
	{
	
		try {
			Connection con=dbconnection();
			if(con==null)
				return "null";
			PreparedStatement ps=con.prepareStatement("select did from assigneddriver where travelid=?");
			ps.setString(1, travelid);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true)
			{
				
				String did=rs.getString("did");
				return did;
			
				
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
	
	

