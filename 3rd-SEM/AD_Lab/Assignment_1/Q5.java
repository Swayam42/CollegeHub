import java.util.Arrays;
public class Q5 {
    
    static int missing(int arr[]){
        Arrays.sort(arr);
        int n=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n &&arr[i]>=1 ){
                n++;
            }
        }
        return n;
    }
    
    public static void main(String[] args) {
        int arr[]={0,-3,4,-5,1,3,2};
        System.out.println(missing(arr));
    }
}
