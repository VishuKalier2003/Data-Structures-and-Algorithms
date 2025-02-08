package Tree;

import java.io.*;
import java.util.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class BFS {
    // Imp - Performs breadth first search on a graph or a tree to evaluate states quickly
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

        public String nextLine() {  // Next line function to accept string with whitespaces
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

    public static TreeNode deserialize(String text) {
        String nodes[] = text.trim().split(" ");
        return deserializeHelper(new LinkedList<>(Arrays.asList(nodes)));
    }

    // Imp - Perform Pre-order traversal to get the deserialized binary tree
    public static TreeNode deserializeHelper(Queue<String> nodes) {
        String token = nodes.poll();        // Poll the string token node value
        if(token.equals("null"))
            return null;    // When null backtrack
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    public static void main(String[] args) {
        String text;
        TreeNode root;
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            text = fastReader.nextLine();
            break input;
        } output: {     // Output segment
            root = deserialize(text);
            System.out.println(bfs(root));
            break output;
        }
    }

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();        // List of nodes as output
        Queue<TreeNode> queue = new LinkedList<>();     // Queue for processing nodes
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes.add(node.data);
                if(node.left != null)       // If node left exists
                    queue.add(node.left);
                if(node.right != null)      // If node right exists
                    queue.add(node.right);
            }
        }
        return nodes;       // nodes returned as arraylist
    }
}
