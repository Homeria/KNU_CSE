#include <stdio.h>
int bitAnd(int x, int y);
int anyEvenBit(int x);
int allOddBits(int x);
int logicalShift(int x, int n);
int logicalNeg(int x);
int bitCount(int x);
int tmin(void);
int isPositive(int x);
int sign(int x);
int addOK(int x, int y);
int isLess(int x, int y);
unsigned floatAbsVal(unsigned uf);
unsigned floatNegate(unsigned uf);
int floatFloat2Int(unsigned uf);
void printBinary(int x, char str[]);
void printUBinary(unsigned int x, char str[]);

int main(void) {
    
    printf("--------- andBit -------------------------------------------------------------------------\n\n");

    int andBit = bitAnd(5, 6);
    printf("bitAnd(%d, %d) = %d\n\n", 5, 6, andBit);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("--------- anyEvenBit --------------------------------------------------------------------\n\n");

    int b = anyEvenBit(0xA);
    printf("anyEvenBit(%d) = %d\n\n", 0xA, b);
    int c = anyEvenBit(0xE);
    printf("anyEvenBit(%d) = %d\n\n", 0xE, c);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("---------- allOddBits -------------------------------------------------------------------\n\n");

    int odd = allOddBits(0xFFFFFFFE);
    printf("odd(%x) = %d\n\n", 0xFFFFFFFE, odd);
    odd = allOddBits(0xAAAAAAAA);
    printf("odd(%x) = %d\n\n", 0xAAAAAAAA, odd);
    odd = allOddBits(0xaa);
    printf("odd(%x) = %d\n\n", 0xaa, odd);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("------------ logicalShift ----------------------------------------------------------------\n\n");

    int shift = logicalShift(0x87654321, 4);
    printf("logicalShift(%x, %d) = %x\n\n", 0x87654321, 4, shift);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("------------- logicalNeg ----------------------------------------------------------------\n\n");

    int negative = logicalNeg(1);
    printf("logicalNeg(%d) = %d\n\n", 1, negative);
    negative = logicalNeg(-1);
    printf("logicalNeg(%d) = %d\n\n", -1, negative);
    negative = logicalNeg(3);
    printf("logicalNeg(%d) = %d\n\n", 3, negative);
    negative = logicalNeg(-3);
    printf("logicalNeg(%d) = %d\n\n", -3, negative);
    negative = logicalNeg(-255);
    printf("logicalNeg(%d) = %d\n\n", -255, negative);
    negative = logicalNeg(255);
    printf("logicalNeg(%d) = %d\n\n", 255, negative);
    negative = logicalNeg(0);
    printf("logicalNeg(%d) = %d\n\n", 0, negative);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("-------------- bitCount -----------------------------------------------------------------\n\n");

    int bitCnt = bitCount(5);
    printf("bitCnt(%d) = %d\n\n", 5, bitCnt);
    bitCnt = bitCount(0xaaaaaaaa);
    printf("bitCnt(%d) = %d\n\n", 5, bitCnt);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("--------------- tmin ---------------------------------------------------------------------\n\n");

    int m = tmin();
    printf("tmin = %d\n\n", m);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("--------------- isPositive ---------------------------------------------------------------\n\n");

    int positive = isPositive(1);
    printf("isPositive(%d) = %d\n\n", 1, positive);
    positive = isPositive(2);
    printf("isPositive(%d) = %d\n\n", 2, positive);
    positive = isPositive(-1);
    printf("isPositive(%d) = %d\n\n", -1, positive);
    positive = isPositive(-2);
    printf("isPositive(%d) = %d\n\n", -2, positive);
    positive = isPositive(0);
    printf("isPositive(%d) = %d\n\n", 0, positive);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("----------------- sign -------------------------------------------------------------------\n\n");

    int s = sign(130);
    printf("sign(%d) = %d\n\n", 130, s);
    s = sign(-20);
    printf("sign(%d) = %d\n\n", -20, s);
    s = sign(0);
    printf("sign(%d) = %d\n\n", 0, s);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("----------------- addOK ----------------------------------------------------------------\n\n");

    int ok = addOK(0x80000000, 0x80000000);
    printf("addOK(%d, %d) = %d\n\n", 0x80000000, 0x80000000, ok);
    ok = addOK(0x80000000, 0x70000000);
    printf("addOK(%d, %d) = %d\n\n", 0x80000000, 0x70000000, ok);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("------------------- isLess ---------------------------------------------------------------\n\n");

    int less = isLess(4, 5);
    printf("less(%d, %d) = %d\n\n", 4, 5, less);
    less = isLess(5, 4);
    printf("less(%d, %d) = %d\n\n", 5, 4, less);
    less = isLess(5, 5);
    printf("less(%d, %d) = %d\n\n", 5, 5, less);

    printf("------------------------------------------------------------------------------------------\n\n");

    printf("------------------------------------------------------------------------------------------\n\n");

}

void printBinary(int x, char str[]) {
    printf("printBinary(%s, %x, %d) \t\t\t: ", str, x, x);
    for (int i = 31; i >= 0; i--) {
        int result = x >> i & 1;
        printf("%d", result);
        if ((i % 4) == 0) {
            printf(" ");
        }
    }
    printf("\n");
}

void printUBinary(unsigned x, char str[]) {
    printf("printUBinary(%s, %x, %d) \t\t\t: ", str, x, x);
    for (int i = 31; i >= 0; i--) {
        int result = x >> i & 1;
        printf("%d", result);
        if ((i % 4) == 0) {
            printf(" ");
        }
    }
    printf("\n");
}

/* 
 * bitAnd - x&y using only ~ and | 
 *   Example: bitAnd(6, 5) = 4
 *   Legal ops: ~ |
 *   Max ops: 8
 *   Rating: 1
 */
int bitAnd(int x, int y) {

    printBinary(x, "x");
    printBinary(y, "y");
    printBinary(~x, "~x");
    printBinary(~y, "~y");
    printBinary(~x | ~y, "~x | ~y");
    printBinary(~(~x | ~y), "~(~x | ~y)");

  return (~(~x | ~y));
}
/* 
 * anyEvenBit - return 1 if any even-numbered bit in word set to 1
 *   where bits are numbered from 0 (least significant) to 31 (most significant)
 *   Examples anyEvenBit(0xA) = 0, anyEvenBit(0xE) = 1
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 2
 */
int anyEvenBit(int x) {
    
    int mask = 0x55555555;
    int result = x & mask;              // mask the even-numbered bit. 0 if one of the even number 1 beats is missing.
    result = !(result);                     // 1 if one of the even number 1 beats is missing.
    result = !(result);                     // 

    printBinary(x, "x");
    printBinary(mask, "mask");
    printBinary(x & mask, "x & mask");
    printBinary(!(x & mask), "!(x & mask)");
    printBinary(!!(x & mask), "!!(x & mask)");

  return result;
}
/* 
 * allOddBits - return 1 if all odd-numbered bits in word set to 1
 *   where bits are numbered from 0 (least significant) to 31 (most significant)
 *   Examples allOddBits(0xFFFFFFFD) = 0, allOddBits(0xAAAAAAAA) = 1
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 2
 */
int allOddBits(int x) {
   
    int mask = 0xaaaaaaaa;
    printBinary(mask, "mask");

    int mask2 = ~mask;
    printBinary(mask2, "~mask");

    int result = (x & mask2);
    printBinary(result, "(x & mask2)");

    result = result | mask;
    printBinary(result, "(x & mask2) | mask");

    result = result & mask2;
    printBinary(result, "((x & mask2) | mask) & mask2)");

    result = !result;
    printBinary(result, "!((x & mask2) | mask) & mask2)");

    return  result;
}
/* 
 * logicalShift - shift x to the right by n, using a logical shift
 *   Can assume that 0 <= n <= 31
 *   Examples: logicalShift(0x87654321,4) = 0x08765432
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 3 
 */
int logicalShift(int x, int n) {
    printBinary(x, "x");
    printBinary(n, "n");

    x = x >> n;
    printBinary(x, "x >> n");

    int mask = ((1 << 31) >> (n - 1));
    printBinary(mask, "mask");

    printBinary(~mask, "~mask");

    printBinary(~mask & x, "~mask & x");

    return (~mask & x);
}
/* 
 * logicalNeg - implement the ! operator, using all of 
 *              the legal operators except !
 *   Examples: logicalNeg(3) = 0, logicalNeg(0) = 1
 *   Legal ops: ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 4 
 */
int logicalNeg(int x) {

    printBinary(x, "x");
    printBinary(~x, "~x");

    int result = x | (~x + 1);
    printBinary(result, "x | (~x + 1)");

    result = result >> 31;
    printBinary(result, "(x | (~x + 1)) >> 31");

    result = result & 1;
    printBinary(result, "((x | (~x + 1)) >> 31) & 1");

    result = result ^ 1;
    printBinary(result, "(((x | (~x + 1)) >> 31) & 1) ^ 1");

    return  result;
}
/*
 * bitCount - returns count of number of 1's in word
 *   Examples: bitCount(5) = 2, bitCount(7) = 3
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 40
 *   Rating: 4
 */
int bitCount(int x) {
    
    printBinary(x, "x");

    int result;
    int mask = 0x1;
    mask = mask | (mask << 8);
    mask = mask | (mask << 16);
    printBinary(mask, "mask");
    printf("\n");

    result = mask & x;
    printBinary(result, "result");
    printf("\n");

    result += mask & (x >> 1);
    printBinary(mask, "mask");
    printBinary(x >> 1, "x >> 1");
    printBinary(result, "result 1");
    printf("\n");

    result += mask & (x >> 2);
    printBinary(mask, "mask");
    printBinary(x >> 2, "x >> 2");
    printBinary(result, "result 2");
    printf("\n");

    result += mask & (x >> 3);
    printBinary(mask, "mask");
    printBinary(x >> 3, "x >> 3");
    printBinary(result, "result 3");
    printf("\n");

    result += mask & (x >> 4);
    printBinary(mask, "mask");
    printBinary(x >> 4, "x >> 4");
    printBinary(result, "result 4");
    printf("\n");

    result += mask & (x >> 5);
    printBinary(mask, "mask");
    printBinary(x >> 5, "x >> 5");
    printBinary(result, "result 5");
    printf("\n");

    result += mask & (x >> 6);
    printBinary(mask, "mask");
    printBinary(x >> 6, "x >> 6");
    printBinary(result, "result 6");
    printf("\n");

    result += mask & (x >> 7);
    printBinary(mask, "mask");
    printBinary(x >> 7, "x >> 7");
    printBinary(result, "result 7");
    printf("\n");

    result += result >> 16;
    printBinary(result, "result >> 16");
    result +=  result >> 8;
    printBinary(result, "result >> 8");
    result = result & 0xFF;


  return result;
}
/* 
 * tmin - return minimum two's complement integer 
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 4
 *   Rating: 1
 */
int tmin(void) {
    return (1 << 31);
}
/* 
 * isPositive - return 1 if x > 0, return 0 otherwise 
 *   Example: isPositive(-1) = 0.
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 8
 *   Rating: 2
 */
int isPositive(int x) {
    printBinary(x, "x");
    printBinary(!x, "!x");
    printBinary(x >> 31, "x >> 31");
    printBinary((x >> 31) | (!x), "(x >> 31) | (!x)");
    printBinary(!((x >> 31) | (!x)), "!((x >> 31) | (!x))");

    return !((x >> 31) | (!x));
}
/* 
 * sign - return 1 if positive, 0 if zero, and -1 if negative
 *  Examples: sign(130) = 1
 *            sign(-23) = -1
 *  Legal ops: ! ~ & ^ | + << >>
 *  Max ops: 10
 *  Rating: 2
 */
int sign(int x) {

    printBinary(x, "x");
    printBinary(!!x, "!!x");
    printBinary(x >> 31, "x >> 31");
    printBinary((!!x) | (x >> 31), "(!!x) | (x >> 31)");

    return (!!x) | (x >> 31);
}
/* 
 * addOK - Determine if can compute x+y without overflow
 *   Example: addOK(0x80000000,0x80000000) = 0,
 *            addOK(0x80000000,0x70000000) = 1, 
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 3
 */
int addOK(int x, int y) {
    int sum = x + y;

    printBinary(sum, "sum");
    printBinary(x, "x");
    printBinary(y, "y");
    printBinary(sum ^ x, "sum ^ x");
    printBinary(sum ^ y, "sum ^ y");
    printBinary((sum ^ x) & (sum ^ y), "(sum ^ x) & (sum ^ y)");
    printBinary(((sum ^ x) & (sum ^ y)) >> 31, "((sum ^ x) & (sum ^ y)) >> 31");

    printBinary(!(((sum ^ x) & (sum ^ y)) >> 31), "!(((sum ^ x) & (sum ^ y)) >> 31)");
  return !(((sum ^ x) & (sum ^ y)) >> 31);
}
/* 
 * isLess - if x < y  then return 1, else return 0 
 *   Example: isLess(4,5) = 1.
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 24
 *   Rating: 3
 */
int isLess(int x, int y) {

    printBinary(x, "x");
    printBinary(y, "y");

    int result = x + (~y + 1);

    printBinary(result, "x + (~y + 1)");

    int flag1 = x & (~y);

    printBinary(flag1, "x & (~y)");

    int flag2 = (~(x ^ y)) & result;

    printBinary(flag2, "(~(x^y)) & result");

    result = (flag1 | flag2) >> 31 & 1;
    
    printBinary(result, "(flag1 | flag2) >> 31 & 1");

  return result;
}
/* 
 * floatAbsVal - Return bit-level equivalent of absolute value of f for
 *   floating point argument f.
 *   Both the argument and result are passed as unsigned int's, but
 *   they are to be interpreted as the bit-level representations of
 *   single-precision floating point values.
 *   When argument is NaN, return argument..
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. also if, while
 *   Max ops: 10
 *   Rating: 2
 */
unsigned floatAbsVal(unsigned uf) {

    printUBinary(uf, "uf");

    unsigned mask = 0x7FFFFFFF;
    printUBinary(mask, "mask");

    unsigned minNaN = 0x7F800001;
    printUBinary(minNaN, "minNaN");

    unsigned result = uf & mask;
    printUBinary(result, "uf & mask");

    if (result >= minNaN)
    {
        printf("result >= minNaN\n");
        return uf;
    }
    else
    {
        printf("result < minNaN\n");
        return result;
    }
}
/* 
 * floatNegate - Return bit-level equivalent of expression -f for
 *   floating point argument f.
 *   Both the argument and result are passed as unsigned int's, but
 *   they are to be interpreted as the bit-level representations of
 *   single-precision floating point values.
 *   When argument is NaN, return argument.
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. also if, while
 *   Max ops: 10
 *   Rating: 2
 */
unsigned floatNegate(unsigned uf) {

    printUBinary(uf, "uf");

    int result = 0x80000000 ^ uf;
    printBinary(result, "0x80000000 ^ uf");

    int exp = 0x7F800000 & uf;
    printBinary(exp, "0x7F800000 & uf");

    int frac = 0x007FFFFF & uf;
    printBinary(frac, "0x007FFFFF & uf");

    if ((exp == 0x7F800000) && frac) 
    {
        printf("exp == 0x7F800000 and frac\n");
        return uf;
    }
    else {
        printf("exp != 0x7F800000 or !frac\n");
        return result;
    }
}
/* 
 * floatFloat2Int - Return bit-level equivalent of expression (int) f
 *   for floating point argument f.
 *   Argument is passed as unsigned int, but
 *   it is to be interpreted as the bit-level representation of a
 *   single-precision floating point value.
 *   Anything out of range (including NaN and infinity) should return
 *   0x80000000u.
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. also if, while
 *   Max ops: 30
 *   Rating: 4
 */
int floatFloat2Int(unsigned uf) {

    unsigned sign = uf >> 31;
    unsigned exp = (uf >> 23) && 0xFF;
    unsigned frac = (uf & 0x7FFFFFFF);
    unsigned bias = 0x7F;
    unsigned result = frac;

    if (exp == 0xFF) {
        return 0x8000000u;
    }

    if (exp < bias) {
        return 0x0;
    }

    exp -= bias;

    if (exp >= 31) {
        return 0x8000000u;
    }

    if (exp > 22) {
        result = frac << (exp - 23);
    }
    else {
        result = frac >> (23 - exp);
    }

    result += 1 << exp;

    if (sign) {
        
    }

    return result;

}
