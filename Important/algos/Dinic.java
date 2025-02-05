import java.util.*;
import java.io.*;

// Imp - T.C. : O(n), S.C. : O(n)

public class Dinic {
    // Imp - Dinic Algorithm is used to find the maximum water flow across a pipe at unit time (works with DAG)
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
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int n;
        input: {        // Input Segment
            FastReader fastReader = new FastReader();
            n = fastReader.nextInt();
            for(int i = 1; i <= n; i++)
                graph.put(i, new ArrayList<int[]>());
            int m = fastReader.nextInt();
            for(int i = 0; i < m; i++)
                graph.get(fastReader.nextInt()).add(new int[]{fastReader.nextInt(), fastReader.nextInt()});
            break input;
        } output: {     // Output segment
            System.out.println(dinicFlow(graph, 1));
            break output;
        }
    }

    public static long dinicFlow(Map<Integer, List<int[]>> graph, int source) {
        int n = graph.size();
        int flow[] = new int[n+1];      // Array defined for storing max flow from each node
        Arrays.fill(flow, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();      // A BFS approach
        queue.add(source);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.poll();
                for(int childData[] : graph.get(node)) {
                    // Extract the node data and the pipe size
                    int childNode = childData[0], pipe = childData[1];
                    flow[childNode] = Math.min(flow[childNode], pipe);      // Greedy Minimization of the pipe parameter (the flow)
                    queue.add(childNode);   // Add the node of directed graph into the queue
                }
            }
        }
        // Stream to find the smallest flow as the max flow of the graph quickly
        return Arrays.stream(flow).boxed().min(Comparator.comparingInt(Integer::intValue)).orElse(Integer.MAX_VALUE);
    }
}
