#include <stdio.h>
#define N 5
int top= -1;
int stack[N];
void push(int n){
    if (top== N-1){
        printf("Stack Overflow\n");
    }else{
        top++;
        stack[top]=n;
    }
}

void pop(){
    int item;
    if(top==-1){
        printf("Underflow\n");
    }else{
        item=stack[top];
        top--;
    }
    printf("%d popped out\n",item);
}

int peek(){
    if(top==-1){
        printf("Stack is Empty\n");
    }else{
        return stack[top];
    }
}
void display(){
    for(int i=top;i>=0;i--){
        printf("%d \n",stack[i]);
    }
}
int main(void) {
    push(7);
    push(5);
    push(2);
    pop();
    display();
    return 0;
}
