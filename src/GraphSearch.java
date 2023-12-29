import java.util.*;

class Graph {
    private int numNodes;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        this.adjacencyList = new HashMap<>();

        for (int i = 0; i < numNodes; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int node1, int node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    public List<Integer> getNeighbors(int node) {
        return adjacencyList.get(node);
    }

    public int getNumNodes() {
        return numNodes;
    }
}

class BreadthFirstSearch {
    public static void bfs(Graph graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getNumNodes()];

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for (Integer neighbour : graph.getNeighbors(node)){
                if (!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public void recBfs(Graph graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getNumNodes()];

        visited[startNode] = true;
        queue.add(startNode);

        recBfsUtil(graph, queue, visited);
    }

    private void recBfsUtil(Graph graph, Queue<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()){
            return;
        }

        int currentNode = queue.poll();
        System.out.print(currentNode + " ");

        for (int neighbour: graph.getNeighbors(currentNode)){
            if (!visited[neighbour]){
                queue.add(neighbour);
                visited[neighbour] = true;
            }
        }

        recBfsUtil(graph, queue, visited);
    }
}

class DepthFirstSearch {
    public static void dfs(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.getNumNodes()];

        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.isEmpty()){
            int node = stack.pop();
            System.out.print(node + " ");
            for (Integer neighbour : graph.getNeighbors(node)){
                if (!visited[neighbour]){
                    stack.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public void recDfs(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.getNumNodes()];

        visited[startNode] = true;
        stack.add(startNode);

        recDfsUtil(graph, stack, visited);
    }

    private void recDfsUtil(Graph graph, Stack<Integer> stack, boolean[] visited) {
        if (stack.isEmpty()){
            return;
        }

        int currentNode = stack.pop();
        System.out.print(currentNode + " ");

        for (int neighbour: graph.getNeighbors(currentNode)){
            if (!visited[neighbour]){
                stack.push(neighbour);
                visited[neighbour] = true;
            }
        }

        recDfsUtil(graph, stack, visited);
    }
}

public class GraphSearch {
    public static void main(String[] args) {
        // Example graph:
        // 0 -- 1
        // |    |
        // 3 -- 2 -- 4

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);

        System.out.println("BFS starting from node 0:");
        new BreadthFirstSearch().bfs(graph, 0);

        System.out.println("\nRecursive BFS starting from node 0:");
        new BreadthFirstSearch().recBfs(graph, 0);



        System.out.println("\nDFS starting from node 0:");
        new DepthFirstSearch().dfs(graph, 0);

        System.out.println("\nRecursive DFS starting from node 0:");
        new DepthFirstSearch().recDfs(graph, 0);
    }
}
