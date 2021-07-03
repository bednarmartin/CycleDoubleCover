package main.java.reading;

import main.java.graph.Graph;

import java.util.Iterator;

public interface GraphIterator extends Iterator<Graph> {

    int getNumberOfGraphs();

    int getNumberOfVertices();

}
