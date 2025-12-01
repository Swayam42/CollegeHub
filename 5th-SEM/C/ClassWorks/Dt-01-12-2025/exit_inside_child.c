#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
void handler(){
	printf("atexit():cleanup handler executed\n");
}	

int main() {
	atexit(handler);
	printf("Before fork..\n");    
	pid_t pid=fork();
    if (pid==0){
		printf("Child: calling exit()\n");
		exit(0);
	}else{
		printf("Parent: child created, PID=%d\n",pid);
	}
	

    return 0;
}

