#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(){
	int fd;
	mode_t fdmode = (S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH);
	fd=open("info.dat",O_RDWR | O_CREAT,fdmode);
	if(fd==-1){
		perror("Failed to open info.dat");		
	}
	close(fd);
	return 0;
	}
