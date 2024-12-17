/*Write a java program to copmute x×y without arithmetic operators */
class Q5{
    static int mult(int x,int y){
        int p=0;
        while(y>0){
            p=p+x;
            y--;
        }
        return p;
    }
    public static void main(String[] args) {
        System.out.println(mult(7, 5));
    }
}