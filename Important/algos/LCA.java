package Tree;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(k x n), S.C. : O(n)

public class LCA {
    // Imp - Evaluates Least Common Ancestor (LCA) of k nodes by using a map to find the common ancestor
    public static class FastReader {
        public BufferedReader buffer;
        public StringTokenizer tokenizer;

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
            try {tokenizer = null; builder.append(buffer.readLine());}
            catch(IOException e) {e.printStackTrace();}
            return builder.toString();
        }
    }

    public static class TreeNode {
        int data; TreeNode left, right;

        public TreeNode(int data) {this.data = data; this.left = null; this.right = null;}
    }

    public static TreeNode deserializer(String text) {
        String nodes[] = text.trim().split(" ");
        return deserializeHelper(new LinkedList<>(Arrays.asList(nodes)));
    }

    public static TreeNode deserializeHelper(Queue<String> queue) {
        String token = queue.poll();
        if(token.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(token));
        if(token.equals("4"))
            testNodes.add(root);
        if(token.equals("2"))
            testNodes.add(root);
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }

    public static List<TreeNode> testNodes;

    public static int ancestorNode = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Map<TreeNode, Integer> map = new LinkedHashMap<>();
        TreeNode root;
        input: {
            FastReader fastReader = new FastReader();
            root = deserializer(fastReader.nextLine());
            break input;
        } output: {
            // Imp: Caller string - 1 2 4 null null 5 null null 3 6 null null 7 null null
            for(int i = 0; i < testNodes.size(); i++)       // Finding LCA of n nodes
                lowestCommonAncestor(root, testNodes.get(i), i, map);
            System.out.println(ancestorNode);
            break output;
        }
    }

    public static int lowestCommonAncestor(TreeNode root, TreeNode node, int shift, Map<TreeNode, Integer> map) {
        if(root == null)
            return 0;
        map.putIfAbsent(root, 0);
        int left = lowestCommonAncestor(root.left, node, shift, map);        // Left subtree
        int right = lowestCommonAncestor(root.right, node, shift, map);       // Right subtree
        // Use post order to start updating the map from the leaves
        if(root == node) {
            // Imp - The Map will be updated as the bitmask shift by ith position (meaning ith node is found)
            map.put(root, map.get(root) + (1 << shift));
            if(map.get(root) == 3 && ancestorNode == Integer.MAX_VALUE)
            ancestorNode = root.data;
            return 1 << shift;
        }
        map.put(root, map.get(root)+left+right);    // Imp - Update the map, since the bitmask will be passed to the parent
        if(map.get(root) == 3 && ancestorNode == Integer.MAX_VALUE)     // Check for intersection node
            ancestorNode = root.data;
        return left+right;
    }
}
