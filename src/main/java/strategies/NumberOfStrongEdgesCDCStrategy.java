package main.java.strategies;

import main.java.finders.ComparisonStrongEdgesFinder;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Edge;
import main.java.graph.Graph;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfStrongEdgesCDCStrategy implements CDCStrategy {

    private final Set<Integer> edges;

    public NumberOfStrongEdgesCDCStrategy() {
        this.edges = new TreeSet<>();
    }

    @Override
    public void processCDC(CircuitDoubleCover circuitDoubleCover, Graph graph) {
        List<Edge> strongEdges = circuitDoubleCover.getStrongEdges(new ComparisonStrongEdgesFinder(graph));
        edges.add(strongEdges.size());
    }

    @Override
    public String getResult() {
        return edges.toString();
    }
}
