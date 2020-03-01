/**
 * Класс, основанный на коде с урока.
 * Переработан в контексте обобщений.
 * Дополнен методом поиска пути.
 */
package TaskSeven;

import java.util.*;

public class GraphTask<D> {

    private Map<Vertex<D>, List<Vertex<D>>> vertexMap;

    public GraphTask() {
        this.vertexMap = new HashMap<>();
    }

    public void add(D data){
        this.vertexMap.putIfAbsent(new Vertex<D>(data), new LinkedList<Vertex<D>>());
    }

    public void remove(D data){
        Vertex<D> vertex = new Vertex<D>(data);
        this.vertexMap.values().forEach(list -> list.remove(vertex));
        this.vertexMap.remove(vertex);
    }

    public void addEdge(D dataFirst, D dataSecond) {
        Vertex<D> objFirst = new Vertex<D>(dataFirst);
        Vertex<D> objSecond = new Vertex<D>(dataSecond);
        this.vertexMap.get(objFirst).add(objSecond);
        this.vertexMap.get(objSecond).add(objFirst);
    }

    public void removeEdge(D dataFirst, D dataSecond) {
        Vertex<D> objFirst = new Vertex<D>(dataFirst);
        Vertex<D> objSecond = new Vertex<D>(dataSecond);

        List<Vertex<D>> listFirst = this.vertexMap.get(objFirst);
        List<Vertex<D>> listSecond = this.vertexMap.get(objSecond);

        if (listFirst != null) {
            listFirst.remove(objSecond);
        }

        if (listSecond != null) {
            listSecond.remove(objFirst);
        }
    }

    public Set<Vertex<D>> depthFirstSearch(D start) {
        Vertex<D> root = new Vertex<D>(start);
        Set<Vertex<D>> visited = new LinkedHashSet<Vertex<D>>();
        Stack<Vertex<D>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex<D> vert = stack.pop();
            if (!visited.contains(vert)) {
                visited.add(vert);
                this.vertexMap.get(vert).forEach(stack::push);
            }
        }
        return visited;
    }

    public Set<Vertex<D>> breadthFirstSearch(D start) {
        Vertex<D> root = new Vertex<D>(start);
        Set<Vertex<D>> visited = new LinkedHashSet<>();
        Queue<Vertex<D>> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Vertex<D> vert = queue.poll();
            for (Vertex<D> v : this.vertexMap.get(vert)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    public Set<Vertex<D>> pathFinder(D start, D find) {
        Vertex<D> objStart = new Vertex<D>(start);
        Vertex<D> objFind = new Vertex<D>(find);

        Set<Vertex<D>> visited = new LinkedHashSet<>();
        Queue<Vertex<D>> queue = new LinkedList<>();
        queue.add(objStart);
        visited.add(objStart);
        while (!queue.isEmpty()) {
            Vertex<D> vert = queue.poll();
            for (Vertex<D> v : this.vertexMap.get(vert)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
                if (objFind.equals(objStart)){
                    break;
                }
            }
        }
        return visited;
    }
}