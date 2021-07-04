package main.java.graph;

import main.java.determiners.BridgeDeterminer;
import main.java.determiners.ConnectedGraphDeterminer;
import main.java.exceptions.InconsistentGraphException;
import main.java.finders.CircuitsFinder;
import main.java.finders.ThreeCutFinder;
import main.java.finders.TwoCutFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a cubic graph
 */
public class CubicGraph implements Graph {
    /**
     * List containing all the vertices of the graph
     */
    private final List<Vertex> vertices;
    /**
     * List containing all the edges of the graph
     */
    private final List<Edge> edges;

    /**
     * Constructor of the CubicGraph class
     */
    public CubicGraph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    /**
     * @return number of vertices of the graph
     */
    @Override
    public int getNumberOfVertices() {
        return this.vertices.size();
    }

    /**
     * @return List of vertices of the graph
     */
    @Override
    public List<Vertex> getVertices() {
        return this.vertices;
    }

    /**
     * @return List of edges of the graph
     */
    @Override
    public List<Edge> getEdges() {
        return this.edges;
    }

    /**
     * Adds a vertex to a graph
     *
     * @param vertex vertex to be added
     */
    @Override
    public void addVertex(Vertex vertex) throws InconsistentGraphException {
        if (this.vertices.contains(vertex)) {
            throw new InconsistentGraphException();
        }
        this.vertices.add(vertex);
    }

    /**
     * Adds an edge to a graph
     *
     * @param edge edge to be added
     */
    @Override
    public void addEdge(Edge edge) throws InconsistentGraphException {
        if (!this.vertices.contains(edge.getFirst()) || !this.vertices.contains(edge.getSecond())) {
            throw new InconsistentGraphException();
        }
        if (this.edges.contains(edge)) {
            throw new InconsistentGraphException();
        }
        this.edges.add(edge);
    }

    /**
     * @return True if the graph has a bridge
     */
    @Override
    public boolean hasBridge(BridgeDeterminer determiner) {
        return determiner.hasBridge(this);
    }

    /**
     * @return True if the graph is connected
     */
    @Override
    public boolean isConnected(ConnectedGraphDeterminer determiner) {
        return determiner.isConnected(this);
    }

    /**
     * @return Set of all 2-cuts of the graph
     */
    @Override
    public List<List<Edge>> getAllTwoCuts(TwoCutFinder twoCutFinder) {
        return twoCutFinder.getTwoCuts(this);
    }

    /**
     * @return Set of all 3-cuts of the graph
     */
    @Override
    public List<List<Edge>> getAllThreeCuts(ThreeCutFinder threeCutFinder) {
        return threeCutFinder.getThreeCuts(this);
    }

    /**
     * @param circuitsFinder algorithm for finding circuits in the graph
     * @return List of circuits in the graph
     */
    @Override
    public List<Circuit> getCircuits(CircuitsFinder circuitsFinder) {
        return circuitsFinder.getCircuits(this);
    }

    @Override
    public String toString() {
        var answer = new StringBuilder();
        for (Vertex vertex : this.vertices) {
            for (Vertex toPrintVertex : vertex.getNeighbors()) {
                answer.append(toPrintVertex.getNumber());
                answer.append(" ");
            }
            answer.deleteCharAt(answer.length() - 1);
            answer.append("\n");
        }
        return answer.toString();
    }
}

