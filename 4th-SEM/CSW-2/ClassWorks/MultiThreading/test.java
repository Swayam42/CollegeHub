package MultiThreading;
/*The program demonstrates basic multithreading by creating multiple threads and running them concurrently.
The run() method contains the thread's task, and the start() method is used to begin the thread's execution.
The order of thread execution is determined by the thread scheduler, so the output sequence is unpredictable.*/
public class test extends Thread {
	
	public void run() {
		try {
			 System.out.println(Thread.currentThread().getId()+" is running");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		//sequence of this output will not be same always 
		for(int i=0;i<3;i++) {
			test ob=new test();
			ob.start(); //this will go to new phase and call run()
		}
		

		
	}

}
