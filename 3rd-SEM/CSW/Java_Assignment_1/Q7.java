/*Write a program to find x^y */
public class Q7 {

    static int pow(int x,int y){
        if(y==0){
            return 1;
        }
        return pow(x,y-1)*x;
    }
    public static void main(String[] args) {
        System.out.println(pow(2,4));
    }
}
