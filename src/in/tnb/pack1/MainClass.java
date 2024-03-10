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


public class MainClass {
	public static void main(String[] args) {
		 Mythread t1=new Mythread("t1");
		 Mythread t2=new Mythread("t2");
		  Thread th1=new Thread(t1);
		  Thread th2=new Thread(t2);
		  Mythread2 t3=new Mythread2("t3");
		  th1.start();
		  th2.start();
		  System.out.println("Main thread about to middle");
		  t3.start();
		  System.out.println("Main thread at the end");
		
		
	}

}
