#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t sa, sb;

void* printA(void* arg)
{
    for (int i = 0; i < 10; i++) {
        sem_wait(&sa);
        printf("A");
        sem_post(&sb);
    }
    return NULL;
}

void* printB(void* arg)
{
    for (int i = 0; i < 10; i++) {
        sem_wait(&sb);
        printf("B");
        sem_post(&sa);
    }
    return NULL;
}

int main()
{
    pthread_t t1, t2;
    sem_init(&sa, 0, 1);
    sem_init(&sb, 0, 0);

    pthread_create(&t1, NULL, printA, NULL);
    pthread_create(&t2, NULL, printB, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    return 0;
}
