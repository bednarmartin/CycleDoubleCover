package main.java.finders;

import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.List;

public interface CircuitsFinder {

    List<Circuit> getCircuits(Graph graph);
}
