package SegmentTree;

import java.util.*;
import java.io.*;

public class SegmentFormArray {
    public static class FastReader {
        public BufferedReader buffer;
        public StringTokenizer tokenizer;

        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {tokenizer = new StringTokenizer(buffer.readLine());}
                catch (IOException e) {e.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}
    }

    public static class SegmentTree {

        private static int tree[];      // Imp : Segment Tree array
        private static int n;

        public SegmentTree(int nums[]) {
            n = nums.length;
            tree = new int[4*n];      // To fill the segment tree
            buildSegmentTree(nums, 0, n-1, 0);      // Creating the segment tree nodes
        }

        public void buildSegmentTree(int nums[], int start, int end, int index) {
            if(start == end) {      // Base case: when node is leaf node
                tree[index] = nums[start];
                return;
            }
            int middle = start + (end-start)/2;
            buildSegmentTree(nums, start, middle, 2*index+1);
            buildSegmentTree(nums, middle+1, end, 2*index+2);
            // Imp - combine query result from left and right children
            tree[index] = tree[2*index+1] + tree[2*index+2];
            return;
        }

        public int query(int qs, int qe) {
            if(qs < 0 || qe > n-1 || qe < qs)
                throw new IllegalArgumentException("Illegal Query Range");
            return queryCall(0, n-1, qs, qe, 0);        // Imp - Query call on entire segment tree
        }

        public int queryCall(int ss, int se, int qs, int qe, int index) {
            if(qs <= ss && se <= qe)        // Complete overlap (segment range lies inclusively within query range)
                return tree[index];
            if(se < qs || ss > qe)          // No overlap (segment lies completely outside the query range)
                return 0;
            int middle = ss + (se-ss)/2;
            int leftSum = queryCall(ss, middle, qs, qe, 2*index+1);     // Query call on Left subtree
            int rightSum = queryCall(middle+1, se, qs, qe, 2*index+2);  // Query call on Right subtree
            return leftSum+rightSum;
        }

        public void update(int i, int newValue) {
            if(i < 0 || i > n-1)
                throw new IllegalArgumentException("Incorrect update index !!");
            updateCall(0, n-1, i, newValue, 0);     // Imp - Update call on entire segment tree
        }

        public void updateCall(int ss, int se, int i, int newValue, int index) {
            if(i < ss || i > se)    // Imp - If update index is out of current segment
                return;
            if(ss == se) {      // If leaf node is reached, update it
                tree[index] = newValue;
                return;     // update and backtrack
            }
            int middle = ss + (se-ss)/2;
            updateCall(ss, middle, i, newValue, 2*index+1);     // Left subtree recurse
            updateCall(middle+1, se, i, newValue, 2*index+2);   // Right subtree recurse
            // Imp - Sum querying
            tree[index] = tree[2*index+1] + tree[2*index+2];
            return;
        }
    }

    public static void main(String[] args) {
        int nodes[];        // Imp: Call array - 1 3 5 7 9 11
        input: {
            FastReader fastReader = new FastReader();
            nodes = new int[fastReader.nextInt()];      // Length of the array
            for(int i = 0; i < nodes.length; i++)       // Array of the elements
                nodes[i] = fastReader.nextInt();
            break input;
        }
        output: {
            SegmentTree segmentTree = new SegmentTree(nodes);
            System.out.println(segmentTree.query(1, 3));
            break output;
        }
    }
}
