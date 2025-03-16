package Assignment_3;
/*Create a custom-checked exception class named CustomCheckedException. Use this 
exception in your program to handle a specific error condition and demonstrate its 
usage with a try-catch block */
class CustomCheckedException extends Exception {
    public CustomCheckedException(String msg) {
        super(msg);
    }
}

public class Q8 {

    public static void checkAdmitCard(boolean hasAdmitCard) throws CustomCheckedException {
        if (!hasAdmitCard) {
            throw new CustomCheckedException("Admit card is missing");
        }
    }
    public static void main(String[] args) {
        boolean hasAdmitCard=false;
        try{
            checkAdmitCard(hasAdmitCard);
            System.out.println("Kid has taken Admit Card");
        }
        catch(CustomCheckedException e){
            System.out.println(e);
        }
    }

}
/*OUTPUT:
 Assignment_3.CustomCheckedException: Admit card is missing
 */
