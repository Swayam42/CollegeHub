#include <stdio.h>
int main() {
    FILE *fp;
    char str[50];
    fp=fopen("data.txt", "r");
    if (fp==NULL){
        printf("File not found!\n");
        return 1;
    }
    while(fgets(str,50,fp)!=NULL)
        printf("%s", str);
    fclose(fp);
    return 0;
}

