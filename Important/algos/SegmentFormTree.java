package SegmentTree;

import java.util.*;
import java.io.*;

public class SegmentFormTree {
    public static class FastReader {        // Fast Reader for reading inputs (faster than Scanner)
        public BufferedReader buffer;
        public StringTokenizer tokenizer;

        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}   // Constructor

        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try{tokenizer = new StringTokenizer(buffer.readLine());}
                catch(IOException e) {e.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}
    }

    public static class SegmentNode {
        public int start, end, data;
        public SegmentNode left, right;

        public static SegmentNode root;

        public SegmentNode(int s, int e) {this.start = s; this.end = e; this.data = 0; this.left = null; this.right = null;}

        public SegmentNode(int nums[]) {root = constructTree(nums, 0, nums.length-1);}

        public SegmentNode constructTree(int nums[], int s, int e) {
            if(s > e)
                return null;
            SegmentNode segmentNode = new SegmentNode(s, e);
            if(s == e)
                segmentNode.data = nums[s];
            else {
                int mid = (s+e) >> 1;
                segmentNode.left = constructTree(nums, s, mid);
                segmentNode.right = constructTree(nums, mid+1, e);
                segmentNode.data = segmentNode.left.data + segmentNode.right.data;
            }
            return segmentNode;
        }

        public int query(int i, int j) {
            return queryCall(root, i, j);
        }

        public int queryCall(SegmentNode root, int i, int j) {
            if(root == null || i > root.end || j < root.start)      // Base case
                return 0;
            if(i <= root.start && root.end <= j)    // Imp - Node range is smaller or equal to the query range
                return root.data;
            int leftSum = queryCall(root.left, i, j);       // Left subtree
            int rightSum = queryCall(root.right, i, j);     // Right subtree
            return leftSum+rightSum;
        }

        public void update(int index, int value) {
            updateCall(root, index, value);
        }

        public void updateCall(SegmentNode root, int index, int value) {
            if(root.start == root.end) {
                root.data = value;
                return;
            }
            int mid = (root.start+root.end) >> 1;
            if(index <= mid)
                updateCall(root.left, index, value);
            else    updateCall(root.right, index, value);
            root.data = root.left.data + root.right.data;
            return;
        }
    }

    public static void main(String[] args) {
        int nums[];        // Imp: Call array - 1 3 5 7 9 11
        input: {
            FastReader fastReader = new FastReader();
            nums = new int[fastReader.nextInt()];
            for(int i = 0; i < nums.length; i++)
                nums[i] = fastReader.nextInt();
            break input;
        } output: {
            SegmentNode segmentNode = new SegmentNode(nums);
            System.out.println(segmentNode.query(1, 3));
            segmentNode.update(1, 10);
            System.out.println(segmentNode.query(1, 3));
            break output;
        }
    }
}
