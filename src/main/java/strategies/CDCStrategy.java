package main.java.strategies;

import main.java.exceptions.StopRecursionException;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Graph;

public interface CDCStrategy {

    void processCDC(CircuitDoubleCover circuitDoubleCover, Graph graph) throws StopRecursionException;

    String getResult();
}
