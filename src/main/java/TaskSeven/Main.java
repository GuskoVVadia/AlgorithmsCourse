/**
 * Класс для работы с классами в пакете.
 */
package TaskSeven;

public class Main {
    public static void main(String[] args) {

        GraphTask<String> graph = new GraphTask<String>();
        graph.add("Bob");
        graph.add("Alice");
        graph.add("Mark");
        graph.add("Rob");
        graph.add("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
//        graph.addEdge("Rob", "Mark");
//        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.addEdge("Alice", "Mark");

        System.out.println(graph.pathFinder("Rob" , "Mark"));
    }
}
