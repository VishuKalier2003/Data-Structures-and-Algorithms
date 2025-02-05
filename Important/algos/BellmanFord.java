import java.util.*;
import java.io.*;

// Imp - T.C. : O(n ^ 2), S.C. : O(n)

public class BellmanFord {
    // Imp - Used to find the shortest path to all nodes from source node with negative weights and cycle graphs by slow Relaxation
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

    public record Edge(int node1, int node2, int weight) {}
    public static void main(String args[]) {
        Edge edges[];
        FastReader fastReader = new FastReader();
        input: {
            edges = new Edge[fastReader.nextInt()];
            for(int i = 0; i < edges.length; i++)
                edges[i] = new Edge(fastReader.nextInt(), fastReader.nextInt(), fastReader.nextInt());
            break input;
        } output: {
            System.out.println(bellmanFordAlgorithm(edges, fastReader.nextInt()) ? "YES negative cycles" : "NO");
            break output;
        }
    }

    public static boolean bellmanFordAlgorithm(Edge edges[], int source) {
        int n = edges.length;
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for(int i = 0; i < n; i++)  // Weight Relaxation with n iterations
            for(Edge edge : edges) {
                // Relax weight (if the distance can be made shorted make it shorter)
                if(dist[edge.node1] != Integer.MAX_VALUE && dist[edge.node1] + edge.weight < dist[edge.node2])
                    dist[edge.node2] = dist[edge.node1] + edge.weight;
            }
        for(Edge edge : edges)      // If further weight relaxation can be done, then a negative weight is present
            if(dist[edge.node1] != Integer.MAX_VALUE && dist[edge.node1] + edge.weight < dist[edge.node2])
                return true; // Negative weight cycle exists
        return false;
    }
}
