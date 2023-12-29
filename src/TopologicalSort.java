import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        // Example: Directed Acyclic Graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(5, Arrays.asList(2, 0));
        graph.put(4, Arrays.asList(0, 1));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(1));
        graph.put(1, new ArrayList<>());
        graph.put(0, new ArrayList<>());

        List<Integer> topologicalOrder = topologicalSort(graph);
        System.out.println("Topological Order: " + topologicalOrder);
    }

    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                topologicalSortUtil(graph, visited, stack, node);
            }
        }

        List<Integer> list = new ArrayList<>(stack.stream().toList());
        Collections.reverse(list);

        return list;
    }

    private static void topologicalSortUtil(Map<Integer, List<Integer>> graph, List<Integer> visited, Stack<Integer> stack, Integer node) {
        visited.add(node);

        if (graph.containsKey(node)) {
            for (int neighbour : graph.get(node)) {
                if (!visited.contains(neighbour)) {
                    topologicalSortUtil(graph, visited, stack, neighbour);
                }
            }
        }

        stack.push(node);
    }
}
