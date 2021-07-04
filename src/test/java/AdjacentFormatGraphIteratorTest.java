package test.java;
import main.java.graph.*;
import main.java.reading.AdjacentFormatGraphIterator;
import main.java.reading.GraphIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentFormatGraphIteratorTest {

    @Test
    @DisplayName("Test reading 4g3e.txt")
    public void test4g3e() {
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/4g3e.txt");

            Assertions.assertEquals(4, graphIterator.getNumberOfVertices());
            Assertions.assertEquals(1, graphIterator.getNumberOfGraphs());

            var counter = 0;
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                Assertions.assertEquals(4, graph.getNumberOfVertices());
                Assertions.assertEquals(6, graph.getEdges().size());

                for (Vertex vertex : graph.getVertices()) {
                    Assertions.assertEquals(3, vertex.getNeighbors().size());
                }

                List<Edge> edges = new ArrayList<>(Arrays.asList(
                        new CubicEdge(new CubicVertex(0), new CubicVertex(1)),
                        new CubicEdge(new CubicVertex(0), new CubicVertex(2)),
                        new CubicEdge(new CubicVertex(0), new CubicVertex(3)),
                        new CubicEdge(new CubicVertex(1), new CubicVertex(2)),
                        new CubicEdge(new CubicVertex(1), new CubicVertex(3)),
                        new CubicEdge(new CubicVertex(2), new CubicVertex(3))
                ));

                for (Edge edge : edges) {
                    Assertions.assertTrue(graph.getEdges().contains(edge));
                }

                Assertions.assertEquals(
                        """
                                1 2 3
                                0 2 3
                                0 1 3
                                0 1 2
                                """, graph.toString());

                counter++;
            }
            Assertions.assertEquals(1, counter);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Test reading 6g3e.txt")
    public void test6g3e() {
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/main/resources/6g3e.txt");

            Assertions.assertEquals(6, graphIterator.getNumberOfVertices());
            Assertions.assertEquals(2, graphIterator.getNumberOfGraphs());

            var counter = 0;
            List<Graph> graphs = new ArrayList<>();
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                graphs.add(graph);
                Assertions.assertEquals(6, graph.getNumberOfVertices());
                Assertions.assertEquals(9, graph.getEdges().size());

                for (Vertex vertex : graph.getVertices()) {
                    Assertions.assertEquals(3, vertex.getNeighbors().size());
                }

                counter++;
            }
            Assertions.assertEquals(2, counter);
            List<Edge> edges1 = new ArrayList<>(Arrays.asList(
                    new CubicEdge(new CubicVertex(0), new CubicVertex(3)),
                    new CubicEdge(new CubicVertex(0), new CubicVertex(4)),
                    new CubicEdge(new CubicVertex(0), new CubicVertex(5)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(2)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(3)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(4)),
                    new CubicEdge(new CubicVertex(2), new CubicVertex(3)),
                    new CubicEdge(new CubicVertex(2), new CubicVertex(5)),
                    new CubicEdge(new CubicVertex(4), new CubicVertex(5))
            ));

            List<Edge> edges2 = new ArrayList<>(Arrays.asList(
                    new CubicEdge(new CubicVertex(0), new CubicVertex(2)),
                    new CubicEdge(new CubicVertex(0), new CubicVertex(3)),
                    new CubicEdge(new CubicVertex(0), new CubicVertex(4)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(2)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(3)),
                    new CubicEdge(new CubicVertex(1), new CubicVertex(4)),
                    new CubicEdge(new CubicVertex(2), new CubicVertex(5)),
                    new CubicEdge(new CubicVertex(3), new CubicVertex(5)),
                    new CubicEdge(new CubicVertex(4), new CubicVertex(5))
            ));

            for (Edge edge : edges1) {
                Assertions.assertTrue(graphs.get(0).getEdges().contains(edge));
            }

            for (Edge edge : edges2) {
                Assertions.assertTrue(graphs.get(1).getEdges().contains(edge));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }
}
