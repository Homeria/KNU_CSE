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
int floatFloat2Int2(unsigned uf);


int main(void) {

    int f2i = floatFloat2Int(0x3f800000);
    printf("f21(%x) = %d\n\n", 0x3f800000, f2i);
    f2i = floatFloat2Int(0xbf800000);
    printf("f21(%x) = %d\n\n", 0xbf800000, f2i);

    printf("====================================\n\n");


    int f2i2 = floatFloat2Int2(0x3f800000);
    printf("f212(%x) = %d\n\n", 0x3f800000, f2i2);
    f2i2 = floatFloat2Int2(0xbf800000);
    printf("f212(%x) = %d\n\n", 0xbf800000, f2i2);
    f2i2 = floatFloat2Int2(0x7f000000);
    printf("f212(%x) = %d(%x)\n\n", 0x7f000000, f2i2, f2i2);

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

    /* I used  De Morgan's laws. x& y = ~(~x | ~y) */

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

    /*
    I used how to masking even-numbered bit.
    I operate (x & mask), then get the result through ( ! ) operation
    */


    return (!!(x & ((((0x55 << 8) | 0x55) << 16) | ((0x55 << 8) | 0x55))));
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

    /*
   I used how to masking even-numbered bit.
   I operate (x & mask) and ((x & mask) ^ mask).
   When the result is 1(there's no 1 out of the even-numbered bit), it means that all the odd-numbered bit is 1
   */

    int m, mask;
    m = (0xaa << 8) | 0xaa;
    mask = (m << 16) | m;

    return  !((x & mask) ^ mask);
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
    /*
    I used how to remove 1 filled with shift.
    If x's MSB is 1, it will be filled with 1 as much as the shift.
    Therefore, when I remove filled bit with 1 as much as the shift, it works to logical shift without MSB.
    */

    return (~(((1 << 31) >> n) << 1) & (x >> n));
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

    /*
    I used how to divide 2 situation (x is zero, x is not zero)
    if x is zero, (~x + 1) equals x -> MSB is 0
    if x is not zero, (~x + 1) not equals x -> MSB is 1
    I fill all bits with MSB of (x | (~x + 1)), then get the LSB
    If LSB is 1, x is not zero.
    */

    int result = x | (~x + 1);

    result = result >> 31;

    result = result & 1;

    result = result ^ 1;

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

    /*
    I used how to divide into 8 bits
    Count the number of 1 in 8 bits and store the result in integer "result"
    then calculate count of bit
    */

    int result, m, mask;

    m = 0x1;
    m = m | (m << 8);
    mask = m | (m << 16);

    result = mask & x;
    result += mask & (x >> 1);
    result += mask & (x >> 2);
    result += mask & (x >> 3);
    result += mask & (x >> 4);
    result += mask & (x >> 5);
    result += mask & (x >> 6);
    result += mask & (x >> 7);

    result += result >> 16;
    result += result >> 8;
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
    /*
    I used shift the number 1
    The first bit is MSB in Two's complement integer
    If MSB is 1 and all number is 0 without MSB, This is tmin.
    */
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

    /*
    I used how to divide 2 situation (x is positive, x is zero or negative)
    x is positive -> x is not zero and negative
    Get the bits filled with 1 as much as the shift.
    Then, OR operation with (!x) -> If x is zero, LSB is 1.
    */

    // x is positive -> x is not zero and negative

    int result = (x >> 31);
    result = result | (!x);
    result = !result;

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
    /*
    I used how to divide 2 situation (x is zero, x is positive or negative)
    !!x is used to check the zero, and x >> 31 is used to check the MSB (positive, negative)
    then, operate OR with !!x and x >> 31 -> x is zero, or x is positive, or x is negative
    */

    int result = (!!x) | (x >> 31);

    return result;
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

    /*
    I used how to check overflow(MSB)
    sum(x + y) operate XOR with x(and y) and operate AND
    Then, get the MSB
    If there's an overflow, result is 0
    If there's an not overflow, result is 1
    */
    int sum = x + y;

    int result = (sum ^ x) & (sum ^ y);
    result = result >> 31;
    result = !result;

    return result;
}
/*
 * isLess - if x < y  then return 1, else return 0
 *   Example: isLess(4,5) = 1.
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 24
 *   Rating: 3
 */
int isLess(int x, int y) {

    /*
    I used how to divide 2 situation (x sign = y sign and x - y is negative, x < 0 && y >= 0)
    a means that x's sign is equals y's sign and x - y is negative
    b means that x < 0 && y >= 0
    then get MSB
    */

    int result = x + (~y + 1);

    int a = (~(x ^ y)) & result;
    int b = x & (~y);

    result = (a | b) >> 31 & 1;

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

    /*
    I refered to IEEE 754 (lecture slide 2021-2 lect 6) floating structure(?)
    I used how to only changed sign bit
    make the mask and minNaN, set sign bit to 0 using mask, and check the NaN
    */

    unsigned mask = 0x7FFFFFFF;

    unsigned minNaN = 0x7F800001;

    unsigned result = uf & mask;

    if (result >= minNaN) {
        return uf;
    }
    else {
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

    /*
     I refered to IEEE 754 (lecture slide 2021-2 lect 6) floating structure(?)
     I used only changed sign bit
     I only changed sign bit, then check the NaN (all expt bit is1)
    */

    int result = 0x80000000 ^ uf;

    int exp = 0x7F800000 & uf;

    int frac = 0x007FFFFF & uf;


    if ((exp == 0x7F800000) && frac)
    {
        return uf;
    }
    else {
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
    /*
    I refered to IEEE 754 (lecture slide 2021-2 lect 6) floating structure(?)
    I used how to divide 4 part (s, exp, frac, bias)
    Get the sign, exp, frac, and bias
    Then, compared depending on the conditions (exp is 0xFF, exp is equals 31 or bigger than 31, ... etc)
    */
    unsigned sign = uf >> 31;
    unsigned exp = (uf >> 23) & 0xFF;
    unsigned frac = (uf & 0x7FFFFFFF);
    unsigned bias = 0x7F;
    int result = frac;

    printBinary(uf, "uf");
    printBinary(sign, "sign");
    printBinary(exp, "exp");
    printBinary(frac, "frac");
    printBinary(frac >> 23, "frac >> 23");
    printBinary(frac << 23, "frac << 23");
    printBinary(bias, "bias");

    if (exp == 0xFF) {
        return 0x8000000u;
    }

    if (exp < bias) {
        return 0x0;
    }

    exp -= bias;
    printBinary(exp, "exp");

    if (exp >= 31) {
        return 0x8000000u;
    }

    if (exp > 22) {
        result = frac << (exp - 23);
    } else {
        result = frac >> (23 - exp);
    }

    printBinary(result, "result");

    result += 1 << exp;

    printBinary(result, "result");

    if (sign) {
        result = -result;
    }

    return result;

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
int floatFloat2Int2(unsigned uf) {
    /*
    I refered to IEEE 754 (lecture slide 2021-2 lect 6) floating structure(?)
    I used how to divide 4 part (s, exp, frac, bias)
    Get the sign, exp, frac, and bias
    Then, compared depending on the conditions (exp is 0xFF, exp is equals 31 or bigger than 31, ... etc)
    */
    unsigned sign = uf >> 31;
    unsigned exp = (uf & 0x7F800000) >> 23;
    unsigned frac = (uf & 0x007FFFFF);
    unsigned bias = 127;
    int result = frac;

    printBinary(uf, "uf");
    printBinary(sign, "sign");
    printBinary(exp, "exp");
    printBinary(frac, "frac");
    printBinary(frac >> 23, "frac >> 23");
    printBinary(frac << 23, "frac << 23");
    printBinary(bias, "bias");
    printBinary(exp & 0x80, "exp & 0x80");

    if ((exp & 0x80) != 0) {
        return 0x80000000u;
    }

    if (exp < bias) {
        return 0x0;
    }

    exp -= bias;
    printBinary(exp, "exp");

    if (exp >= 31) {
        return 0x80000000u;
    }

    if (exp > 22) {
        result = frac << (exp - 23);
    }
    else {
        result = frac >> (23 - exp);
    }

    printBinary(result, "result");

    result += 1 << exp;

    printBinary(result, "result");

    if (sign) {
        result = -result;
    }

    return result;

}
