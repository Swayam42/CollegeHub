#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

int main(){
	int fd=open("data.txt",O_RDONLY);
	if(fd==-1){
		perror("open failed");
		return 1;
	}
	printf("File opened with FD=%d\n",fd);
	close(fd);
	return 0;
	}
