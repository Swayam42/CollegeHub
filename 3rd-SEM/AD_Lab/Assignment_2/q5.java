package Assignment_2;
public class q5 {
    
    static int GCD(int a,int b){
        if(b==0){
            return a;
        }else if(a==0){
            return b;
        }else{
            return GCD(b,a%b);
        }
    }
    public static void main(String[] args) {
        System.out.println(GCD(4,16));
    }
}
