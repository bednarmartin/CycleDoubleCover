package main.java.strategies;

import main.java.finders.ComparisonStrongEdgesFinder;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Edge;
import main.java.graph.Graph;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class representing a strategy when CDC is found - determine the number of the strong edges
 */
public class NumberOfStrongEdgesCDCStrategy implements CDCStrategy {
    /**
     * Set of numbers found in the CDCs
     */
    private final Set<Integer> edges;

    public NumberOfStrongEdgesCDCStrategy() {
        this.edges = new TreeSet<>();
    }

    /**
     * When CDC is found, the method will count the number of the strong edges
     *
     * @param circuitDoubleCover Circuit Double Cover found
     * @param graph              graph to be processed
     */
    @Override
    public void processCDC(CircuitDoubleCover circuitDoubleCover, Graph graph) {
        List<Edge> strongEdges = circuitDoubleCover.getStrongEdges(new ComparisonStrongEdgesFinder(graph));
        edges.add(strongEdges.size());
    }

    /**
     * @return String representation of the result
     */
    @Override
    public String getResult() {
        return edges.toString();
    }
}
