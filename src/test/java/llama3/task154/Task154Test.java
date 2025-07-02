package llama3.task154;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Task154Test {

    static Graph graph;

    @BeforeAll
    public static void setupGraph() {
        graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
    }

    @Test
    public void testDFSFrom0() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        graph.dfs(0);

        System.setOut(originalOut);

        String expectedOutput = "0 1 3 2 4 ";
        assertEquals(expectedOutput, outContent.toString());
    }
}
