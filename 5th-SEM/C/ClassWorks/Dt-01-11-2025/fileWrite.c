#include <stdio.h>

int main() {
    FILE *fp;
    fp = fopen("data.txt", "w");
    if (fp == NULL) {
        printf("File not created!\n");
        return 1;
    }
    fprintf(fp,"Hello File Handling!\n");
    fprintf(fp,"C Programming Example\n");
    fclose(fp);
    printf("Data written successfully.");

    return 0;
}

