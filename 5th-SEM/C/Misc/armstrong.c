#include <stdio.h>
#include <math.h>

#define N 10
int stack[N];
int top=-1;
void push(int n){
if(top==N-1){
    printf("Stack Overflow");
}else{
    top++;
    stack[top]=n;
}
}

int pop(){
    if(top==-1){
        printf("Stack Underflow");
        return -1;
    }else{
       int item= stack[top];
        top--;
        return item;
    }
}
int main(){
    int num=371,digit;
    int temp=num;
    int count=0;
    int sum=0;

    while(temp>0){
        digit=temp%10;
        push(digit);
        count++;
        temp/=10;
    }

    while(top!=-1){
        digit=pop();
        sum+=pow(digit,count);
    }

    if(sum==num){
        printf("Armstrong Number");
    }else{
        printf("Not an Armstrong Number");
    }
    return 0;
}