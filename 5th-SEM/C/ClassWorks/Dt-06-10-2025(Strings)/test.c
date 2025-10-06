#include <stdio.h>
int main(){
    char str[20] = "abcdef";
    printf("%s\n", str);        // prints "abcdef"
    printf("%s\n", str + 3);    // prints "def"
    str[3] = 97;                // set 4th character to 'a', so now "abcadef"
    printf("%s\n", str);        // prints "abcadef"
    str[3] = '\0';              // terminate string at 4th character, now "abc"
    printf("%s\n", str);        // prints "abc"
    return 0;
}

