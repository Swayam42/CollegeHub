#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc,char *argv[]) {
	pid_t p;

	if(argc!=2){
		fprintf(stderr,"Usage: %s <num_processes>\n",argv[0]);
		return 1;
	}
	for(int i=1;i<=4;i++){
		printf("Process P%d: PID=%d, PPID=%d\n",i,getpid(),getppid());
		p=fork();
		if(p<0){
			printf("Fork Failed");
		return 1;
		}
		if(p==0){
			continue;
		}else{
			break;
		}
	}
   sleep(1);
   return 0;
}
