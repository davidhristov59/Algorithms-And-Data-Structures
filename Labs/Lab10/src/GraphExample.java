import java.util.*;

class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void deleteEdge(int source, int destination) {
        adjacencyList.getOrDefault(source, Collections.emptySet()).remove(destination);
        adjacencyList.getOrDefault(destination, Collections.emptySet()).remove(source);
    }

    public Set<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptySet());
    }

    public void printGraph() {
        adjacencyList.forEach((vertex, neighbors) ->
                System.out.printf("%d: %s\n", vertex, new ArrayList<>(neighbors)));
    }
}

public class GraphExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");

            if(parts[0].equals("CREATE")){
                graph = new Graph();
            }

            else if(parts[0].equals("ADDEDGE")){
                graph.addEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])); //ADDEDGE 0 3
            }

            else if(parts[0].equals("DELETEEDGE")){
                graph.deleteEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }

            else if(parts[0].equals("ADJACENT")){
                System.out.println(graph.getNeighbors(Integer.parseInt(parts[1])).contains(Integer.parseInt(parts[2])));
            }

            else if(parts[0].equals("PRINTGRAPH")){
                graph.printGraph();
                System.out.println();
            }
        }

//
//        Graph graph = new Graph();
//
//        for (int i = 0; i < n; i++) {
//            String line = scanner.nextLine();
//            String[] parts = line.split(" ");
//
//            switch (parts[0]) {
//
//                case "CREATE":
//                    graph = new Graph();
//                    break;
//                case "ADDEDGE":
//                    graph.addEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
//                    break;
//                case "DELETEEDGE":
//                    graph.deleteEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
//                    break;
//                case "PRINTGRAPH":
//                    graph.printGraph();
//                    System.out.println();
//                    break;
//
//                default:
//                    System.out.println(graph.getNeighbors(Integer.parseInt(parts[1]))
//                            .contains(Integer.parseInt(parts[2])));
//                    break;
//            }
//        }

        scanner.close();
    }
}
