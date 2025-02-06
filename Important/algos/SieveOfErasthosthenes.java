package Math;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(n log log n), S.C. : O(n)

public class SieveOfErasthosthenes {
    // Imp - Mark the non-primes and primes till a number n in optimal time complexity
    public static class FastReader {    // Fast Reader class to read inputs quickly (4x faster than Scanner)
        BufferedReader buffer;
        StringTokenizer tokenizer;

        // Constructor defined for calling Buffer
        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}

        public String next() {  // Reads data differently when separated by space
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try{tokenizer = new StringTokenizer(buffer.readLine());}
                catch(IOException error) {error.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}     // Convert string to int
        public long nextLong() {return Long.parseLong(next());}     // Convert string to long
    }
    public static void main(String[] args) {
        int n;
        input: {
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt();
            break input;
        } output: {
            sieveOfErasthosthenes(n);
            System.out.println(Arrays.toString(sieve));
            break output;
        }
    }

    public static boolean sieve[];

    public static void sieveOfErasthosthenes(int n) {
        sieve = new boolean[n+1];
        Arrays.fill(sieve, true);      // Mark all numbers as prime initially
        sieve[0] = sieve[1] = false;    // Sieve set up
        for(int i = 2; i < n/2; i++) {
            if(sieve[i]) {  // Once current marked as non-prime
                for(int j = i*i; j <= n; j += i)    // Start from 2*i and reach with 3*i, 4*i till n
                    sieve[i] = false;      // Mark as not prime
            }
        }
    }
}
