package claude.task153;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static claude.task153.Task153_CLAUDE_claude_3_5_sonnet_20240620.bfs;

class Task153Test {

    private Map<String, List<String>> graph;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        graph = new HashMap<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testBFSOnConnectedGraph() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));

        bfs(graph, "A");
        assertEquals("A B C D E F ", outputStream.toString().trim(), "BFS traversal from 'A' should be 'A B C D E F'.");
    }

    @Test
    void testBFSOnDisconnectedGraph() {
        graph.put("A", Arrays.asList("B"));
        graph.put("B", Arrays.asList("A"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", Arrays.asList("C"));

        bfs(graph, "A");
        assertEquals("A B ", outputStream.toString().trim(), "BFS traversal from 'A' should be 'A B'.");
    }

    @Test
    void testBFSOnSingleNode() {
        graph.put("A", Collections.emptyList());

        bfs(graph, "A");
        assertEquals("A", outputStream.toString().trim(), "BFS traversal from 'A' should be 'A' with only one node.");
    }

    @Test
    void testBFSOnEmptyGraph() {
        bfs(graph, "A");
        assertEquals("", outputStream.toString().trim(), "BFS traversal on an empty graph should produce no output.");
    }

    @Test
    void testBFSWithCycleInGraph() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("B", "C"));

        bfs(graph, "A");
        assertEquals("A B C D ", outputStream.toString().trim(), "BFS traversal should handle cycles and still return correct result.");
    }

    @Test
    void testBFSOnGraphWithSelfLoop() {
        graph.put("A", Arrays.asList("A", "B"));
        graph.put("B", Arrays.asList("A"));

        bfs(graph, "A");
        assertEquals("A B ", outputStream.toString().trim(), "BFS traversal should handle self-loops and still return correct result.");
    }

    @Test
    void testBFSStartingFromMiddleNode() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));

        bfs(graph, "C");
        assertEquals("C A F B E D ", outputStream.toString().trim(), "BFS traversal from 'C' should be 'C A F B E D'.");
    }

    @Test
    void testBFSWithGraphHavingMultipleComponents() {
        graph.put("A", Arrays.asList("B"));
        graph.put("B", Arrays.asList("A"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", Arrays.asList("C"));
        graph.put("E", Collections.emptyList());

        bfs(graph, "C");
        assertEquals("C D ", outputStream.toString().trim(), "BFS traversal should only cover the connected component containing 'C'.");
    }

    @Test
    void testBFSOnGraphWithNoEdges() {
        graph.put("A", Collections.emptyList());
        graph.put("B", Collections.emptyList());
        graph.put("C", Collections.emptyList());

        bfs(graph, "B");
        assertEquals("B", outputStream.toString().trim(), "BFS traversal on a node with no edges should only print that node.");
    }

    @Test
    void testBFSWithNonExistentStartNode() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D"));

        bfs(graph, "X");
        assertEquals("", outputStream.toString().trim(), "BFS traversal starting from a non-existent node should produce no output.");
    }
}
