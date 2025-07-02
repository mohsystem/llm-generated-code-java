package gemini.task167;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task167Test {

    @Test
    public void test_case_1() {
        assertEquals(3.46, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(8), 0.01);
    }

    @Test
    public void test_case_2() {
        assertEquals(12.12, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(343), 0.01);
    }

    @Test
    public void test_case_3() {
        assertEquals(18.19, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(1157.625), 0.01);
    }

    @Test
    public void test_case_4() {
        assertEquals(5.20, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(27), 0.01);
    }

    @Test
    public void test_case_5() {
        assertEquals(1.73, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(1), 0.01);
    }

    @Test
    public void test_case_6() {
        assertEquals(6.93, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(64), 0.01);
    }

    @Test
    public void test_case_7() {
        assertEquals(10.39, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(216), 0.01);
    }

    @Test
    public void test_case_8() {
        assertEquals(17.32, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(1000), 0.01);
    }

    @Test
    public void test_case_9() {
        assertEquals(0.87, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(0.125), 0.01);
    }

    @Test
    public void test_case_10() {
        assertEquals(13.86, Task167_GEMINI_gemini_1_5_pro_001.cubeDiagonal(512), 0.01);
    }
}
