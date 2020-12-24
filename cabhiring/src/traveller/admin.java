package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class admin {
	
	String travelid,tid,source,destination,date,time,did,pstatus;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
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
	
	
	public ArrayList getalldetails()
	{
		Connection con=dbconnection();
		
		if(con==null)
			return null;
		try
		{
			PreparedStatement ps=con.prepareStatement("select travellingrequest.travelid,tid,source,destination,date,time,assigndriver.did,paymentinfo.pstatus from travellingrequest join assigndriver on travellingrequest.travelid=assigndriver.travelid join paymentinfo on travellingrequest.travelid=paymentinfo.travelid");
			ResultSet rs=ps.executeQuery();
			
			ArrayList ar=new ArrayList();
			
			while(rs.next())
			{
				admin ad=new admin();
				ad.setTravelid(rs.getString("travelid"));
				ad.setTid(rs.getString("tid"));
				ad.setSource(rs.getString("source"));
				ad.setDestination(rs.getString("destination"));
				ad.setDate(rs.getString("date"));
				ad.setTime(rs.getString("time"));
				ad.setDid(rs.getString("did"));
				ad.setPstatus(rs.getString("pstatus"));
				
				ar.add(ad);
			}
			return ar;
		}
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}
	}
	
	

}
