#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;

    pid = fork();
    if (pid == 0) {
        printf("First Child | PID=%d PPID=%d\n", getpid(), getppid());
        execlp("cp", "cp", "file1", "file2", NULL);
    }
    sleep(1);

    pid = fork();
    if (pid == 0) {
        printf("Second Child | PID=%d PPID=%d\n", getpid(), getppid());
        execlp("cat", "cat", "file2", NULL);
    }
    sleep(1);

    pid = fork();
    if (pid == 0) {
        printf("Third Child | PID=%d PPID=%d\n", getpid(), getppid());
        execlp("sort", "sort", "-r", "file2", NULL);
    }

    wait(NULL);
    wait(NULL);
    wait(NULL);

    printf("Parent Process Completed | PID=%d\n", getpid());
    return 0;
}
