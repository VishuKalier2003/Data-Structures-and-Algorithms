# $${\color{lightblue} Concepts}$$

Here the concepts freqently being used in Bit Manipulation will be covered here, in as much detail as possible. This directory will ensure that the readers are ale to fully understand the concepts and techniques behind Bit Maipulation and Bit Masking.

### ${\color{lightblue} Techniques}$

#### ${\color{lightblue} Formulae}$

1. ***Setting the i-th bit to 1*** - ${O(1)}$
   
   ```java
   // Left Shift 1 bit i times left and do OR with the bit present their...
   x = x | (1 << i);    // Bit Operation, thus will work on a single bit...
   ```

---

2. ***Setting the i-th bit to 0*** - ${O(1)}$
   
   ```java
   // Left Shift in a number, then negate the entire number...
   x = x & ~(1 << n);    // 1 << n creates a new number...
   ```

---

3. ***Flip the i-th bit*** - ${O(1)}$
   
   ```java
   // Use XOR to flip only a bit...
   x = x ^ (1 << n);    // Left shift the number...
   ```

---

4. ***Check if i-th Bit is 1 or i-th bit is set*** - ${O(1)}$
   
   ```java
   // Bitwise operations can give boolean result, by checking with their garbage values...
   boolean check = x & (1 << n);    // If result evaluates to 1 then true...
   ```

---

5. ***Count number of 1's bit in binary representation*** - ${O(log n)}$

   ```java
   int count = Integer.bitCount(x);    // In-built function to count the number of bits to 1...
   ```

---

6. ***Decrease*** - ${O(1)}$

   ```java
   // Sets the rightmost 1 bit to 0, and all other right bits to 1...
   x = x - 1;
   ```

---

7.  ***Finding Power of Two*** - ${O(1)}$

   ```java
  // There should be no common bit between current and previous number...
  boolean power = x && !(x & (x-1));  // The number should not be 0...
  ```

---

8.***Turn Off Rightmost 1 bit*** - ${O(1)}$

```java
// x-1 makes the rightmost bit to 0, and other right bits to 1...
x = x & (x-1);      // Then use AND operation to terminate the rightmost bit...
```

---

9.***Extract LSB (Least Significant Bit)*** - ${O(1)}$

```java
// The negative number has all bits inverted and 1 added to them...
int bit = x & -x;   // The values left to rightmost 1 bit are complementary, to set 0 use AND...
```

10.***Extract MSB (Most Significant Bit)*** - ${O(1)}$

```java
int bit = Integer.highestOneBit(x);      // Java in-built function...
```

---

11.***Multiply and Divide by n*** - ${O(1)}$

```java
x = x << n;   // Multiply by n...
x = x >> n;   // Divide by n...
```

---

12.***Finding index of LSB and MSB*** - ${O(1)$

```java
int lsb = (int)(Math.log(x & -x)/Math.log(2));   // Find lsb and take its log base 2 value...
int msb = (int)(Math.log(Integer.highestOneBit(x)/Math.log(2));      // Find msb and take its log base 2 value...
```

---

13.***Reverse Bits*** - ${O(n)}$

```java
int newX = Integer.reverse(x);      // In-built reverse function...
```

---

14.***Invert Bits*** - ${O(log n)}$

```java
x = ~x;   // Invert the bits...
```

---

15.***Check if Two Numbers have opposite sign*** - ${O(1)}$

```java
boolean opposite = (x ^ y) < 0;
```

---

#### ${\color{lightblue} Algorithm \space use}$

1.***Check Bits Parity*** - ${O(log n)}$

```java
int parity = 0;      // Set parity bit to 0...
for(; num != 0; num = num >> 1)      // Reducing number by 2, till it becomes 0...
   if(num & 1)      // If the LSB is 1...
      parity = ~parity;      // Invert the parity, 0 for odd and 1 for even...
```

---

2.***Check If Alternating 1s and 0s*** - ${O(log n)}$

```java
int parity = 1;      // Setting a parity checker bit...
for(; num != 0; num = num >> 1) {      // Extracting bits from LSB side...
   if(!((num & 1) & parity))      // If the operation results to 0, then previous and current bits are alternating...
      parity = ~parity;         // Update the parity bit...
   else return false;            // Return false otherwise...
}
return true;      // Return true, when entire number is checked...
```

---

3.***Get Subsets*** - ${O(2^n)}$

```java
int n = list.size();      // Getting size of the elements...
for(int i = 0; i < Math.pow(2, n); i++) {      // There will be 2^n subsets...
   int j = n, num = i;
   for(; num != 0; num = num >> 1, j--)      // Selecting the LSB and its corresponding index...
      if(num & 1)      // If the current bit is to be selected...
         System.out.print(list.get(j-1)+" ");      // Perform the operation...
   System.out.println();
}
```

---

4.***Rotate Bits to Left*** - ${O(log n)}$

```java
// Shift x by n bits left, and right shift it...
x = (x << n) | (x >> (32 - n));
```

---

5.***Rotate Bits to Right*** - ${O(log n)}$

```java
// Shift x by n bits right, and left shift it...
x = (x >> n) | (x << (32 - n));
```


   









