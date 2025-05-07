package MultiThreading;

public class demo implements Runnable{
	@Override
	public void run() {
		try {
			System.out.println("Thread "+Thread.currentThread().getId()+" is running");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		for(int i=0;i<4;i++) {
			demo ob=new demo();
			Thread thread=new Thread(ob);
			thread.start();
		}

	}

	

}
