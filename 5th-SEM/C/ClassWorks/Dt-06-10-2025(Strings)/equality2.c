#include <stdio.h>
int main(){
  if(*"hello"==*"hail"){
	printf("Strings are equal \n");
  }else{
	printf("Strings are not equal \n");	
  }
  return 0;
}

/*Output : Strings are equal ... As ASCII value of first char of 2 Strings are checked*/
