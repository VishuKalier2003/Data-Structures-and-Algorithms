package Math;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(log b), S.C. : O(stack)

public class GCD {
    // Imp - Evaluate GCD and LCM of prime numbers optimally
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
        int a, b;
        input: {
            FastReader fastReader = new FastReader();
            a = fastReader.nextInt(); b = fastReader.nextInt();
            break input;
        } output: {
            System.out.println("GCD : "+gcd(a, b)+" LCM : "+lcm(a, b));
            break output;
        }
    }

    public static int gcd(int a, int b) {       // Evaluate GCD
        // When the b becomes 0, then a is the GCD
        return b == 0 ? a : gcd(b, a % b);      // Reduce b by the remainder
    }

    public static int lcm(int a, int b) {
        return (a/gcd(a, b)) * b;   // Evaluate LCM x GCD = a x b
    }
}
