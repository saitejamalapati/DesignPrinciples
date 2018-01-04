package com.accolite.au;

class Singleton {
	String name;
	private static volatile Singleton SingletonObject;
	
	private Singleton()
	{
		name="Sample Singleton";
	}
	
	public static Singleton getObject() 
	  {
	    if(SingletonObject == null)
	    {
	    	synchronized(Singleton.class)
	    	{
	    		if(SingletonObject == null)
	    			SingletonObject = new Singleton();
	    	}
	    }
	    return SingletonObject;
	  }
}

public class UseSingleton extends Thread
{
	String nameAssign;
	static int counter=1;
	
	static void printObject()
	{
		Singleton s=Singleton.getObject();
		System.out.println(s.name);
	}
	
	public static void main(String args[])
	{
		UseSingleton u = new UseSingleton();
		u.printObject();

		for(int i=0;i<10;i++)
		{
			Thread t=new Thread(u);
			t.start();
		}
	}
	public void run()
	{
		Singleton s = Singleton.getObject();
		System.out.println(s.name);
		counter++;
		s.name+=counter;
		
	}
}
