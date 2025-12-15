#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(){
	int flags=fcntl(STDIN_FILENO,F_GETFL);
	fcntl(STDIN_FILENO, F_SETFL, flags | O_NONBLOCK);
	char buf[32];
	read(STDIN_FILENO,buf,sizeof(buf));
	return 0;
}

