package gemini.task154;

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
        graph.put('A', List.of('B', 'C'));
        graph.put('B', List.of('D', 'E'));
        graph.put('C', List.of('F'));
        graph.put('D', new ArrayList<>());
        graph.put('E', List.of('F'));
        graph.put('F', new ArrayList<>());
    }

    @Test
    public void testDFSIterativeFromA() {
        // Redirect System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run DFS
        Task154_GEMINI_gemini_1_5_pro_001.depthFirstSearch(graph, 'A');

        // Restore System.out
        System.setOut(originalOut);

        String expected = "A B D E F C ";
        assertEquals(expected, outContent.toString());
    }
}
