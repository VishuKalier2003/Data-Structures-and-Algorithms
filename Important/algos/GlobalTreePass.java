package Tree;

import java.io.*;
import java.util.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class GlobalTreePass {
    // Imp - global data of the node stored in array and passed along the recursion
    public static class FastReader {
        BufferedReader buffer;
        StringTokenizer tokenizer;

        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}

        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {tokenizer = new StringTokenizer(buffer.readLine());}
                catch(IOException e) {e.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            StringBuilder builder = new StringBuilder();
            try {
                tokenizer = null;
                builder.append(buffer.readLine());
            }
            catch(IOException e) {e.printStackTrace();}
            return builder.toString();
        }

        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
    }

    public static class TreeNode {
        int data; TreeNode left, right;
        public TreeNode(int data) {this.data = data; this.left = null; this.right = null;}
    }

    public static TreeNode deserialize(String text) {
        String tokens[] = text.trim().split(" ");
        return deserializeHelper(new LinkedList<String>(Arrays.asList(tokens)));
    }

    public static TreeNode deserializeHelper(Queue<String> queue) {
        String token = queue.poll();
        if(token.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root;
        input: {
            FastReader fastReader = new FastReader();
            root = deserialize(fastReader.nextLine());
            break input;
        } output: {
            int diameter[] = new int[1];
            System.out.println(globalPostOrder(root, diameter));
            break output;
        }
    }

    public static int globalPostOrder(TreeNode root, int diameter[]) {
        if(root == null)        // Base case
            return 0;
        int left = globalPostOrder(root.left, diameter);        // Left recursion
        int right = globalPostOrder(root.right, diameter);      // Right recursion
        // Imp - global variable update and is passed as reference through the entire tree
        diameter[0] = Math.max(diameter[0], left+right+1);
        return Math.max(left, right)+1;     // Max diameter taken
    }
}
