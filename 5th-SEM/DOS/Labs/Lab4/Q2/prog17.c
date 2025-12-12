#include <stdio.h>
#include<unistd.h>
int main(){
	int j,i=5;
	for(j=1;j<3;j++){
	if(fork()==0){
		i=i+1;
		break;
	}
	else
		wait(NULL);
	}
	printf("%d",i);
	return 0;
}
