package main.java.graph;

import main.java.determiners.BridgeDeterminer;
import main.java.determiners.ConnectedGraphDeterminer;
import main.java.exceptions.InconsistentGraphException;
import main.java.finders.TwoCutFinder;

import java.util.List;

public interface Graph {

    int getNumberOfVertices();

    List<Vertex> getVertices();

    List<Edge> getEdges();

    void addVertex(Vertex vertex) throws InconsistentGraphException;

    void addEdge(Edge edge) throws InconsistentGraphException;

    boolean hasBridge(BridgeDeterminer determiner);

    boolean isConnected(ConnectedGraphDeterminer determiner);

    List<List<Edge>> getAllTwoCuts(TwoCutFinder twoCutFinder);

    List<List<Edge>> getAllThreeCuts();


}
