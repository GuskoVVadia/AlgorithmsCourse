/**
 * Класс для построения вершины графа.
 */
package TaskSeven;

import java.util.Objects;

public class Vertex<D> {

    private D data;

    public Vertex(D data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                " data = " + data +
                " }";
    }


}
