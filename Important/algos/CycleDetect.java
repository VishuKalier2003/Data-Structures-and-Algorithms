import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(stack)

public class CycleDetect {
    // Imp - Used to detect Cycles in both directed and undirected graph
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
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            int n = fastReader.nextInt(), m = fastReader.nextInt();
            for(int i = 1; i <= n; i++)
                graph.put(i, new ArrayList<>());
            for(int i = 0; i < m; i++)
                graph.get(fastReader.nextInt()).add(fastReader.nextInt());
            break input;
        } output: {         // Output segment
            System.out.println(graph);
            System.out.println(detectCycle(1, -1, graph, new boolean[graph.size()+1]) ? "YES" : "NO");
            break output;
        }
    }

    public static boolean detectCycle(int node, int parent, Map<Integer, List<Integer>> graph, boolean visited[]) {
        visited[node] = true;       // Mark current node as visited
        for(int neighbor : graph.get(node)) {
            if(!visited[node])      // If node is not visited
                detectCycle(neighbor, node, graph, visited);    // recurse for next node (update node and parent)
            else return true;   // If visited node reached, a cycle found
        }
        return false;
    }
}
