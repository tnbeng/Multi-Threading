package in.tnb.pack1;

class Consumer extends Thread
{
	Producer_Consumer_Company c;
	
	public Consumer(Producer_Consumer_Company c) {
		this.c=c;
	}
	@Override
	public void run() {
	    while(true)
	    {
	    	this.c.consumeItem();
//	    	try {
//	    		Thread.sleep(1000);
//	    	}
//	    	catch(Exception e)
//	    	{
//	    		e.printStackTrace();
//	    	}
	    }
	}
}

class Producer extends Thread
{
	Producer_Consumer_Company c;
	
	public Producer(Producer_Consumer_Company c) {
		this.c=c;
	}
	@Override
	public void run() {
		int i=1;
	    while(true)
	    {
	    	this.c.porduceItem(i);
	    	try {
	    		Thread.sleep(1000);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	i++;
	    }
	}
}



public class Producer_Consumer_Company {
	
	int item;
	
	boolean status=true;
	
	//true for producer 
	//false for consumer
	
	synchronized void porduceItem(int n) 
	{
		if(!status)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		item=n;
		System.out.println("Item Produced: "+item);
		status=false;
		notify();
	}
	
	synchronized int consumeItem()
	{
		if(status)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Item consumed: "+ item);
		status=true;
		notify();
		return item;
		
	}
	
	
	public static void main(String[] args) {
		Producer_Consumer_Company company=new Producer_Consumer_Company();
		
		Producer p=new Producer(company);
		Consumer c=new Consumer(company);
		
		p.start();
		c.start();
	}
	

}
