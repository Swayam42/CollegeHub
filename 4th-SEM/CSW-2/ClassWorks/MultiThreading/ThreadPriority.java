package MultiThreading;

public class ThreadPriority extends Thread{
	public void run() {
		try {
			 System.out.println(Thread.currentThread().getName()+" is running");
			 System.out.println(this.currentThread().getPriority()); //getPriority()-> returns the priority no.
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ThreadPriority ob=new ThreadPriority();
		ob.setName("Sindoor"); //Naming the Thread
		ob.setPriority(Thread.MIN_PRIORITY);
		ob.start();
		
		
	}

}
