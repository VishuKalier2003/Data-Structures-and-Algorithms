package Math;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(log b), S.C. : O(1)

public class BinaryExponent {
    // Imp - Evaluates a pow b in O(log b) by using Fast Exponentiation
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
            System.out.println(exponentPower(a, b));
            break output;
        }
    }

    public static long exponentPower(long a, long b) {
        // Imp - Computes by bit since ith bit means 2 pow i and then multiply it by the result
        long result = 1l;
        while(b > 0) {
            if((b & 1) == 1)        // Check if LSB is 1 or not
                result *= a;    // Multiply a to the result
            a *= a;
            b >>= 1;    // Divide b by 2 (fast exponentiation)
        }
        return result;
    }
}
