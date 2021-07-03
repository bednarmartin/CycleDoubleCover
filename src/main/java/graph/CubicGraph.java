package main.java.graph;

import main.java.determiners.BridgeDeterminer;
import main.java.determiners.ConnectedGraphDeterminer;
import main.java.exceptions.InconsistentGraphException;
import main.java.finders.TwoCutFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class representing a cubic graph
 */
public class CubicGraph implements Graph {
    /**
     * Logger of the class
     */
    private static final Logger LOGGER = Logger.getLogger(CubicEdge.class.getName());
    /**
     * List containing all the vertices of the graph
     */
    private final List<Vertex> VERTICES;
    /**
     * List containing all the edges of the graph
     */
    private final List<Edge> EDGES;
    /**
     * Whether the graph has a bridge
     */
    private boolean hasBridge;
    /**
     * Whether the graph has a 2-cut
     */
    private boolean hasTwoCut;
    /**
     * Whether the graph has a 3-cut
     */
    private boolean hasThreeCut;
    /**
     * Whether the graph is connected
     */
    private boolean isConnected;
    /**
     * 2-cuts of the graph
     */
    private List<List<Edge>> twoCuts;
    /**
     * 3-cuts of the graph
     */
    private List<List<Edge>> threeCuts;

    /**
     * Constructor of the CubicGraph class
     */
    public CubicGraph() {
        this.VERTICES = new ArrayList<>();
        this.EDGES = new ArrayList<>();
        LOGGER.finest("New CubicGraph object created");
    }

    /**
     * @return number of vertices of the graph
     */
    @Override
    public int getNumberOfVertices() {
        LOGGER.finest("Number of Vertices + " + this.VERTICES.size() + " returned");
        return this.VERTICES.size();
    }

    /**
     * @return List of vertices of the graph
     */
    @Override
    public List<Vertex> getVertices() {
        LOGGER.finest("Vertices + " + this.VERTICES + " returned");
        return this.VERTICES;
    }

    /**
     * @return List of edges of the graph
     */
    @Override
    public List<Edge> getEdges() {
        LOGGER.finest("Edges + " + this.EDGES + " returned");
        return this.EDGES;
    }

    /**
     * Adds a vertex to a graph
     *
     * @param vertex vertex to be added
     */
    @Override
    public void addVertex(Vertex vertex) throws InconsistentGraphException {
        if (this.VERTICES.contains(vertex)) {
            LOGGER.warning("Vertex " + vertex + " already in a graph");
            throw new InconsistentGraphException();
        }
        this.VERTICES.add(vertex);
        LOGGER.info("Vertex " + vertex + " added");
    }

    /**
     * Adds an edge to a graph
     *
     * @param edge edge to be added
     */
    @Override
    public void addEdge(Edge edge) throws InconsistentGraphException {
        if (!this.VERTICES.contains(edge.getFirst()) || !this.VERTICES.contains(edge.getSecond())) {
            LOGGER.warning("Vertices of Edge " + edge + " are not in List of vertices of the graph");
            throw new InconsistentGraphException();
        }
        if (this.EDGES.contains(edge)) {
            LOGGER.warning("Edge " + edge + " is already in Set of edges");
            throw new InconsistentGraphException();
        }
        this.EDGES.add(edge);
        LOGGER.info("Edge " + edge + " added");
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
    public List<List<Edge>> getAllThreeCuts() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Vertex vertex : this.VERTICES) {
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

