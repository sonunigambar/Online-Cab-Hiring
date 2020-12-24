package traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class rate 
{
	String source,destination,travelid;
	String distance,cost_per_km;
	int amount;
	
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	String cardno,pin,expmonth,expyear,cardholdername;
	int balance;
	
	
	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getExpmonth() {
		return expmonth;
	}


	public void setExpmonth(String expmonth) {
		this.expmonth = expmonth;
	}


	public String getExpyear() {
		return expyear;
	}


	public void setExpyear(String expyear) {
		this.expyear = expyear;
	}


	public String getCardholdername() {
		return cardholdername;
	}


	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		this.distance = distance;
	}


	public String getCost_per_km() {
		return cost_per_km;
	}


	public void setCost_per_km(String cost_per_km) {
		this.cost_per_km = cost_per_km;
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


	public int getfare()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 	
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
						
			 
			 PreparedStatement ps1=conn.prepareStatement("select distance,cost_per_km from rate where source=?and destination=?");
		
			 	ps1.setString(1,source);
				ps1.setString(2,destination);
			    
				ResultSet rs1= ps1.executeQuery();
				
				rs1.next();
								
				return rs1.getInt("distance") * rs1.getInt("cost_per_km");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		}
	
	
	
	
	
	
	public int chkcarddt()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;

		try 
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			PreparedStatement ps=conn.prepareStatement("select balance from carddetails where cardno=? and pin=? and cardholdername=? and expmonth=? and expyear=? ");
			ps.setString(1, this.cardno);
			ps.setString(2, this.pin);
			ps.setString(3, this.cardholdername);
			ps.setString(4, this.expmonth);
			ps.setString(5, this.expyear);
									
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	
				int b = rs.getInt("balance");
				return b;			
			}
			else
				return -1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return -2;	
		}
	}
	
	
	public int updatebalance()
	{
		String dbURL = "jdbc:db2://localhost:50000/xyz"; 
		String dbUser = "sonu" ;
		String dbPasswd = "sonu1234" ;

		try 
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver"); 
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPasswd ) ;
			
			PreparedStatement ps=conn.prepareStatement("update carddetails set balance=? where cardno=? ");
			ps.setString(2, this.cardno);
			ps.setInt(1, this.balance);
			
			int r = ps.executeUpdate();
			
			return r;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;	
		}
	}
	
	
	
}
