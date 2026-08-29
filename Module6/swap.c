#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;   // save the value at address a
    *a = *b;         // copy value at b into a
    *b = temp;       // copy saved value into b
}

int main() {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);   
    printf("After swap:  x = %d, y = %d\n", x, y);

    return 0;
}