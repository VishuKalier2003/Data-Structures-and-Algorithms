# $${\color{lightblue} Concepts}$$

Here the concepts freqently being used in Bit Manipulation will be covered here, in as much detail as possible. This directory will ensure that the readers are ale to fully understand the concepts and techniques behind Bit Maipulation and Bit Masking.

### ${\color{lightblue} Techniques}$

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
   int count = 0;    // Variable to store count...
   for(; num != 0; num = num >> 1)    // We shift right, divide number by 2 until number becomes 0...
     count += (num & 1) ? 1 : 0;    // If the bit is 1, then increase the count...
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

9.***Extract Rightmost 1 bit*** - ${O(1)}$

```java
// The negative number has all bits inverted and 1 added to them...
int bit = x & -x;   // The values left to rightmost 1 bit are complementary, to set 0 use AND...
```

---

10.***Multiply and Divide by n*** - ${O(1)}$

```java
x = x << n;   // Multiply by n...
x = x >> n;   // Divide by n...
```

---

11.***Check Bits Parity*** - ${O(log n)}$

```java
int parity = 0;      // Set parity bit to 0...
for(; num != 0; num = num >> 1)      // Reducing number by 2, till it becomes 0...
   if(num & 1)      // If the LSB is 1...
      parity = ~parity;      // Invert the parity, 0 for odd and 1 for even...
```

---

12.***Reverse Bits*** - ${O(n)}$

```java
String reverse = "";      // String to store reverse number...
for(; num != 0; num = num >> 1)      // Extracting the LSB bits iteratively...
   reverse = reverse + (num & 1);      // Extract the LSB and it to the number...
```

---

13.***Update the Rightmost 0 bit*** - ${O(1)}$

```java
// x+1 changes the rightmost 0 bit to 1...
x = x | (x+1);      // Use OR operation to only update the rightmost bit...
```

---

14.***Invert Bits*** - ${O(log n)}$

```java
x = ~x;   // Invert the bits...
```

---

15.***Check If Alternating 1s and 0s*** - ${O(log n)}$

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

16.***Get Subsets*** - ${O(2^n)}$

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

17.***Increase*** - ${O(1)}$

```java
x = x + 1;      // Changes the rightmost 0 bit to 1...
```

---

18.***From MSB to i clear all bits*** - ${O(1)}$

```java
// left shifting to reach the index and then doing -1 to get all right bits to 1...
x = x & ((1 << i) - 1);   // Then use the AND operation, to clear the bits...
```

---

19.***From LSB to i clear all bits*** - ${O(1)}$

```java
// Left shift to reach the index and then doing -1 to get all right bits to 1...
x = x & ~((1 << i) - 1);   // Negating to get all left bits to 1 and right bits to 0...
```

---

20.***Position of Lowest Set Bit*** - ${O(log n)}$

```java
int index = 0;
for(; num != 0; num = num >> 1, index++)
   if(num & 1)   break;
```

---

21.***Check if Two Numbers have opposite sign*** - ${O(1)}$

```java
boolean opposite = (x ^ y) < 0;
```

---

22.***Count Trailing Zeros*** - ${O(log n)}$

```java
int count = 0;   // variable to store count...
for(; num != 0 && ~(num & 1); num = num >> 1, count++);
// Counting number of 0s from the right...
```

---

23.***Rotate Bits to Left*** - ${O(log n)}$

```java
// Shift x by n bits left, and right shift it...
x = (x << n) | (x >> (32 - n));
```

---

24.***Rotate Bits to Right*** - ${O(log n)}$

```java
// Shift x by n bits right, and left shift it...
x = (x >> n) | (x << (32 - n));
```

---

25.***Get LSB n bits*** - ${O(1)}$

```java
int mask = (1 << n) - 1;   // Left Shift and subtract to set all LSB n bits to 1...
int result = x & mask;      // Then extract the mask using AND...
```

---

   









