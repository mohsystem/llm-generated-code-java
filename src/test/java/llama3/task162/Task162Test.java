package llama3.task162;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task162Test {

    @Test
    @DisplayName("Single node graph")
    void testSingleNodeGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Single edge graph")
    void testSingleEdgeGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 5);
        graph.put("B", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 5);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Disconnected graph")
    void testDisconnectedGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.put("B", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", Integer.MAX_VALUE);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Bidirectional edge graph")
    void testBidirectionalEdgeGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 7);
        graph.put("B", new HashMap<>());
        graph.get("B").put("A", 3);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 7);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Example graph from Main")
    void testExampleGraph() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 1);
        expected.put("C", 3);
        expected.put("D", 2);

        assertEquals(expected, Main.dijkstra(Main.graph, "A"));
    }

    @Test
    @DisplayName("Graph with cycle")
    void testGraphWithCycle() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 1);
        graph.put("B", new HashMap<>());
        graph.get("B").put("C", 2);
        graph.put("C", new HashMap<>());
        graph.get("C").put("A", 3);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 1);
        expected.put("C", 3);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Alternate longer path")
    void testAlternateLongerPath() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 5);
        graph.get("A").put("C", 2);
        graph.put("C", new HashMap<>());
        graph.get("C").put("D", 1);
        graph.put("D", new HashMap<>());
        graph.get("D").put("B", 1);
        graph.put("B", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 3);
        expected.put("C", 2);
        expected.put("D", 3);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Equal length paths")
    void testEqualLengthPaths() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 2);
        graph.get("A").put("C", 2);
        graph.put("B", new HashMap<>());
        graph.get("B").put("D", 3);
        graph.put("C", new HashMap<>());
        graph.get("C").put("D", 3);
        graph.put("D", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 2);
        expected.put("C", 2);
        expected.put("D", 5);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }

    @Test
    @DisplayName("Self-loop edge")
    void testSelfLoop() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("A", 10);
        graph.get("A").put("B", 2);
        graph.put("B", new HashMap<>());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 2);

        assertEquals(expected, Main.dijkstra(graph, "A"));
    }
}
