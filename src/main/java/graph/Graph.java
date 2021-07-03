package main.java.graph;

import main.java.determiners.BridgeDeterminer;
import main.java.determiners.ConnectedGraphDeterminer;
import main.java.exceptions.InconsistentGraphException;

import java.util.List;

public interface Graph {

    int getNumberOfVertices();

    List<Vertex> getVertices();

    List<Edge> getEdges();

    void addVertex(Vertex vertex) throws InconsistentGraphException;

    void addEdge(Edge edge) throws InconsistentGraphException;

    boolean hasBridge(BridgeDeterminer determiner);

    boolean hasThreeCut();

    boolean hasTwoCut();

    boolean isConnected(ConnectedGraphDeterminer determiner);

    List<List<Edge>> getAllTwoCuts();

    List<List<Edge>> getAllThreeCuts();


}
