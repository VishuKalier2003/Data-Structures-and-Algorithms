import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Tarjan {
    // Imp - Used to find Strongly Connected Components or Critical Connections in a Graph (both directed and undirected)
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
        int n;
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt();
            for(int i = 1; i <= n; i++)
                graph.put(i, new ArrayList<>());
            int m = fastReader.nextInt();
            for(int j = 0; j < m; j++) {
                int node1 = fastReader.nextInt(), node2 = fastReader.nextInt();
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            break input;
        } output: {     // Output segment
            System.out.println(criticalConnections(graph, 1, n));
            System.out.println(criticalEdges);
            break output;
        }
    }

    public static List<List<Integer>> criticalEdges = new ArrayList<>();        // List to store critical connections

    public static int criticalConnections(Map<Integer, List<Integer>> graph, int root, int n) {
        // Discovery array to store the discovery time of each node, and low link to store the lowest link time of each node with its neighbors
        int discovery[] = new int[n+1], lowLink[] = new int[n+1];
        Arrays.fill(discovery, -1);
        Arrays.fill(lowLink, -1);
        tarjanDfs(graph, root, -1, discovery, lowLink, 0, new boolean[n+1]);        // Tarjan's Algorithm
        return criticalEdges.size();
    }

    public static int tarjanDfs(Map<Integer, List<Integer>> graph, int root, int parent, int discovery[], int lowLink[], int time, boolean visited[]) {
        visited[root] = true;           // Mark root visited
        // Set the root discovery and lowLink time
        discovery[root] = time;
        lowLink[root] = time;
        int link = Integer.MAX_VALUE;   // Create a link variable to maintain the lowest link and discovery time
        for(int child : graph.get(root)) {
            // Post order child while not visited nor parent
            if(!visited[child] && child != parent) {
                int childLink = tarjanDfs(graph, child, root, discovery, lowLink, time+1, visited);
                link = Math.min(link, childLink);       // Update link
                // If lowest link of child is greater than discovery of root, then its a critical connection
                if(childLink > discovery[root])
                    criticalEdges.add(Arrays.asList(root, child));
            }
            else if(child != parent)    // Update link with discovery when child node not a parent
                link = Math.min(link, discovery[child]);
        }
        return lowLink[root] = link;        // Update low link of root with the link value
    }
}
