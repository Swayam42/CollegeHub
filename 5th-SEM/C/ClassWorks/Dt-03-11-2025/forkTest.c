#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid1, pid2, pid3;

    printf("Start: PID=%d, PPID=%d\n", getpid(), getppid());

    pid1 = fork();  // First fork
    if (pid1 == 0)
        printf("[After fork 1] Child 1: PID=%d, PPID=%d\n", getpid(), getppid());
    else
        printf("[After fork 1] Parent: PID=%d, Child1 PID=%d\n", getpid(), pid1);

    pid2 = fork();  // Second fork
    if (pid2 == 0)
        printf("[After fork 2] Child 2: PID=%d, PPID=%d\n", getpid(), getppid());
    else
        printf("[After fork 2] Process PID=%d created Child2 PID=%d\n", getpid(), pid2);

    pid3 = fork();  // Third fork
    if (pid3 == 0)
        printf("[After fork 3] Child 3: PID=%d, PPID=%d\n", getpid(), getppid());
    else
        printf("[After fork 3] Process PID=%d created Child3 PID=%d\n", getpid(), pid3);

    // small delay to make output easier to read
    sleep(1);

    printf("Final -> PID=%d, PPID=%d\n", getpid(), getppid());

    return 0;
}

