/*find max and min elements in an array */

public class Q2 {
    public static void main(String[] args) {
        int a[]={23,53,12,32};
        int max=a[0];
        int min=a[0];
        for(int i=1;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
            if(a[i]<min){
                min=a[i];
            }
        }
        System.out.println("Max num: "+max);
        System.out.println("Min num: "+min);
    }
}
/*
Output : 
Max num: 53
Min num: 12

T(N)=O(N)
S(N)=O(1)
*/
