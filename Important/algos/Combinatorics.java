package Math;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Combinatorics {
    // Imp - Fast nCr evaluation using factorial and inverse factorial with fermat's theorem in linear time
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
        int n, r;
        input: {    // Input Segment
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt(); r = fastReader.nextInt();
            break input;
        } output: {     // Output Segment
            preCompute();
            System.out.println(nCr(n, r));      // Function call
            System.out.println(nPr(n, r));      // Function call
            break output;
        }
    }

    public static final int MAX = 1_000_000, MOD = 1_000_000_007;
    public static long fact[] = new long[MAX+1], invFact[] = new long[MAX+1];

    public static long nCr(int n, int r) {
        if(r < 0 || r > n)  return 0;
        // Calling the mathematical formula with factorial and inverse factorial pre-computations
        return (((fact[n] * invFact[r]) % MOD) * invFact[n-r]) % MOD;
    }

    public static long nPr(int n, int r) {
        if(r < 0 || r > n)  return 0;
        // Calculating the mathematical formula with factorial and inverse factorial pre-computations
        return (fact[n] * invFact[n-r]) % MOD;
    }

    public static void preCompute() {
        fact[0] = invFact[0] = 1;
        for(int i = 1; i <= MAX; i++)   // Computes factorial
            fact[i] = (fact[i-1] * i) % MOD;
        invFact[MAX] = modInverseFermatTheorem(fact[MAX]);
        for(int i = MAX-1; i >= 1; i--)     // And computes inverse factorial for division operation
            invFact[i] = (invFact[i+1] * (i+1)) % MOD;
    }

    public static long fastModularExponentiation(long a, long b) {
        long result = 1L;
        a %= MOD;
        while(b > 0) {  // Fast Modular exponentiation evaluation
            if((b & 1) == 1)    // Imp - for even
                result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;        // Right shifting
        }
        return result;
    }

    // Imp - Compute Modular Inverse using fermat's theorem (where MOD must be prime)
    public static long modInverseFermatTheorem(long a) {
        // Use technique a^-1 mod p = a^p-2 mod p
        return fastModularExponentiation(a, MOD-2);     // MOD must be prime
    }
}
