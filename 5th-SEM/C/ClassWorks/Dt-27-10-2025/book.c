#include <stdio.h>
#define qty 10
#define FestivalOffer 2
#define DiscountCoupon 5
#define Kindle 2
#define pf printf
int main(){
    int discount;
    float price,totalAmount,afterDisc,afterFDisc;
    pf("Enter price of book: ");
    scanf("%f",&price);
    #if qty >=10
    	discount=15;
    #elif qty >=5
    	discount=10;
    #else
    	discount=5;
    #endif
totalAmount =qty*price;
afterDisc=totalAmount -(totalAmount*discount)/100;
#ifdef FestivalOffer
    afterFDisc=afterDisc-(totalAmount*FestivalOffer)/100;
#else
    afterFDisc =afterDisc;
#endif

pf("Quantity =%d,Price=%.2f,Total=%.2f\n",qty,price,totalAmount);
pf("Discount is %d and total amount after discount is %.2f\n",discount,afterDisc);
#ifdef FestivalOffer
    pf("Festival discount is %d, total after festival discount: %.2f\n",FestivalOffer,afterFDisc);
#endif
#if defined (DiscountCoupon)
     pf("You are also eligible for a discount coupon of $%d\n",DiscountCoupon);
#endif

#ifndef Kindle
    #define Kindle 1
#endif
pf("You can use Kindle version of the book for %d month(s)\n",Kindle);
return 0;
}
