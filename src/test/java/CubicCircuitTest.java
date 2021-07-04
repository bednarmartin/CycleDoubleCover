package test.java;

import main.java.finders.CircuitDoubleCoverFinder;
import main.java.finders.DFSCircuitsFinder;
import main.java.finders.DisjointCircuitDoubleCoverFinder;
import main.java.reading.AdjacentFormatGraphIterator;
import main.java.reading.GraphIterator;
import main.java.strategies.NoChordCircuitsStrategy;
import main.java.strategies.NumberOfStrongEdgesCDCStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CubicCircuitTest {

    @Test
    @DisplayName("Ensure getChordEdges() method works correctly")
    public void testGetChordEdges() {
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/8g3e.txt");
            while (graphIterator.hasNext()) {
                var graph = graphIterator.next();
                CircuitDoubleCoverFinder circuitDoubleCoverFinder = new DisjointCircuitDoubleCoverFinder(
                        graph, new DFSCircuitsFinder(), new NumberOfStrongEdgesCDCStrategy(), new NoChordCircuitsStrategy());
                String result = circuitDoubleCoverFinder.getCircuitDoubleCovers();
                Assertions.assertTrue(result.equals("[]") || result.equals("[12]"));
            }
        } catch (Exception e) {
            Assertions.fail();
        }

    }
}

