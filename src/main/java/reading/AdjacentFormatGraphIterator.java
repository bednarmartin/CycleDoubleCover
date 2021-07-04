package main.java.reading;

import main.java.graph.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class AdjacentFormatGraphIterator implements GraphIterator {
    /**
     * Number of graphs to be read
     */
    private final int numberOfGraphs;
    /**
     * Number of vertices of the graphs to be read
     */
    private final int numberOfVertices;
    /**
     * How many graphs were read
     */
    private int counter;
    /**
     * Buffered Reader for reading
     */
    private final BufferedReader bufferedReader;

    /**
     * Constructor of the class AdjacentFormatGraphIterator
     *
     * @param path path of the file to read from
     * @throws IOException - wrong format of the graphs
     */
    public AdjacentFormatGraphIterator(String path) throws IOException {
        this.bufferedReader = new BufferedReader(new FileReader(path));
        int numberOfLines;
        try (Stream<String> stream = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            numberOfLines = (int) stream.count();
            this.numberOfVertices = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            throw new IOException();
        }
        this.numberOfGraphs = (numberOfLines + 2) / (numberOfVertices + 1);
        this.counter = 0;
    }

    /**
     * @return True if there is a graph to be read
     */
    @Override
    public boolean hasNext() {
        return counter < getNumberOfGraphs();
    }

    /**
     * @return Graph object read from the file
     */
    @Override
    public Graph next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Graph graph = new CubicGraph();
        try {
            for (var i = 0; i < numberOfVertices; i++) graph.addVertex(new CubicVertex(i));
            for (var i = 0; i < numberOfVertices; i++) {
                String line = bufferedReader.readLine();
                String[] splitLine = line.split(" ");
                for (String s : splitLine) {
                    var toVertex = Integer.parseInt(s);
                    if (i < toVertex) {
                        graph.addEdge(new CubicEdge(graph.getVertices().get(i), graph.getVertices().get(toVertex)));
                    }
                }
            }
            counter++;
            if (hasNext()) {
                bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return graph;
    }

    /**
     * @return number of graphs in the file
     */
    @Override
    public int getNumberOfGraphs() {
        return numberOfGraphs;
    }

    /**
     * @return number of vertices of the graphs in the file
     */
    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
