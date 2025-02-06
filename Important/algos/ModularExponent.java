package Math;

import java.io.*;
import java.util.*;

// Imp - T.C. : O(log b), S.C. : O(1)

public class ModularExponent {
    // Imp - Evaluates a pow b in O(log b) by using Fast Exponentiation with modulo value (when numbers become very large)
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
        long a, b;
        input: {
            FastReader fastReader = new FastReader();
            a = fastReader.nextLong(); b = fastReader.nextLong();
            break input;
        } output: {
            System.out.println(modularExpo(a, b));
            break output;
        }
    }

    public static final int MOD = 1_000_000_007;

    public static long modularExpo(long a, long b) {
        // Imp - Computes by bit since ith bit means 2 pow i and then multiply it by the result
        long result = 1L;
        a %= MOD;       // Modulo arithmetic
        while(b > 0) {
            if((b & 1) == 1)    // If LSB is 1 or not
                result = (result * a) % MOD;    // Perform fast exponentiation with modulo arithmetic
            a = (a * a) % MOD;      // Perform modulo
            b >>= 1;        // Divide the number by 2
        }
        return result;
    }
}
