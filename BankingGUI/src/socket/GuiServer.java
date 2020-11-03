package socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import database.MyDataBase;



public class GuiServer {

	public static void main(String[] args) 
	{
		ExecutorService ES=Executors.newFixedThreadPool(5);
        System.out.println("SERVER ");
        ServerSocket ss;
        try 
        { 
        	MyDataBase.doConnection();
           ss=new ServerSocket(5812);
           Socket s;
           while(true)
           {
        	   System.out.println("SERVER IS WAITING FOR THE CONNECTION");
               s = ss.accept();
               System.out.println("connected with "+s);
               ES.execute(new ClientHandler(s));                        
           }
        }
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog(null, e);
        }

	}

}
