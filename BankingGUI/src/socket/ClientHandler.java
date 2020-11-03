package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import database.MyDataBase;





public class ClientHandler extends Thread {

	Socket s;
    ObjectInputStream cin;
    ObjectOutputStream cout;
    DataOutputStream dout;
    DataInputStream din;
    
    
	public ClientHandler(Socket s) 
	{
		this.s = s;
        try 
        {
            cout=new ObjectOutputStream(s.getOutputStream());
            dout=new DataOutputStream(s.getOutputStream());
            din=new DataInputStream(s.getInputStream());
            cin=new ObjectInputStream(s.getInputStream());
            
        } 
        catch (Exception e) 
        {JOptionPane.showMessageDialog(null, e);}
       
	}


	@Override
	public void run() 
	{
		System.out.println(this.getName()+"   ");
		
		try
		{
			  boolean end=false;
			  while(!end)
			  {
				  int choice=din.readInt();
				  
				  if(choice==1)
				  {
					  System.out.println("in admin login");
					  HashMap<String,String> map=(HashMap<String, String>) cin.readObject();
					  try {
					  int id=Integer.parseInt(map.get("ID"));
					  String password=map.get("PASSWORD");
					  System.out.println(map);
					  boolean isAdmin=MyDataBase.checkAdmin(id,password);
					  if(isAdmin)
					  {
						  dout.writeInt(1);
					  }
					  else
					  {
						  dout.writeInt(2);
					  }
					  }
					  catch(Exception e)
					  {
						  JOptionPane.showMessageDialog(null, e);
						  dout.writeInt(2);
					  }
					  
				  }
				  else if(choice==2)
				  {
					  System.out.println("in user login");
					  HashMap<String,String> map=(HashMap<String, String>) cin.readObject();
					  try
					  {
					  String id=map.get("ID");
					  String password=map.get("PASSWORD");
					  String bankname=map.get("BANKNAME");
					  System.out.println(map);
					  boolean isUser=MyDataBase.checkUser(bankname,id,password);
					  if(isUser)
					  {
						  dout.writeInt(1);
					  }
					  else
					  {
						  dout.writeInt(2);
					  }
					  }
					  catch(Exception e)
					  {
						  JOptionPane.showMessageDialog(null, e);
						  dout.writeInt(2);
					  }
				  }
				  else if(choice==3)
				  {
					  System.out.println("ended");
					  end=true;
					  s.close();
				  }
				  else if(choice==0)
				  {
					  System.out.println("in adding bank");
					  HashMap<String,String> map=(HashMap<String, String>) cin.readObject();
					  try {
					  String name=map.get("NAME");
					  int id=Integer.parseInt(map.get("ID"));
					  String add=map.get("ADDRESS");
					  String pass=map.get("PASSWORD");
					  System.out.println(map);
					  MyDataBase.addBank(name, id, add, pass);
					  
					  }
					  catch(Exception e)
					  {
						  JOptionPane.showMessageDialog(null, "ID CAN NOT BE STRING");
					  }
				  }
			  }
		}
		catch (Exception e) 
        {JOptionPane.showMessageDialog(null, e);}
		
	}


	

	

}
