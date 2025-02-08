package SegmentTree;

import java.util.*;
import java.io.*;

// Imp - T.C. : O(k log n), S.C. : O(n)

public class LazySegmentTree {
    // Imp - Lazy Segment Tree, where the updates done are stored in a single ancestor node, and when traversed lower, the updates are made, such that updates are made only when the nodes are traversed (unnecessary updation on nodes is pruned)
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

        public int nextInt() {return Integer.parseInt(next());}
    }

    public static class SegmentNode {
        int start, end, book, lazy;
        SegmentNode left, right;

        public static SegmentNode root;

        public SegmentNode() {constructTree();}
        public SegmentNode(int s, int e) {this.start = s; this.end = e; this.book = 0; this.lazy = 0; this.left = null; this.right = null;}

        public void constructTree() {root = createSegmentTree(0, (int)1e9);}        // Imp - Tree construction function

        public SegmentNode createSegmentTree(int s, int e) {
            if(s > e)           // base case, when start more than end
                return null;
            SegmentNode node = new SegmentNode(s, e);       // Create a segment node
            if(s == e)
                node.book = 0;
            else {
                int mid = (s+e) >> 1;       // Division by 2
                node.left = createSegmentTree(s, mid);
                node.right = createSegmentTree(mid+1, e);
                // Perform the updation logic
                node.book = Math.max(node.left.book, node.right.book);
            }
            return node;        // return nodes (in the last call return root)
        }

        public int query(int l, int r) {
            return queryCall(root, l, r);
        }

        public int queryCall(SegmentNode root, int ql, int qr) {
            if(root == null || root.end < ql || root.start > qr)    // No overlap : node segment does not overlap
                return 0;
            if(ql <= root.start && root.end <= qr)      // Total overlap : node segment overlaps with query
                return root.book;
            // Imp - Lazy updation is done only when the query reaches the specific segment, else the updates are stored in the lazy attribute of the node until the control reaches to the lower nodes of the current segment
            lazyUpdation(root);     // Lazy updation done by one immediate level
            // The max book value is taken if 0 then free, else 1 then booked
            return Math.max(queryCall(root.left, ql, qr), queryCall(root.right, ql, qr));
        }

        public void update(int ql, int qr, int val) {
            updateCall(root, ql, qr, val);
        }

        public void updateCall(SegmentNode root, int ql, int qr, int value) {
            if(root == null || root.end < ql || root.start > qr)        // node end less than query start OR node start less more than query end
                return;     // No overlap
            if(ql <= root.start && root.end <= qr) {        // Complete overlap root boundary lies within the query
                root.book = root.lazy = value;
                return;
            }
            // Imp - Lazy updation is done only when the query reaches the specific segment, else the updates are stored in the lazy attribute of the node until the control reaches to the lower nodes of the current segment
            lazyUpdation(root);
            updateCall(root.left, ql, qr, value);
            updateCall(root.right, ql, qr, value);
            root.book = Math.max(root.left.book, root.right.book);
            return;
        }

        public void lazyUpdation(SegmentNode root) {
            if(root.lazy != 0) {    // Transferring the lazy value to the immediate child nodes
                if(root.left != null)       // Transferring to left child if exist
                    root.left.book = root.left.lazy = root.lazy;
                if(root.right != null)      // Transferring to right child if exist
                    root.right.book = root.right.lazy = root.lazy;
            }
            root.lazy = 0;      // Imp - resetting the lazy value
        }
    }

    public static void main(String[] args) {
        List<int[]> queries = new ArrayList<>();
        input: {
            FastReader fastReader = new FastReader();
            int n = fastReader.nextInt();
            for(int i = 0; i < n; i++)
                queries.add(new int[]{fastReader.nextInt(), fastReader.nextInt()});
            break input;
        } output: {
            SegmentNode root = new SegmentNode();
            for(int query[] : queries) {
                int output = root.query(query[0], query[1]);
                if(output == 0)
                    root.update(query[0], query[1], 1);
                System.out.println(output == 1 ? "YES" : "NO");
            }
            break output;
        }
    }
}
