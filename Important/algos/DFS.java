package Tree;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class DFS {
    // Imp - Perform Depth First Search (DFS) the 
    public static class FastReader {
        public BufferedReader buffer;
        public StringTokenizer tokenizer;

        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}

        public String next() {      // Next word
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try{tokenizer = new StringTokenizer(buffer.readLine());}
                catch(IOException e) {e.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {  // Next line to accept string with whitespaces
            StringBuilder builder = new StringBuilder();
            try {tokenizer = null; builder.append(buffer.readLine());}
            catch(IOException e) {e.printStackTrace();}
            return builder.toString();
        }

        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
    }

    public static class TreeNode {      // Class TreeNode for storing node properties
        int data;
        TreeNode left, right;

        // Parametrized Constructor
        public TreeNode(int data) {this.data = data; this.left = null; this.right = null;}
    }

    public static TreeNode deserialize(String string) {
        String nodes[] = string.split(" "); // Split string on basis of white spaces
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    // Imp - create the serialized tree via pre-order
    public static TreeNode deserializeHelper(Queue<String> queue) {
        String token = queue.poll();
        if(token.equals("null"))    // Backtrack when found null
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeHelper(queue);       // First left
        node.right = deserializeHelper(queue);      // Then right
        return node;
    }
    public static void main(String[] args) {
        String serialized;
        TreeNode root;
        input: {        // Input block
            FastReader fastReader = new FastReader();
            serialized = fastReader.nextLine().trim();
            break input;
        } output: {     // Output block
            root = deserialize(serialized);
            preOrder(root);
            break output;
        }
    }

    public static void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}
