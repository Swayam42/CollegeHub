
import java.util.ArrayList; 
import java.util.List; 
class PrimeCalculator extends Thread { 
    private final int start, end; 
    private final List<Integer> primes; 
    public PrimeCalculator(int start, int end, List<Integer> primes) { 
        this.start = start; 
        this.end = end; 
        this.primes = primes; 
    } 
    private boolean isPrime(int num) { 
        if (num < 2) return false; 
        for (int i = 2; i * i <= num; i++) { 
            if (num % i == 0) return false; 
        } 
        return true; 
    } 
    public void run() { 
        for (int num = start; num <= end; num++) { 
            if (isPrime(num)) { 
                synchronized (primes) { 
                    primes.add(num); 
                } 
            } 
        } 
    } 
} 
public class Q7 { 
    public static void main(String[] args) { 
        int limit = 50; 
        int numThreads = 4; 
        List<Integer> primes = new ArrayList<>(); 
        Thread[] threads = new Thread[numThreads]; 
        int range = limit / numThreads; 
        for (int i = 0; i < numThreads; i++) { 
            int start = i * range + 1; 
            int end = (i == numThreads - 1) ? limit : (i + 1) * range; 
            threads[i] = new PrimeCalculator(start, end, primes); 
            threads[i].start(); 
        } 
        for (Thread thread : threads) { 
            try { 
                thread.join(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
        primes.sort(Integer::compareTo); 
        System.out.println("Prime numbers up to " + limit + ": " + primes); 
    } 
} 
