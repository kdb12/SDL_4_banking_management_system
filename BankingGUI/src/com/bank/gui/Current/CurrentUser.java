package com.bank.gui.Current;

public class CurrentUser 
{
	static String bankname,id,password,accno;

	public static String getBankname()
	{
		return bankname;
	}

	public static String getId() 
	{
		return id;
	}

	public static String getPassword()
	{
		return password;
	}

	public static String getAccno() {
		return accno;
	}

	public static void setAccno(String accno) {
		CurrentUser.accno = accno;
	}

	public static void setBankname(String bankname) 
	{
		CurrentUser.bankname = bankname;
	}

	public static void setId(String id)
	{
		CurrentUser.id = id;
	}

	public static void setPassword(String password) 
	{
		CurrentUser.password = password;
	}
	
	
	
	

}
