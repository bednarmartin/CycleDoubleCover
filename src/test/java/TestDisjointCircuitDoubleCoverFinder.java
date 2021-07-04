package test.java;

import main.java.finders.CircuitDoubleCoverFinder;
import main.java.finders.DFSCircuitsFinder;
import main.java.finders.DisjointCircuitDoubleCoverFinder;
import main.java.reading.AdjacentFormatGraphIterator;
import main.java.reading.GraphIterator;
import main.java.strategies.NoCircuitStrategy;
import main.java.strategies.NumberOfStrongEdgesCDCStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestDisjointCircuitDoubleCoverFinder {

    @Test
    @DisplayName("Ensure the CDC Finder with 4-vertex cubic graph works correctly")
    public void test4g3eCDC() {
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/4g3e.txt");
            var graph = graphIterator.next();
            CircuitDoubleCoverFinder circuitDoubleCoverFinder = new DisjointCircuitDoubleCoverFinder(
                    graph, new DFSCircuitsFinder(), new NumberOfStrongEdgesCDCStrategy(), new NoCircuitStrategy());
            String result = circuitDoubleCoverFinder.getCircuitDoubleCovers();
            Assertions.assertEquals("[0, 6]", result);

        } catch (Exception e) {
            Assertions.fail();
        }

    }

    @Test
    @DisplayName("Ensure the CDC Finder with 6-vertex cubic graphs works correctly")
    public void test6g3eCDC() {
        try {
            GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/test/resources/6g3e.txt");
            var graph1 = graphIterator.next();
            CircuitDoubleCoverFinder circuitDoubleCoverFinder1 = new DisjointCircuitDoubleCoverFinder(
                    graph1, new DFSCircuitsFinder(), new NumberOfStrongEdgesCDCStrategy(), new NoCircuitStrategy());
            String result1 = circuitDoubleCoverFinder1.getCircuitDoubleCovers();
            Assertions.assertEquals("[0, 6, 9]", result1);

            var graph2 = graphIterator.next();
            CircuitDoubleCoverFinder circuitDoubleCoverFinder2 = new DisjointCircuitDoubleCoverFinder(
                    graph2, new DFSCircuitsFinder(), new NumberOfStrongEdgesCDCStrategy(), new NoCircuitStrategy());
            String result2 = circuitDoubleCoverFinder2.getCircuitDoubleCovers();
            Assertions.assertEquals("[0, 6]", result2);

        } catch (Exception e) {
            Assertions.fail();
        }

    }
}
