package com.bank.gui.Current;

public class CurrentAdmin 
{
	static int id;
	static String password;
	static String Bankname;
	static String Bankaddress;
	
	public static void setBankname(String bankname) {
		Bankname = bankname;
	}
	public static int getId() 
	{
		return id;
	}
	public static String getPassword() 
	{
		return password;
	}
	public static void setId(int id) 
	{
		CurrentAdmin.id = id;
	}
	public static void setPassword(String password) 
	{
		CurrentAdmin.password = password;
	}
	public static String getBankname() {
		return Bankname;
	}
	public static String getBankaddress() {
		return Bankaddress;
	}
	public static void setBankaddress(String bankaddress) {
		Bankaddress = bankaddress;
	}
	
}
