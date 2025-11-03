#include <stdio.h>
#include <unistd.h>

int main(){
	pid_t pid=fork();
	if(pid==0){
	   fork();
	printf("Child section\n");
	}else{
	printf("Parent section\n");
	}
  return 0;
}

