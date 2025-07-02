package claude.task154;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Task154Test {

    private static Graph graph;

    @BeforeAll
    public static void setupGraph() {
        graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
    }

    @Test
    public void testDFSStartingFrom2() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Execute DFS
        graph.dfs(2);

        // Restore original System.out
        System.setOut(originalOut);

        // Expected output: same as Python: "2 0 1 3 "
        String expectedOutput = "2 0 1 3 ";
        assertEquals(expectedOutput, outContent.toString());
    }
}
