/*
write a cpp prog in which you are supposed to print the grade of the students in different ranges
90<m<=100 : O
80<m<=90 : A
70<m<=80 : B
60<m<=70 : C
50<m<=60 : D
40<m<=50 : E
m<40 : F
*/

#include <iostream>
using namespace std;
int main(){
float x;
cout << "Enter Marks: ";
cin >>x;
cout << "Grade: ";
if (x>90 && x<=100){
	cout << "O";
}
else if (x>80 && x<=90){
	cout << "A";
}
else if (x>70 && x<=80){
	cout << "A";
}
else if (x>60 && x<=70){
	cout << "A";
}
else if (x>50 && x<=60){
	cout << "A";
}
else if (x>40 && x<=50){
	cout << "A";
}
else{
	cout << "F";
}
return 0;
}
