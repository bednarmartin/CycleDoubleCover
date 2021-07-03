package test.java;

import main.java.exceptions.InconsistentGraphException;
import main.java.graph.CubicVertex;
import main.java.graph.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CubicVertexTest {


    @Test
    @DisplayName("Ensure the number of CubicVertex object works correctly")
    public void testNumber() {

        Vertex first = new CubicVertex(1);
        Vertex second = new CubicVertex(2);
        Vertex third = new CubicVertex(3);
        Vertex fourth = new CubicVertex(4);
        Vertex fifth = new CubicVertex(1);
        Vertex sixth = new CubicVertex(2);

        Assertions.assertEquals(first, fifth);
        Assertions.assertEquals(second, sixth);
        Assertions.assertNotEquals(first, third);
        Assertions.assertNotEquals(second, fourth);
        Assertions.assertNotEquals(fifth, sixth);

        Set<Vertex> setOfVertices = new HashSet<>(Arrays.asList(first, second, third, fourth, fifth, sixth));

        for (Vertex vertex : Arrays.asList(first, second, third, fourth, fifth, sixth)) {
            Assertions.assertTrue(setOfVertices.contains(vertex));
        }

        Assertions.assertTrue(setOfVertices.contains(new CubicVertex(1)));
        Assertions.assertTrue(setOfVertices.contains(new CubicVertex(2)));
        Assertions.assertTrue(setOfVertices.contains(new CubicVertex(3)));
        Assertions.assertTrue(setOfVertices.contains(new CubicVertex(4)));

        Assertions.assertEquals(4, setOfVertices.size());

        Assertions.assertFalse(setOfVertices.contains(new CubicVertex(5)));
        Assertions.assertFalse(setOfVertices.contains(new CubicVertex(6)));
        Assertions.assertFalse(setOfVertices.contains(new CubicVertex(7)));

    }

    @Test
    @DisplayName("Ensure adding neighbors to a CubicVertex objects works correctly")
    public void testAddingNeighbors() {
        Vertex vertex = new CubicVertex(1);
        Vertex first = new CubicVertex(2);
        Vertex second = new CubicVertex(3);
        Vertex third = new CubicVertex(4);

        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(first));
        Assertions.assertEquals(1, vertex.getNeighbors().size());
        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(second));
        Assertions.assertEquals(2, vertex.getNeighbors().size());
        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(third));
        Assertions.assertEquals(3, vertex.getNeighbors().size());

        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(5)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(1)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(2)));

        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(2)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(3)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> vertex.addNeighbor(new CubicVertex(4)));

    }

    @Test
    @DisplayName("Ensure that a list of adjacent vertices works correctly")
    public void testGetNeighbors() {
        Vertex vertex = new CubicVertex(1);

        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(new CubicVertex(2)));
        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(new CubicVertex(3)));
        Assertions.assertDoesNotThrow(() -> vertex.addNeighbor(new CubicVertex(4)));

        Assertions.assertTrue(vertex.getNeighbors().contains(new CubicVertex(2)));
        Assertions.assertTrue(vertex.getNeighbors().contains(new CubicVertex(3)));
        Assertions.assertTrue(vertex.getNeighbors().contains(new CubicVertex(4)));

        Assertions.assertFalse(vertex.getNeighbors().contains(new CubicVertex(5)));
        Assertions.assertFalse(vertex.getNeighbors().contains(new CubicVertex(6)));
        Assertions.assertFalse(vertex.getNeighbors().contains(new CubicVertex(7)));

    }

    @Test
    @DisplayName("Ensure that toString() method works correctly")
    public void testToString() {
        Vertex first = new CubicVertex(1);
        Vertex second = new CubicVertex(2);

        Assertions.assertEquals("1", first.toString());
        Assertions.assertEquals("2", second.toString());

    }


}
