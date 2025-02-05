import java.io.*;
import java.util.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Kahn {
    // Imp - Performs topological sorting on Graphs to evaluate the dependencies (directed)
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
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int inDegree[];
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            int n = fastReader.nextInt();
            inDegree = new int[n];      // Maintain in degree array while taking input itself
            for(int i = 0; i < n; i++)
                graph.put(i, new ArrayList<>());
            int m = fastReader.nextInt();
            for(int i = 0; i < m; i++) {
                int fromNode = fastReader.nextInt(), toNode = fastReader.nextInt();
                graph.get(fromNode).add(toNode);
                inDegree[toNode]++;     // Update in degree as well
            }
            break input;
        } output: {     // Output segment
            System.out.println(KahnTopologicalSort(graph, inDegree));
            break output;
        }
    }

    public static List<Integer> KahnTopologicalSort(Map<Integer, List<Integer>> graph, int inDegree[]) {
        Queue<Integer> pendantNodes = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++)
            if(inDegree[i] == 0)    // Add nodes into the queue when in degree becomes 0
                pendantNodes.add(i);
        List<Integer> topoNodes = new ArrayList<>();
        while(!pendantNodes.isEmpty()) {
            int node = pendantNodes.poll();
            topoNodes.add(node);        // List to print the nodes sorted in topological order
            for(int neighbor : graph.get(node)) {
                inDegree[neighbor]--;   // Reduce in degree and check if it becomes 0
                if(inDegree[neighbor] == 0)
                    pendantNodes.add(neighbor);     // When becomes 0, add it into the queue
            }
        }
        return topoNodes;       // Return the nodes in topological order
    }
}
