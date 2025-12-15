#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(){
	int fd=open("out.txt",O_WRONLY|O_CREAT|O_TRUNC,0644);
	dup2(fd,STDOUT_FILENO);
	printf("Redirected output\n");
	close(fd);
	return 0;
	}
