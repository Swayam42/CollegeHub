int main(){
int i=345,j=01767, k=0xa0bd;
printf(":%8u: :%8o: :%8x:\n",i,j,k);
printf(":%-8u: :%-8o: :%-8x:\n",i,j,k);
printf(":%#8u: :%#8o: :%#8x:\n",i,j,k);
printf(":%08u: :%0o0: :%08x:\n",i,j,k);
printf(":% #8u: :% #8o: :% #8x:\n",i,j,k);
return 0;
}
/*
:     345: :    1767: :    a0bd:
:345     : :1767    : :a0bd    :
:     345: :   01767: :  0xa0bd:
:00000345: :17670: :0000a0bd:
:     345: :   01767: :  0xa0bd:
*/