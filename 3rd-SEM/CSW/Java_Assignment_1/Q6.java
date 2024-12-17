/*Write a java program to copmute x/y without arithmetic operators */
public class Q6 {

    static int div(int x,int y){
        int d=0;
        int count=0;
        if(y>x){
            return 0;
        }
        while(d<x){
            d=d+y;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(div(34,34));
    }
}
