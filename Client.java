package com.accolite.au;

interface Access
{
	void getAccess();
}

class AccessImplement implements Access
{
	public void getAccess()
	{
		System.out.println("Access Granted\n");
	}
}

class AccessImplementProxy
{
	boolean isAdmin;
	private AccessImplement accessObj;
	
	AccessImplementProxy(boolean value)
	{
		accessObj = new AccessImplement();
		isAdmin = value;
	}
	
	void run()
	{
		if(isAdmin)
		{
			accessObj.getAccess();
		}
		else
		{
			System.out.println("Access Denied\n");
		}
	}
}

public class Client {
	public static void main(String args[])
	{
		AccessImplementProxy object=new AccessImplementProxy(true);
		object.run();
		AccessImplementProxy object1=new AccessImplementProxy(false);
		object1.run();
	}
}
