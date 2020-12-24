package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class travellerrequest 
{
	
	String source,destination,date,time,travelid,travellerid,pstatus;
	
	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
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

	public String getTravelid() {
		return travelid;
	}

	public void setTravelid(String travelid) {
		this.travelid = travelid;
	}

	public String getTravellerid() {
		return travellerid;
	}

	public void setTravellerid(String travellerid) {
		this.travellerid = travellerid;
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
	
	public ArrayList myallrequest()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select travellingrequest.travelid,source,destination,date,time,pstatus from travellingrequest left outer join paymentinfo on paymentinfo.travelid=travellingrequest.travelid  where travellingrequest.tid=?");
			ps.setString(1, travellerid);
			
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList ar=new ArrayList();
			while(rs.next())
			{
				travellerrequest tr=new travellerrequest();
				tr.setTravelid(rs.getString("travelid"));
				tr.setSource(rs.getString("source"));
				tr.setDestination(rs.getString("destination"));
				tr.setDate(rs.getString("date"));
				tr.setTime(rs.getString("time"));
				tr.setPstatus(rs.getString("pstatus"));	
				
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
	
	
	

	public  String getstatus()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select pstatus from paymentinfo,travellingrequest where travelid=tid");
			ps.setString(1, travelid);
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()==true)
			{
				String pstatus=rs.getString("pstatus");
				return pstatus;
			}
			return pstatus;
		
	}
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}
	}
	
}
