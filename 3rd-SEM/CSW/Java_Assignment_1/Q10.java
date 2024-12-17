/* Write a Java program that reads two float numbers and checks whether the
 difference between these two numbers is less than ϵ (ϵ < 1). */
public class Q10 {
    
    static boolean isDiffLessThan1(float x,float y){
        System.out.println("Difference : "+(x-y));
        return ((x-y)<1);
    }
    public static void main(String[] args) {
        System.out.println(isDiffLessThan1(34f, 5.4f));
    }
}
