package test.java;

import main.java.exceptions.InconsistentGraphException;
import main.java.graph.CubicEdge;
import main.java.graph.CubicVertex;
import main.java.graph.Edge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CubicEdgeTest {

    @Test
    @DisplayName("Ensure the constructor of the CubicEdge works correctly")
    public void testEdge() {
        Assertions.assertDoesNotThrow(() -> new CubicEdge(new CubicVertex(1), new CubicVertex(2)));
        Assertions.assertDoesNotThrow(() -> new CubicEdge(new CubicVertex(4), new CubicVertex(6)));
        Assertions.assertDoesNotThrow(() -> new CubicEdge(new CubicVertex(5), new CubicVertex(3)));

        Assertions.assertThrows(InconsistentGraphException.class, () -> new CubicEdge(new CubicVertex(5), new CubicVertex(5)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> new CubicEdge(new CubicVertex(1), new CubicVertex(1)));
        Assertions.assertThrows(InconsistentGraphException.class, () -> new CubicEdge(new CubicVertex(2), new CubicVertex(2)));

        try {
            Edge first = new CubicEdge(new CubicVertex(1), new CubicVertex(2));
            Edge second = new CubicEdge(new CubicVertex(3), new CubicVertex(4));
            Edge third = new CubicEdge(new CubicVertex(1), new CubicVertex(4));
            Edge fourth = new CubicEdge(new CubicVertex(1), new CubicVertex(2));
            Edge fifth = new CubicEdge(new CubicVertex(3), new CubicVertex(2));
            Edge sixth = new CubicEdge(new CubicVertex(2), new CubicVertex(3));

            Assertions.assertEquals(first, fourth);
            Assertions.assertEquals(fifth, sixth);
            Assertions.assertNotEquals(first, third);
            Assertions.assertNotEquals(sixth, fourth);
            Assertions.assertNotEquals(second, fifth);

            Set<Edge> setOfEdges = new HashSet<>(Arrays.asList(first, second, third, fourth, fifth, sixth));

            Assertions.assertTrue(setOfEdges.contains(first));
            Assertions.assertTrue(setOfEdges.contains(second));
            Assertions.assertTrue(setOfEdges.contains(third));
            Assertions.assertTrue(setOfEdges.contains(fourth));
            Assertions.assertTrue(setOfEdges.contains(fifth));
            Assertions.assertTrue(setOfEdges.contains(sixth));

            Assertions.assertTrue(setOfEdges.contains(new CubicEdge(new CubicVertex(1), new CubicVertex(2))));
            Assertions.assertTrue(setOfEdges.contains(new CubicEdge(new CubicVertex(3), new CubicVertex(2))));
            Assertions.assertTrue(setOfEdges.contains(new CubicEdge(new CubicVertex(2), new CubicVertex(3))));
            Assertions.assertTrue(setOfEdges.contains(new CubicEdge(new CubicVertex(1), new CubicVertex(4))));

            Assertions.assertEquals(4, setOfEdges.size());

            Assertions.assertFalse(setOfEdges.contains(new CubicEdge(new CubicVertex(0), new CubicVertex(2))));
            Assertions.assertFalse(setOfEdges.contains(new CubicEdge(new CubicVertex(1), new CubicVertex(10))));
            Assertions.assertFalse(setOfEdges.contains(new CubicEdge(new CubicVertex(2), new CubicVertex(0))));

        } catch (InconsistentGraphException e) {
            e.printStackTrace();
        }


    }

    @Test
    @DisplayName("Ensure that toString() method works correctly")
    public void testToString() {
        try {
            Edge first = new CubicEdge(new CubicVertex(1), new CubicVertex(2));
            Edge second = new CubicEdge(new CubicVertex(2), new CubicVertex(3));

            Assertions.assertEquals("[1, 2]", first.toString());
            Assertions.assertEquals("[2, 3]", second.toString());

        } catch (InconsistentGraphException e) {
            e.printStackTrace();
        }

    }
}
