package codestral.task154;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Task154Test {

    private static Map<Character, List<Character>> graph;

    @BeforeAll
    public static void setupGraph() {
        graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D', 'E'));
        graph.put('C', Arrays.asList('A', 'F'));
        graph.put('D', Arrays.asList('B'));
        graph.put('E', Arrays.asList('B', 'F'));
        graph.put('F', Arrays.asList('C', 'E'));
    }

    private static void dfs(Map<Character, List<Character>> graph, char node, Set<Character> visited) {
        if (!visited.contains(node)) {
            visited.add(node);
            System.out.print(node + " ");
            for (char neighbour : graph.get(node)) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    @Test
    public void testDFSStartingFromA() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Set<Character> visited = new HashSet<>();
        dfs(graph, 'A', visited);

        System.setOut(originalOut);

        String expectedOutput = "A B D E F C ";
        assertEquals(expectedOutput, outContent.toString());
    }
}
