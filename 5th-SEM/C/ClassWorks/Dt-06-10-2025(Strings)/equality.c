#include <stdio.h>
int main(){
  char str1[10]="hello";
  char str2[10]="hello";
  if(str1==str2){
	printf("Strings are equal \n");
  }else{
	printf("Strings are not equal \n");	
  }
  return 0;
}
