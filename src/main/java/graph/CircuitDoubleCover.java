package main.java.graph;

import main.java.finders.StrongEdgesFinder;

import java.util.List;

public interface CircuitDoubleCover {

    List<Circuit> getCircuits();

    List<Edge> getStrongEdges(StrongEdgesFinder strongEdgesFinder);

}
