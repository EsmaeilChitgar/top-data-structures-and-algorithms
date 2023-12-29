import java.util.*;

public class CyclicGraph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list

    public CyclicGraph(int vertices) {
        this.V = vertices;
        this.adjList = new LinkedList[vertices];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // DFS traversal for cycle detection
    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (!visited[v]) {
            visited[v] = true;
            recStack[v] = true;

            for (int neighbour : adjList[v]) {
                if (!visited[neighbour] && isCyclicUtil(neighbour, visited, recStack)) {
                    return true;
                } else if (recStack[neighbour]) {
                    return true;
                }
            }
        }

        recStack[v] = false;
        return false;
    }

    // Check if the graph contains a cycle
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CyclicGraph cyclicGraph = new CyclicGraph(4);
        cyclicGraph.addEdge(0, 1);
        cyclicGraph.addEdge(0, 2);
        cyclicGraph.addEdge(1, 2);
        //cyclicGraph.addEdge(2, 0);
        cyclicGraph.addEdge(2, 3);
        //cyclicGraph.addEdge(3, 3);

        if (cyclicGraph.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
