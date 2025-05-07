package MultiThreading;

public class ThreadSleep extends Thread{
	public void run() {
		try {
			for(int i=0;i<4;i++) {
				Thread.sleep(500);
				System.out.println("Thread "+Thread.currentThread().getId()+" is running");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ThreadSleep t1=new ThreadSleep();
		ThreadSleep t2=new ThreadSleep();
		t1.start();
		t2.start();

	}

}
