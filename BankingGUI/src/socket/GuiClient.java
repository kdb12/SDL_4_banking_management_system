package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class GuiClient 
{
	
	static Socket s;
	static ObjectInputStream cin;
	static ObjectOutputStream cout;
	static DataOutputStream dout;
	static DataInputStream din;
    
    
	public static Socket getS() {
		return s;
	}


	public static ObjectInputStream getCin() {
		return cin;
	}


	public static ObjectOutputStream getCout() {
		return cout;
	}


	public static DataOutputStream getDout() {
		return dout;
	}


	public static DataInputStream getDin() {
		return din;
	}


	public static void setS(Socket s) {
		try 
		{
		GuiClient.s = s;
		GuiClient.setDout(new DataOutputStream(s.getOutputStream()));
		GuiClient.setCout(new ObjectOutputStream(s.getOutputStream()));
        GuiClient.setDin(new DataInputStream(s.getInputStream()));
        GuiClient.setCin(new ObjectInputStream(s.getInputStream()));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}


	public static void setCin(ObjectInputStream cin) {
		GuiClient.cin = cin;
	}


	public static void setCout(ObjectOutputStream cout) {
		GuiClient.cout = cout;
	}


	public static void setDout(DataOutputStream dout) {
		GuiClient.dout = dout;
	}


	public static void setDin(DataInputStream din) {
		GuiClient.din = din;
	}


	

}
