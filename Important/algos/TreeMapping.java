package Tree;

import java.io.*;
import java.util.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class TreeMapping {
    // Imp - Tree conversion to graph, such that the Data Structure now behaves both as tree and graph and can be used for many operations
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

    public static TreeNode deserialize(String text) {       // Deserialize string into queue data
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
        Map<TreeNode, List<TreeNode>> graph = new LinkedHashMap<>();    // LinkedHashMap called to preserve order
        input: {
            FastReader fastReader = new FastReader();
            text = fastReader.nextLine();
            break input;
        } output: {
            root = deserialize(text);
            treeMapping(root, null, graph);
            // Imp: Caller string - 1 2 4 null null 5 null null 3 6 null null 7 null null
            print(graph);
            break output;
        }
    }

    // Imp - This logic create graph over the tree, with maintaining the left and right children as well
    public static void treeMapping(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if(root == null)    // Base case to backtrack
            return;
        if(parent != null) {        // If parent is not null, add into the required key
            graph.putIfAbsent(root, new ArrayList<>());
            graph.get(root).add(parent);
        }
        if(root.left != null) {     // If left child is not null, add into the required key
            graph.putIfAbsent(root, new ArrayList<>());
            graph.get(root).add(root.left);
            treeMapping(root.left, root, graph);    // Recursive left subtree call
        }
        if(root.right != null) {    // If right child is not null, add into the required key
            graph.putIfAbsent(root, new ArrayList<>());
            graph.get(root).add(root.right);
            treeMapping(root.right, root, graph);       // Recursive right subtree call
        }
    }

    public static void print(Map<TreeNode, List<TreeNode>> graph) {
        for(Map.Entry<TreeNode, List<TreeNode>> entry : graph.entrySet()) {
            System.out.print(entry.getKey().data+" -> ");
            for(TreeNode node : entry.getValue())
                System.out.print(node.data+" ");
            System.out.println();
        }
    }
}
