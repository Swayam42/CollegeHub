
import java.util.LinkedList; 
import java.util.Queue; 
class Q8 { 
    private final Queue<Integer> buffer = new LinkedList<>(); 
    private final int capacity; 
    public SharedBuffer(int capacity) { 
        this.capacity = capacity; 
    } 
    public synchronized void put(int value) { 
        while (buffer.size() == capacity) { 
            try { 
                wait(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
        buffer.offer(value); 
        System.out.println("Produced: " + value); 
        notify(); 
    } 
    public synchronized int get() { 
        while (buffer.isEmpty()) { 
            try { 
                wait(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
        int value = buffer.poll(); 
        System.out.println("Consumed: " + value); 
        notify(); return value; 
    } 
} 
class Producer extends Thread { 
    private final SharedBuffer buffer; 
    public Producer(SharedBuffer buffer) { 
        this.buffer = buffer; 
    } 
    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            buffer.put(i); 
            try { 
                Thread.sleep(500); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
