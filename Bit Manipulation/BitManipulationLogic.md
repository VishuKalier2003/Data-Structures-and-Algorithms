# $${\color{lightblue} Concepts}$$

Here the concepts freqently being used in Bit Manipulation will be covered here, in as much detail as possible. This directory will ensure that the readers are ale to fully understand the concepts and techniques behind Bit Maipulation and Bit Masking.

### ${\color{lightblue} Techniques}$

1. ***Setting the i-th bit to 1*** - O(1)
   
   ```java
   // Left Shift 1 bit i times left and do OR with the bit present their...
   x = x | (1 << i);    // Bit Operation, thus will work on a single bit...
   ```

---

2. ***Setting the i-th bit to 0*** - O(1)
   
   ```java
   // Left Shift in a number, then negate the entire number...
   x = x & ~(1 << n);    // 1 << n creates a new number...
   ```

---

3. ***Flip the i-th bit*** - O(1)
   
   ```java
   // Use XOR to flip only a bit...
   x = x ^ (1 << n);    // Left shift the number...
   ```

---

4. ***Check if i-th Bit is 1 or i-th bit is set*** - O(1)
   
   ```java
   // Bitwise operations can give boolean result, by checking with their garbage values...
   boolean check = x & (1 << n);    // If result evaluates to 1 then true...
   ```

---

5. ***Count number of 1's bit in binary representation*** - O(k)

   ```java
   int count = 0;    // Variable to store count...
   for(; num != 0; num = num >> 1)    // We shift right, divide number by 2 until number becomes 0...
     count += (num & 1) ? 1 : 0;    // If the bit is 1, then increase the count...
   ```

---

6. ***Setting right bits 1*** - O(1)

   ```java
   // Sets the first 1 bit to 0 from right, and all other right bits to 1...
   x = x - 1;
   ```

---

7.  ***Finding Power of Two*** - O(1)

   ```java
  // There should be no common bit between current and previous number...
  boolean power = x && !(x & (x-1));  // The number should not be 0...
  ```

---

8.***
   

   









