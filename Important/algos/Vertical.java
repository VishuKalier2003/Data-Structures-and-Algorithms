package Tree;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Vertical {
    // Imp - Pass vertical rays as Y coordinate to store the nodes which arrive at same vertical ray
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
            try {tokenizer = null; builder.append(buffer.readLine());}
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
        String tokens[] = text.trim().split(" ");       // Split text by whitespace
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
            Map<Integer, List<Integer>> map = new LinkedHashMap<>();
            verticalRays(root, 0, map);
            System.out.println(map);
            break output;
        }
    }

    public static void verticalRays(TreeNode root, int ray, Map<Integer, List<Integer>> rayMap) {
        if(root == null)
            return;
        rayMap.putIfAbsent(ray, new ArrayList<>());     // Put root data as key if absent
        rayMap.get(ray).add(root.data);
        if(root.left != null)       // Decrease y coordinate by 1 when moving left
            verticalRays(root.left, ray-1, rayMap);
        if(root.right != null)      // Increase y coordinate by 1 when moving right
            verticalRays(root.right, ray+1, rayMap);
        return;
    }
}
