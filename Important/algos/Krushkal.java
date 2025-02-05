import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Krushkal {
    // Imp - Creates the Disjoint Set Union (DSU) of the graph to find Connected Components
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

    public static class DSU {       // Disjoint Set Union Class
        int parent[], rank[];

        public DSU(int n) {
            this.parent = new int[n]; this.rank = new int[n];
            for(int i = 0; i < parent.length; i++)
                parent[i] = i;      // Set the parent array values as the index (in start each node is itself a component)
        }

        public int find(int x) {
            if(parent[x] != x)      // Recursively find a parent
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);       // Union two nodes into a single component
            if(rootX == rootY)  return false;
            else {  // Apply path compression to add smaller component into the larger component based on their ranks and update their parents
                if(rank[rootX] < rank[rootY])   // If rootX rank is smaller
                    parent[rootX] = rootY;
                else if(rank[rootY] < rank[rootX])      // If rootX rank is larger
                    parent[rootY] = rootX;
                else {      // When equal
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        input: {        // Input segment
            FastReader fastReader = new FastReader();
            int n = fastReader.nextInt();
            for(int i = 1; i <= n; i++)
                graph.put(i, new ArrayList<>());
            int m = fastReader.nextInt();
            for(int i = 0; i < m; i++) {
                int node1 = fastReader.nextInt(), node2 = fastReader.nextInt();
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            break input;
        } output: {     // Output segment
            break output;
        }
    }

    public static void createUnions(Map<Integer, List<Integer>> graph, int n) {
        DSU dsu = new DSU(n+1);     // Create DSU of size n+1 for 1 based indexing
        for(int i = 1; i <= n; i++)
            for(int neighbor : graph.get(i))
                dsu.union(i, neighbor);     // Imp - DSU Union logic here
    }
}
