package test.java;

import main.java.determiners.BridgeDeterminer;
import main.java.determiners.DFSConnectedGraphDeterminer;
import main.java.determiners.DFSBridgeDeterminer;
import main.java.exceptions.InconsistentGraphException;
import main.java.finders.*;
import main.java.graph.*;
import main.java.reading.AdjacentFormatGraphIterator;
import main.java.reading.GraphIterator;
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

    @Test
    @DisplayName("Ensure isConnected() method works correctly")
    public void testIsConnected() {
        try {
            var dfsConnectedGraphDeterminer = new DFSConnectedGraphDeterminer();

            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/8g3e.txt");

            while (graphIterator.hasNext()) {
                Assertions.assertTrue(graphIterator.next().isConnected(dfsConnectedGraphDeterminer));
            }

            GraphIterator graphIterator2 = new AdjacentFormatGraphIterator("src/test/resources/disconnected_8.txt");

            while (graphIterator2.hasNext()) {
                Assertions.assertFalse(graphIterator2.next().isConnected(dfsConnectedGraphDeterminer));
            }

            Graph disconnectedGraph = new CubicGraph();
            disconnectedGraph.addVertex(new CubicVertex(1));
            disconnectedGraph.addVertex(new CubicVertex(2));
            disconnectedGraph.addVertex(new CubicVertex(3));
            disconnectedGraph.addVertex(new CubicVertex(4));
            disconnectedGraph.addVertex(new CubicVertex(5));
            disconnectedGraph.addEdge(new CubicEdge(new CubicVertex(1), new CubicVertex(2)));
            disconnectedGraph.addEdge(new CubicEdge(new CubicVertex(2), new CubicVertex(3)));
            disconnectedGraph.addEdge(new CubicEdge(new CubicVertex(4), new CubicVertex(5)));

            Assertions.assertFalse(disconnectedGraph.isConnected(dfsConnectedGraphDeterminer));

        } catch (Exception e) {
            Assertions.fail();
        }

    }

    @Test
    @DisplayName("Ensure hasBridge() method works correctly")
    public void testHasBridge() {
        BridgeDeterminer bridgeDeterminer = new DFSBridgeDeterminer();
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/bridge_10.txt");
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                Assertions.assertTrue(graph.hasBridge(bridgeDeterminer));
            }

            GraphIterator graphIterator2 = new AdjacentFormatGraphIterator("src/test/resources/12g3e.txt");
            var counter = 0;
            while (graphIterator2.hasNext()) {
                var graph = graphIterator2.next();
                if (counter < 4) {
                    Assertions.assertTrue(graph.hasBridge(bridgeDeterminer));
                } else {
                    Assertions.assertFalse(graph.hasBridge(bridgeDeterminer));
                }
                counter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }

    }

    @Test
    @DisplayName("Ensure getAllTwoCuts() method works correctly")
    public void testGetAllTwoCuts() {
        TwoCutFinder twoCutFinder = new CombinationTwoCutFinder(new DFSConnectedGraphDeterminer());
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/8g3e.txt");
            var counter = 0;
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                if (counter == 0) {
                    Assertions.assertFalse(graph.getAllTwoCuts(twoCutFinder).isEmpty());
                } else {
                    Assertions.assertTrue(graph.getAllTwoCuts(twoCutFinder).isEmpty());
                }
                counter++;
            }

            GraphIterator graphIterator2 = new AdjacentFormatGraphIterator("src/test/resources/10g3e.txt");
            counter = 0;
            while (graphIterator2.hasNext()) {
                var graph = graphIterator2.next();
                if (counter < 5) {
                    Assertions.assertFalse(graph.getAllTwoCuts(twoCutFinder).isEmpty());
                } else {
                    Assertions.assertEquals(0, graph.getAllTwoCuts(twoCutFinder).size());
                }
                counter++;
            }
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Ensure getAllThreeCuts() method works correctly")
    public void testGetAllThreeCuts() {
        ThreeCutFinder threeCutFinder = new CombinationThreeCutFinder(new DFSConnectedGraphDeterminer());
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/10g3e.txt");
            var counter = 1;
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                if (counter < 15) {
                    Assertions.assertFalse(graph.getAllThreeCuts(threeCutFinder).isEmpty());
                } else {
                    Assertions.assertTrue(graph.getAllThreeCuts(threeCutFinder).isEmpty());
                }
                counter++;
            }
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Ensure getCircuits() method works correctly")
    public void testGetCircuits() {
        CircuitsFinder circuitsFinder = new DFSCircuitsFinder();
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/4g3e.txt");
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                Assertions.assertEquals(7, graph.getCircuits(circuitsFinder).size());
            }
        } catch (Exception e) {
            Assertions.fail();
        }

        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/12g3e.txt");
            var graph = graphIterator.next();
            Assertions.assertEquals(19, graph.getCircuits(circuitsFinder).size());
            while (graphIterator.hasNext()) {
                graph = graphIterator.next();
                for (Circuit circuit : graph.getCircuits(circuitsFinder)) {
                    for (Edge edge : circuit.getEdges()) {
                        Assertions.assertTrue(graph.getEdges().contains(edge));
                    }
                }
            }

        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
