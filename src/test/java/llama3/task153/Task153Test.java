package llama3.task153;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Redirecting System.out to capture print statements for validation
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testBFSOnSimpleGraph() {
        graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.bfs(0);
        assertEquals("0 1 2 3 4 ", outputStream.toString().trim(), "BFS should visit nodes in the order 0 1 2 3 4.");
    }

    @Test
    void testBFSOnGraphWithSingleNode() {
        graph = new Graph(1);

        graph.bfs(0);
        assertEquals("0", outputStream.toString().trim(), "BFS should visit the only node in the graph.");
    }

    @Test
    void testBFSOnDisconnectedGraph() {
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should only traverse the connected component starting from 0.");
    }

    @Test
    void testBFSOnGraphWithCycle() {
        graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should handle cycles correctly and visit each node only once.");
    }

    @Test
    void testBFSOnGraphWithSelfLoop() {
        graph = new Graph(3);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.bfs(0);
        assertEquals("0 1 2 ", outputStream.toString().trim(), "BFS should handle self-loops and visit nodes in the order 0 1 2.");
    }

    @Test
    void testBFSOnEmptyGraph() {
        graph = new Graph(0);

        graph.bfs(0);
        assertEquals("", outputStream.toString().trim(), "BFS on an empty graph should produce no output.");
    }

    @Test
    void testBFSOnGraphWithIsolatedNode() {
        graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.bfs(2);
        assertEquals("2", outputStream.toString().trim(), "BFS starting from an isolated node should return only that node.");
    }

    @Test
    void testBFSOnGraphWithMultipleComponents() {
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.bfs(3);
        assertEquals("3 4 5 ", outputStream.toString().trim(), "BFS should only traverse the connected component containing node 3.");
    }

    @Test
    void testBFSWithNonExistentStartNode() {
        graph = new Graph(5);

        graph.bfs(7);  // Non-existent node
        assertEquals("", outputStream.toString().trim(), "BFS starting from a non-existent node should produce no output.");
    }

    @Test
    void testBFSOnGraphWithBidirectionalEdges() {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0); // Bidirectional edge
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // Another cycle

        graph.bfs(0);
        assertEquals("0 1 2 3 ", outputStream.toString().trim(), "BFS should handle bidirectional edges and cycles correctly.");
    }
}
