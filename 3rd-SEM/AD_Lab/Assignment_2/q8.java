package Assignment_2;
import java.util.Arrays;
public class q8 {
    
    static int firstMissing(int a[], int start, int end)  { 
        Arrays.sort(a);
        if (start>end) 
            return end+1; 
        if (start!=a[start]) 
            return start; 
        int mid=(start+end)/2; 
        if (a[mid]==mid) 
            return firstMissing(a,mid+1,end); 
  
        return firstMissing(a,start,mid); 
    } 
    
    public static void main(String[] args) {
        int a[]={0,1,43,63,2,64,21,52,17,3,97};
       
        int n=a.length;
        System.out.println(firstMissing(a, 0, n-1));

    }
}
