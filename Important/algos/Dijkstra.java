import java.util.*;
import java.io.*;

// Imp - T.C. : O(n log n), S.C. : O(n)

public class Dijkstra {
    // Imp - Evaluate the min distance from a given node to all nodes
    public record Pair(int node, int dist) {}   // Record defined for final variables of node and distance

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
    public static void main(String args[]) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        input: {
            FastReader fastReader = new FastReader();
            int n = fastReader.nextInt(), m = fastReader.nextInt();
            for(int i = 1; i <= n; i++)
                graph.put(i, new ArrayList<>());
            for(int i = 0; i < m; i++) {
                int n1 = fastReader.nextInt(), n2 = fastReader.nextInt(), w = fastReader.nextInt();
                // Adjacency list of undirected graph where node consist of weights
                graph.get(n2).add(new int[]{n1, w});
                graph.get(n1).add(new int[]{n2, w});
            }
            break input;
        } output: {
            dijkstraAlgorithm(graph);
            break output;
        }
    }

    public static void dijkstraAlgorithm(Map<Integer, List<int[]>> graph) {
        int distance[] = new int[graph.size()+1];       // Create a distance array of size +1
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Create min Heap of property where the smaller element of 1st index(b) (0 indexing) are given priority
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        distance[1] = 0;
        minHeap.add(new int[]{1, 0});   // First param as node, second param as weight
        while(!minHeap.isEmpty()) {
            int[] dataNode = minHeap.poll();
            int node = dataNode[0], weight = dataNode[1];
            if(weight > distance[node])     // If weight becomes more than node, skip it
                continue;
            for(int neighbor[] : graph.get(node)) {
                // Check if node path weight (calculated till now) and current weight lower than the previous node path weight
                if(distance[node] + neighbor[1] < distance[neighbor[0]]) {
                    distance[neighbor[0]] = distance[node] + neighbor[1];   // Add the distance together (update it)
                    minHeap.add(new int[]{neighbor[0], distance[neighbor[0]]});     // Put it in the heap
                }
            }
        }
        System.out.println(Arrays.toString(distance));      // Return the distance
    }
}
