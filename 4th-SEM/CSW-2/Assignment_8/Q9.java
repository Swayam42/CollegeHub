class Consumer extends Thread { 
    private final SharedBuffer buffer; 
    public Consumer(SharedBuffer buffer) { 
        this.buffer = buffer; 
    } 
    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            buffer.get(); 
            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
public class Q9 { 
    public static void main(String[] args) { 
        SharedBuffer buffer = new SharedBuffer(3); 
        Producer producer = new Producer(buffer); 
        Consumer consumer = new Consumer(buffer); 
        producer.start(); 
        consumer.start(); 
        try { 
            producer.join(); 
            consumer.join(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        System.out.println("Producer and Consumer have completed their tasks."); 
    } 
} 
