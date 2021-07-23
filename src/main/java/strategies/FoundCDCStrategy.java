package main.java.strategies;

import main.java.exceptions.StopRecursionException;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Graph;

/**
 * Class representing a strategy when CDC is found - stop the algorithm
 */
public class FoundCDCStrategy implements CDCStrategy {
    /**
     * whether the CDC was found
     */
    private boolean wasFound;

    /**
     * Constructor for the FoundCDCStrategy
     */
    public FoundCDCStrategy() {
        this.wasFound = false;
    }

    /**
     * When CDC is found, the method will throw an exception
     *
     * @param circuitDoubleCover Circuit Double Cover found
     * @param graph              graph to be processed
     * @throws StopRecursionException when the method is called in order to stop the algorithm
     */
    @Override
    public void processCDC(CircuitDoubleCover circuitDoubleCover, Graph graph) throws StopRecursionException {
        wasFound = true;
        throw new StopRecursionException();

    }

    /**
     * @return String representation of the result
     */
    @Override
    public String getResult() {
        if (wasFound) {
            return "CDC WAS FOUND";
        } else {
            return "CDC WAS NOT FOUND";
        }

    }
}
