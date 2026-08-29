#include <stdio.h>



void print_math(int *a, int *b){
    int c=*a+*b;
     int d =(*a)*(*b);
   printf("Sum: %d\n",c);

    printf("Product: %d\n",d);

    

}

int main(){
    int a,b;
 
     printf("Enter your first number: ");
    scanf("%d", &a);

      printf("Enter your second number: ");
    scanf("%d", &b);

    print_math(&a,&b);
   

    

}

