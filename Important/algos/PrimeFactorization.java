package Math;

import java.io.*;
import java.util.*;

// Imp - T.C. : O(sqrt(n)), S.C. : O(sqrt(n))

public class PrimeFactorization {
    // Imp - Evaluates Prime Factors of a number n optimally for even large bounds running up to sqrt(n)
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
        input: {        // Input block
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt();
            break input;
        } output: {     // Output block
            System.out.println(primeFactors(n));
            break output;
        }
    }

    public static Map<Integer, Integer> primeFactors(int n) {
        Map<Integer, Integer> factorMap = new LinkedHashMap<>();    // LinkedHashMap to preserve order of insertion
        for(int i = 2; i*i <= n; i++)       // Run till sqrt(n) since prime factors will lie within that bound
            while(n % i == 0) {     // Reduce n till possible by division
                factorMap.put(i, factorMap.getOrDefault(i, 0)+1);
                n /= i;
            }
        if(n > 1)   // If n is still greater than 1, then n is a prime number itself larger than sqrt(n)
            factorMap.put(n, factorMap.getOrDefault(n, 0)+1);
        return factorMap;
    }
}
