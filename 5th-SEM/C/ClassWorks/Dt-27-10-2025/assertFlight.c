//Runtime Assertion
#include <stdio.h>
#include <assert.h>
#define pf printf
int main(){
  int c,noOfPassengers;
  char fl_from[30],fl_to[30],dateOfJourney[12];
  printf("How many passengers ?");
  scanf("%d",&noOfPassengers);
  assert(noOfPassengers >0 && "number of passengers should be a positive integer");
  printf("Flight from : ");
  while((c=getchar()!='\n'&& c!=EOF));
  scanf("%c",&fl_from);
  printf("Flight to : ");
  scanf("%c",fl_to);
  printf("Date of journey");
  scanf("%s",dateOfJourney);
  printf("The info entered is :\n");
  printf("Number of passengers %d\n",noOfPassengers);
  pf("Flights from : %s\n",fl_from);
  pf("Flight to :"%s\n",fl_to);
  pf("Date of journey: %s\n",dateOfJourney);
  return 0;
}
