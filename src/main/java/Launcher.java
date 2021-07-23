package main.java;

import main.java.finders.*;
import main.java.graph.Graph;
import main.java.reading.AdjacentFormatGraphIterator;
import main.java.reading.GraphIterator;
import main.java.strategies.NoCircuitStrategy;
import main.java.strategies.NumberOfStrongEdgesCDCStrategy;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        GraphIterator graphIterator = new AdjacentFormatGraphIterator("src/main/resources/14g3e.txt");
        int counter = 0;
        while (graphIterator.hasNext()) {
            Graph graph = graphIterator.next();
            CircuitDoubleCoverFinder circuitDoubleCoverFinder = new DisjointCircuitDoubleCoverFinder
                    (graph, new DFSCircuitsFinder(), new NumberOfStrongEdgesCDCStrategy(), new NoCircuitStrategy());

            System.out.println("GRAPH " + counter + " PROCESSED --> result: " + circuitDoubleCoverFinder.getCircuitDoubleCovers());
            counter++;
        }
        System.out.println("TOTAL TIME " + ((System.currentTimeMillis() - start) / 1000) + " SECONDS");
    }
}
