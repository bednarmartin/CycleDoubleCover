package main.java.strategies;

import main.java.exceptions.StopRecursionException;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Graph;

public class FoundCDCStrategy implements CDCStrategy {
    @Override
    public void processCDC(CircuitDoubleCover circuitDoubleCover, Graph graph) throws StopRecursionException {
        throw new StopRecursionException();

    }

    @Override
    public String getResult() {
        return "STRONG CDC FOUND";
    }
}
