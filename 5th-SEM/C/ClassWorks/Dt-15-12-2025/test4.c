#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(){
	int fd[2];
	char buf[20];
	pipe(fd);
	if(fork()==0){
		close()	
		
	}
	return 0;
}

