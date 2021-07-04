package main.java.finders;

import main.java.graph.CircuitDoubleCover;
import main.java.graph.Edge;

import java.util.List;

public interface StrongEdgesFinder {

    List<Edge> getStrongEdges(CircuitDoubleCover circuitDoubleCover);
}
