class Q5 { 
    private int num = 1; private final int limit; 
    public Number(int limit) { 
        this.limit = limit; 
    } 
    public synchronized void printOdd() { 
        while (num < limit) { 
            while (num % 2 == 0) { 
                try { 
                    wait(); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
            System.out.println("Odd: " + num); 
            num++; 
            notify(); 
        } 
    } 
    public synchronized void printEven() { 
        while (num <= limit) { 
            while (num % 2 != 0) { 
                try { 
                    wait(); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
            System.out.println("Even: " + num); 
            num++; 
            notify(); 
        } 
    } 
} 
public class OddEven { 
    public static void main(String[] args) { 
        int limit = 10; 
        Number num = new Number(limit); 
        Thread oddThread = new Thread(num::printOdd); 
        Thread evenThread = new Thread(num::printEven); 
        oddThread.start(); 
        evenThread.start(); 
    } 
}
