package in.tnb.pack1;

//creating thread using runnable interface
class Mythread implements Runnable
{  
   String objname;
   Mythread(String name)
   {
	   this.objname=name;
   }
	@Override
	public void run() {
		for(int i=0;i<9;i++)
		{
			System.out.println(objname+"->"+i);
			try {
				Thread.sleep(200);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

//creating thread using extends Thread class
class Mythread2 extends Thread
{
	   String objname;
	   Mythread2(String name)
	   {
		   this.objname=name;
	   }
	@Override
	public void run() {
		for(int i=0;i<9;i++)
		{
			System.out.println(objname+"->"+i);
//			try {
//				Thread.sleep(200);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
		}
	}
}


public class MainClass {
	public static void main(String[] args) {
		System.out.println("Main thread started....");
		 Mythread t1=new Mythread("t1");
		 Mythread t2=new Mythread("t2");
		  Thread th1=new Thread(t1);
		  Thread th2=new Thread(t2);
		  Mythread2 t3=new Mythread2("t3");
		  th1.start();
		  Thread t=Thread.currentThread();
		  t.setName("Tnb Thrad");
		  try
		  {
			  t.sleep(5000);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  th2.start();
		  System.out.println("Main thread about to middle");
		  t3.start();
		  System.out.println("Main thread at the end");
		
		  System.out.println(th1.getName());
		  System.out.println(th2.getName());
		  System.out.println("Current thread: "+t.getName());
		  System.out.println("main id: "+t.getId());
		  System.out.println("th1 id: "+th1.getId());
		  System.out.println("th2 id : "+th2.getId());
		  
		  
		 
		  
		  
		
	}

}
