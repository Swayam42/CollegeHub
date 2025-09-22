#include <stdio.h>
int main(){
    int arr[10];
    int pos=0,neg=0;
    printf("Input 10 Elements: \n");
    for(int i=0;i<10;i++){
        scanf("%d",&arr[i]);
    }
    for(int i=0;i<10;i++){
        if(arr[i]>0){
            pos++;
        }else if(arr[i]<0){
	    neg++;
	}
    }
    printf("No. Of Positive Elements: %d \n",pos);
    printf("No. of Negative Elements: %d",neg);
    return 0;
}
