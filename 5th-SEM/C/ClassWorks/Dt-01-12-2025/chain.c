#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    pid_t childpid;
    int i, n;

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <num_processes>\n", argv[0]);
        return 1;
    }

    n = atoi(argv[1]);

    for (i = 1; i < n; i++) {
        childpid = fork();
        if (childpid <= 0) {
            break;
        }
    }

    fprintf(stderr, "i:%d PID:%ld PPID:%ld childPID:%ld\n",i, (long)getpid(), (long)getppid(), (long)childpid);

    return 0;
}

