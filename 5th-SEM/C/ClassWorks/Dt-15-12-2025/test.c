#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(){
	int fd=open("dup.txt",O_WRONLY|O_CREAT|O_TRUNC,0644);
	close(STDOUT_FILENO);
	dup(fd);
	printf("This goes to file\n");
	close(fd);
	return 0;
	}
