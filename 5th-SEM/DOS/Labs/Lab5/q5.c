#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t sa, sb, sc;
int num = 1;

void* printA(void* arg)
{
    while (num <= 20) {
        sem_wait(&sa);
        if (num <= 20) printf("A%d\n", num++);
        sem_post(&sb);
    }
    return NULL;
}

void* printB(void* arg)
{
    while (num <= 20) {
        sem_wait(&sb);
        if (num <= 20) printf("B%d\n", num++);
        sem_post(&sc);
    }
    return NULL;
}

void* printC(void* arg)
{
    while (num <= 20) {
        sem_wait(&sc);
        if (num <= 20) printf("C%d\n", num++);
        sem_post(&sa);
    }
    return NULL;
}

int main()
{
    pthread_t t1, t2, t3;
    sem_init(&sa, 0, 1);
    sem_init(&sb, 0, 0);
    sem_init(&sc, 0, 0);

    pthread_create(&t1, NULL, printA, NULL);
    pthread_create(&t2, NULL, printB, NULL);
    pthread_create(&t3, NULL, printC, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);
    return 0;
}
