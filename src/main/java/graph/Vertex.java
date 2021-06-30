package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.List;

public interface Vertex {

    int getNumber();

    void addNeighbor(Vertex neighbor) throws InconsistentGraphException;

    List<Vertex> getNeighbors();

}
