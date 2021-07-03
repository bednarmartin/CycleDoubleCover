package test.java;

import main.java.exceptions.InconsistentGraphException;
import main.java.graph.CubicEdge;
import main.java.graph.CubicGraph;
import main.java.graph.CubicVertex;
import main.java.graph.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CubicGraphTest {

    @Test
    @DisplayName("Ensure addVertex() method works correctly")
    public void testAddVertex() {
        Graph graph = new CubicGraph();
        Assertions.assertEquals(0, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(1)));
        Assertions.assertEquals(1, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(2)));
        Assertions.assertEquals(2, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(3)));
        Assertions.assertEquals(3, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(4)));
        Assertions.assertEquals(4, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(5)));
        Assertions.assertEquals(5, graph.getNumberOfVertices());
        Assertions.assertDoesNotThrow(() -> graph.addVertex(new CubicVertex(6)));
        Assertions.assertEquals(6, graph.getNumberOfVertices());
        Assertions.assertThrows(InconsistentGraphException.class, () -> graph.addVertex(new CubicVertex(1)));
        Assertions.assertEquals(6, graph.getNumberOfVertices());
        Assertions.assertThrows(InconsistentGraphException.class, () -> graph.addVertex(new CubicVertex(2)));
        Assertions.assertEquals(6, graph.getNumberOfVertices());
        Assertions.assertThrows(InconsistentGraphException.class, () -> graph.addVertex(new CubicVertex(3)));
        Assertions.assertEquals(6, graph.getNumberOfVertices());
    }

    @Test
    @DisplayName("Ensure addEdge() method works correctly")
    public void testAddEdge() {
        Graph graph = new CubicGraph();
        try {
            graph.addVertex(new CubicVertex(1));
            graph.addVertex(new CubicVertex(2));
            graph.addVertex(new CubicVertex(3));

        } catch (InconsistentGraphException e) {
            e.printStackTrace();
        }

        Assertions.assertDoesNotThrow(
                () -> graph.addEdge(new CubicEdge(new CubicVertex(1), new CubicVertex(2))));
        Assertions.assertDoesNotThrow(
                () -> graph.addEdge(new CubicEdge(new CubicVertex(2), new CubicVertex(3))));

        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(1), new CubicVertex(2))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(2), new CubicVertex(1))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(2), new CubicVertex(3))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(3), new CubicVertex(2))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(1), new CubicVertex(1))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(2), new CubicVertex(2))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(3), new CubicVertex(3))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(10), new CubicVertex(15))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(10), new CubicVertex(10))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(20), new CubicVertex(25))));
        Assertions.assertThrows(InconsistentGraphException.class,
                () -> graph.addEdge(new CubicEdge(new CubicVertex(25), new CubicVertex(20))));


    }
}
