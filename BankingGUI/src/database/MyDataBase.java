package database;

import java.sql.*;

import javax.swing.JOptionPane;

public class MyDataBase 
{
	static Connection conn=null;
	
	
	public static Connection getConn() 
	{
		return conn;
	}
	
	
	public static void setConn(Connection conn) 
	{
		MyDataBase.conn = conn;
	}
	
	
	public static void doConnection()
	{
		System.out.println("");
		
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "Krishna@sql");
		MyDataBase.setConn(con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("");
	}
	
	
	public static void addBank(String bankName,int bankId,String bankAddress,String bankPassword)
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
			PreparedStatement ps=con.prepareStatement("insert into banks values(?,?,?,?)");
			ps.setString(1, bankName);
			ps.setInt(2, bankId);
			ps.setString(3, bankAddress);
			ps.setString(4, bankPassword);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "BANK ADDED SUCCESSFULLY");
		}
		catch(Exception e)
		{
			System.out.println(e);
			return;
		}
		
		System.out.println("");
	}
	
	public static void addUser(String name,String id,String password,double contact,String acc,double mny,String bankName)
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
            PreparedStatement ps;           
            ps = con.prepareStatement("INSERT INTO accountholders VALUES(?,?,?,?,?,?,?)");            
            ps.setString(1, name);            
            ps.setString(2, id);            
            ps.setString(7, password);            
            ps.setDouble(4, contact);            
            ps.setString(3, acc);            
            ps.setDouble(5, mny);          
            ps.setString(6, bankName);                    
            ps.executeUpdate();       
            ps=con.prepareStatement("INSERT INTO transactions VALUES(?,?,?,?,now(),?,'INITIAL DEPOSIT')");
            ps.setString(1, acc);
            ps.setString(2, acc);
            ps.setString(3, bankName);
            ps.setString(4, bankName);
            ps.setDouble(5, mny);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "USER HAS BEEN ADDED SUCCESSFULLY");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return;
		}	
		
		System.out.println("");
	}
	
	public static void addTransactions(String string, String string0, String BN, String BN0, double mny,String Type)
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
            PreparedStatement ps=con.prepareStatement("insert into transactions values(?,?,?,?,now(),?,?)");
            ps.setString(1, string);
            ps.setString(2, string0);
            ps.setString(3, BN);
            ps.setString(4, BN0);
            ps.setDouble(5, mny);
            ps.setString(6, Type);
            ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("");
	}
	
	public static void addRequests(String req,String cname,double contact,String id,String Myb,double cbalance)
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
            PreparedStatement pst=con.prepareStatement("insert into requests values(?,?,?,?,?,?)");
            pst.setString(1, "TO CHANGE PHONE NUMBER");
            pst.setString(2, cname);
            pst.setDouble(3, contact);
            pst.setString(4, id);
            pst.setString(5, Myb);
            pst.setDouble(6, cbalance);
            pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		
		System.out.println("");
	}
	
	public static void addNotifications(String notify,String id,String bankname)
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
			PreparedStatement ps=con.prepareStatement("insert into notifications values(?,?,?,now())");
			ps.setString(1, notify);
			ps.setString(2, id);
			ps.setString(3, bankname);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		
		System.out.println("");
	}
	
	public static void removeRequests(String BankName) 
	{
		System.out.println("");
		
		try
		{
			Connection con = MyDataBase.getConn();
			con.createStatement().executeUpdate("delete from requests where bname='"+BankName+"'");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		
		System.out.println("");		
	}
	
    public static void updateBalance(String accno, double balance, String BN) 
    {
        try 
        {
            Connection con = MyDataBase.getConn();
			PreparedStatement ps=con.prepareStatement("update accountholders set ubalance=? where uaccno=? and bname=?");
            ps.setDouble(1, balance);
            ps.setString(2, accno);
            ps.setString(3, BN);
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
        	System.out.println(e);
        }
    }
    
   


	public static boolean checkAdmin(int bid, String bpass)
	{
		boolean isAdmin=false;
		Statement st;
		try {
			st = MyDataBase.getConn().createStatement();
			ResultSet rs=st.executeQuery("select bid,bpass,bname from banks where bid='"+bid+"' and bpass='"+bpass+"'");
			if(rs.next())
			{
				isAdmin=true;
			}
			else
			{
				isAdmin=false;
			}
			rs.close();
	        st.close();
	        
		} 
		catch (SQLException e) 
		{
			
			JOptionPane.showMessageDialog(null, e);
		}
		
		return isAdmin;
	}


	public static boolean checkUser(String bankname, String id, String password) {
		boolean isUser=false;
		try
		{
			Statement st=MyDataBase.getConn().createStatement();
			String query="select bname,uid,upassword from accountholders where bname='"+bankname+"' and uid='"+id+"' and upassword='"+password+"'";
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				isUser=true;
			}
			else
			{
				isUser=false;
			}
			rs.close();
	        st.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return isUser;
	}
    
//    public static void updatePhoneAndName(User ra)
//    {
//    	try
//    	{
//    		Connection con=MyDataBase.getConn();
//    		PreparedStatement ps=con.prepareStatement("update accountholders set uname=?, uphone=? where uid=? and bname=?");
//    		ps.setString(1, ra.name);
//    		ps.setDouble(2, ra.phoneNo);
//    		ps.setString(3, ra.upiId);
//    		ps.setString(4, ra.bankName);
//    		ps.executeUpdate();
//    	}
//    	catch(Exception e)
//    	{
//    		System.out.println(e);
//    	}
//    }
}
