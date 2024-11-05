package Assignment_2;

public class q3 {
    static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }

    public static void main(String[] args) {
        System.out.println(fact(3));
    }
}
