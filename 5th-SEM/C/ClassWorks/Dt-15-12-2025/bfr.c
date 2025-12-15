#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(){
	int fd=open("data.txt",O_RDONLY);
	char buf[64];
	ssize_t n;
	n=read(fd,buf,sizeof(buf));
	write(STDOUT_FILENO,buf,n);
	close(fd);
	return 0;
	}
