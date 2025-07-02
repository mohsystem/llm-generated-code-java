package gtp4o.task154;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Task154Test {

    static Graph graph;

    @BeforeAll
    public static void setupGraph() {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
    }

    @Test
    public void testDFSFrom2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        graph.DFS(2);

        System.setOut(originalOut);

        String expectedOutput = "2 0 1 3 ";
        assertEquals(expectedOutput, outContent.toString());
    }
}
