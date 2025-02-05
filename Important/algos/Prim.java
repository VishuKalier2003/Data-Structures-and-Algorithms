import java.util.*;
import java.io.*;

// Imp - T.C. : O(n log n), S.C. : O(n)

public class Prim {
    // Imp - Generates a Minimum Spanning Tree (MST) of both undirected and directed Graph with minimum weights
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
    }

    public record Edge(int node1, int node2, int weight) {}     // Record class defined for final variables of an edge
    public static void main(String[] args) {
        Edge edges[];
        int n;
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt();       // Imp: First Input as number of vertices
            edges = new Edge[fastReader.nextInt()];     // Imp: next input as number of nodes
            for(int i = 0; i < edges.length; i++)
                edges[i] = new Edge(fastReader.nextInt(), fastReader.nextInt(), fastReader.nextInt());
            break input;
        } output: {     // Output segment
            print(minimumSpanningTree(edges, n));
            break output;
        }
    }

    public static Map<Integer, List<int[]>> minimumSpanningTree(Edge edges[], int n) {
        Map<Integer, List<int[]>> spanningTree = new HashMap<>();   // Map to store the spanning tree
        for(int i = 1; i <= n; i++)
            spanningTree.put(i, new ArrayList<>());
        // Priority Queue defined for the Edge -> lambda function compression logic (comparing by weights)
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((Edge e1, Edge e2) -> Integer.compare(e1.weight, e2.weight));
        for(Edge edge : edges)
            minHeap.add(edge);
        Set<Integer> taken = new HashSet<>();   // Set of taken nodes
        taken.add(1);       // Start from arbitrary nodes
        while(!minHeap.isEmpty()) {
            Edge edgeNode = minHeap.poll();
            int start = edgeNode.node1, end = edgeNode.node2, weight = edgeNode.weight;
            if(taken.contains(start) && !taken.contains(end)) {     // If end node is not present in MST
                taken.add(end);
                spanningTree.get(start).add(new int[]{end, weight});
                spanningTree.get(end).add(new int[]{start, weight});
            } else if(!taken.contains(start) && taken.contains(end)) {      // If start node is not present in MST
                taken.add(start);
                spanningTree.get(start).add(new int[]{end, weight});
                spanningTree.get(end).add(new int[]{start, weight});
            }
        }
        return spanningTree;
    }

    public static void print(Map<Integer, List<int[]>> mst) {
        for(Map.Entry<Integer, List<int[]>> entry : mst.entrySet()) {
            System.out.print(entry.getKey()+" -> ");
            List<int[]> list = entry.getValue();
            for(int[] arr : list)
                System.out.print(Arrays.toString(arr));
            System.out.println();
        }
    }
}
