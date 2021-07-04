package main.java.strategies;

import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.List;

public interface CircuitStrategy {

    List<Circuit> getCircuits(List<Circuit> circuits, Graph graph);
}
