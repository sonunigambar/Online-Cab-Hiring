package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class paymentinfo {
 String travelid,pstatus;
 public String getPstatus() {
	return pstatus;
}
public void setPstatus(String pstatus) {
	this.pstatus = pstatus;
}

int amount;
 
 
public String getTravelid() {
	return travelid;
}
public void setTravelid(String travelid) {
	this.travelid = travelid;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}


public int inserttopaymentinfo()
{
	String dbURL = "jdbc:db2://localhost:50000/xyz"; 
	String dbUser = "sonu" ;
	String dbPasswd = "sonu1234" ;
	
	try {
		Class.forName("com.ibm.db2.jcc.DB2Driver"); 
		
		Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
		PreparedStatement ps=conn.prepareStatement("insert into paymentinfo(travelid,amount,PSTATUS) values(?,?,?)");
		
		ps.setString(1, travelid);
		ps.setInt(2, amount);
		ps.setString(3, this.pstatus);
		
		
		ps.executeUpdate();
		
		return 1;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return 0;
	}
}

public int updatepaymentinfo()
{
	String dbURL = "jdbc:db2://localhost:50000/xyz"; 
	String dbUser = "sonu" ;
	String dbPasswd = "sonu1234" ;
	
	try 
	{
		Class.forName("com.ibm.db2.jcc.DB2Driver"); 
		
		Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
		PreparedStatement ps = conn.prepareStatement("update paymentinfo set pstatus=? where travelid=?");
		System.out.println(this.travelid);
		System.out.println(this.pstatus);
		ps.setString(2, travelid);
		ps.setString(1, pstatus);
		
		
		ps.executeUpdate();
		
		return 1;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return 0;
	}
}

public  int getamount()
{
	String dbURL = "jdbc:db2://localhost:50000/xyz"; 
	String dbUser = "sonu" ;
	String dbPasswd = "sonu1234" ;
	
	try {
		Class.forName("com.ibm.db2.jcc.DB2Driver"); 
		
		Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;

		PreparedStatement ps=conn.prepareStatement("select amount from paymentinfo where travelid=?");
		
		ps.setString(1,travelid);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next()==true)
		{
			int amount=rs.getInt("amount");
			return amount;
		}
		return 1;
	
}
	catch(Exception e)
	{
			e.printStackTrace();
			return -1;
	}
}

}
