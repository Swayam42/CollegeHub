package Assignment_6;
/*print the duplicate elements in a given array of n no.s */
public class Q2 {

    static void printDuplicate(int a[]){
        int n=a.length;
        for(int i=0;i<n;i++){
            boolean isDup=false;

            for(int k=0;k<i;k++){
                if(a[i]==a[k]){
                    isDup=true;
                    break;
                }
            }

            if(isDup){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(a[i]==a[j]){
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[]={4,2,1,4,3,2,5,3,5,2,2};
        printDuplicate(a);
        }
    }
/*
Time Complexity: O(n^2)

Space Complexity: O(1)

Output:
4
2
3
5
*/

