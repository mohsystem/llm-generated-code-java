package gtp4o.task153;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        graph = new Graph();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testBFSOnConnectedGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.bfs(2);
        assertEquals("2 0 3 1 ", outputStream.toString().trim(), "BFS should return nodes in the order: 2 0 3 1.");
    }

    @Test
    void testBFSOnSingleNodeGraph() {
        graph.addEdge(0, 0);

        graph.bfs(0);
        assertEquals("0", outputStream.toString().trim(), "BFS on single node graph should return '0'.");
    }

    @Test
    void testBFSOnGraphWithSelfLoop() {
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should handle self-loops and return nodes in the order: 0 1 2.");
    }

    @Test
    void testBFSOnDisconnectedGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should only traverse the connected component starting from 0.");
    }

    @Test
    void testBFSStartingFromNodeWithNoEdges() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.bfs(3);
        assertEquals("3", outputStream.toString().trim(), "BFS starting from a node with no edges should return only that node.");
    }

    @Test
    void testBFSOnGraphWithMultipleComponents() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        graph.bfs(3);
        assertEquals("3 4 ", outputStream.toString().trim(), "BFS should traverse the component containing 3 and 4.");
    }

    @Test
    void testBFSOnEmptyGraph() {
        graph.bfs(0);
        assertEquals("0", outputStream.toString().trim(), "BFS on an empty graph should return only the start node.");
    }

    @Test
    void testBFSWithCyclicGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should handle cycles correctly and return nodes in the order: 0 1 2.");
    }

    @Test
    void testBFSWithNonExistentStartNode() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.bfs(5);
        assertEquals("5", outputStream.toString().trim(), "BFS starting from a non-existent node should return only that node.");
    }

    @Test
    void testBFSOnGraphWithIsolatedNodes() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 3); // Isolated node with a self-loop

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should traverse only the connected component starting from 0.");
    }
}