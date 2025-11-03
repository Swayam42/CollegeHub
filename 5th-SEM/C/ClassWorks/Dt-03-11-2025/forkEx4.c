#include <stdio.h>
#include <unistd.h>

int main(){
	int x=5;
  if(fork()==0){
	x+=5;
   }else{
	x-=5;
	}
	printf("PID %ld: x=%d\n",(long)getpid(),x);
  return 0;
}

