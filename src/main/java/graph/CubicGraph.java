package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
     * Set containing all the edges of the graph
     */
    private final Set<Edge> EDGES;

    /**
     * Constructor of the CubicGraph class
     */
    public CubicGraph() {
        this.VERTICES = new ArrayList<>();
        this.EDGES = new HashSet<>();
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
     * @return Set of edges of the graph
     */
    @Override
    public Set<Edge> getEdges() {
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

