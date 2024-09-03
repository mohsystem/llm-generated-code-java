package codestral.task153;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BFSUnitTest {

    private Map<Character, List<Character>> graph;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        graph = new HashMap<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testBFSOnSimpleGraph() {
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D'));
        graph.put('C', Arrays.asList('A', 'D'));
        graph.put('D', Arrays.asList('B', 'C'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A B C D ", outputStream.toString().trim(), "BFS traversal should be A B C D.");
    }

    @Test
    void testBFSOnDisconnectedGraph() {
        graph.put('A', Arrays.asList('B'));
        graph.put('B', Arrays.asList('A'));
        graph.put('C', Arrays.asList('D'));
        graph.put('D', Arrays.asList('C'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A B ", outputStream.toString().trim(), "BFS traversal from 'A' should be A B.");
    }

    @Test
    void testBFSOnGraphWithCycle() {
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D'));
        graph.put('C', Arrays.asList('A', 'D'));
        graph.put('D', Arrays.asList('B', 'C'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A B C D ", outputStream.toString().trim(), "BFS traversal should handle cycles and return A B C D.");
    }

    @Test
    void testBFSOnGraphWithSelfLoop() {
        graph.put('A', Arrays.asList('A', 'B'));
        graph.put('B', Arrays.asList('A'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A B ", outputStream.toString().trim(), "BFS traversal should handle self-loops and return A B.");
    }

    @Test
    void testBFSOnSingleNodeGraph() {
        graph.put('A', Collections.emptyList());

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A", outputStream.toString().trim(), "BFS traversal on single node should return A.");
    }

    @Test
    void testBFSOnEmptyGraph() {
        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("", outputStream.toString().trim(), "BFS traversal on an empty graph should return nothing.");
    }

    @Test
    void testBFSWithNonExistentStartNode() {
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D'));
        graph.put('C', Arrays.asList('A', 'D'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'X');
        assertEquals("", outputStream.toString().trim(), "BFS traversal starting from a non-existent node should return nothing.");
    }

    @Test
    void testBFSOnGraphWithMultipleComponents() {
        graph.put('A', Arrays.asList('B'));
        graph.put('B', Arrays.asList('A'));
        graph.put('C', Arrays.asList('D'));
        graph.put('D', Arrays.asList('C'));
        graph.put('E', Collections.emptyList());

        Task153_MISTRAL_codestral_latest.bfs(graph, 'C');
        assertEquals("C D ", outputStream.toString().trim(), "BFS traversal should cover only the component containing C.");
    }

    @Test
    void testBFSWithGraphHavingIsolatedNodes() {
        graph.put('A', Arrays.asList('B'));
        graph.put('B', Arrays.asList('A'));
        graph.put('C', Collections.emptyList());
        graph.put('D', Collections.emptyList());

        Task153_MISTRAL_codestral_latest.bfs(graph, 'A');
        assertEquals("A B ", outputStream.toString().trim(), "BFS traversal should only include nodes connected to A.");
    }

    @Test
    void testBFSStartingFromMiddleNode() {
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D', 'E'));
        graph.put('C', Arrays.asList('A', 'F'));
        graph.put('D', Arrays.asList('B'));
        graph.put('E', Arrays.asList('B', 'F'));
        graph.put('F', Arrays.asList('C', 'E'));

        Task153_MISTRAL_codestral_latest.bfs(graph, 'C');
        assertEquals("C A F B E D ", outputStream.toString().trim(), "BFS traversal from C should return C A F B E D.");
    }
}

