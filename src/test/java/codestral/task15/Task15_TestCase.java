package codestral.task15;

import org.junit.jupiter.api.Test;

import static codestral.task15.Task15_MISTRAL_codestral_latest.buildTower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class Task15_TestCase {


    @Test
    void testOneFloor() {
        List<String> expected = List.of("*");
        assertEquals(expected, buildTower(1));
    }

    @Test
    void testTwoFloors() {
        List<String> expected = List.of(
                " * ",
                "***"
        );
        assertEquals(expected, buildTower(2));
    }

    @Test
    void testThreeFloors() {
        List<String> expected = List.of(
                "  *  ",
                " *** ",
                "*****"
        );
        assertEquals(expected, buildTower(3));
    }

    @Test
    void testFourFloors() {
        List<String> expected = List.of(
                "   *   ",
                "  ***  ",
                " ***** ",
                "*******"
        );
        assertEquals(expected, buildTower(4));
    }

    @Test
    void testFiveFloors() {
        List<String> expected = List.of(
                "    *    ",
                "   ***   ",
                "  *****  ",
                " ******* ",
                "*********"
        );
        assertEquals(expected, buildTower(5));
    }

    @Test
    void testSixFloors() {
        List<String> expected = List.of(
                "     *     ",
                "    ***    ",
                "   *****   ",
                "  *******  ",
                " ********* ",
                "***********"
        );
        assertEquals(expected, buildTower(6));
    }

    @Test
    void testSevenFloors() {
        List<String> expected = List.of(
                "      *      ",
                "     ***     ",
                "    *****    ",
                "   *******   ",
                "  *********  ",
                " *********** ",
                "*************"
        );
        assertEquals(expected, buildTower(7));
    }

    @Test
    void testEightFloors() {
        List<String> expected = List.of(
                "       *       ",
                "      ***      ",
                "     *****     ",
                "    *******    ",
                "   *********   ",
                "  ***********  ",
                " ************* ",
                "***************"
        );
        assertEquals(expected, buildTower(8));
    }

    @Test
    void testNineFloors() {
        List<String> expected = List.of(
                "        *        ",
                "       ***       ",
                "      *****      ",
                "     *******     ",
                "    *********    ",
                "   ***********   ",
                "  *************  ",
                " *************** ",
                "*****************"
        );
        assertEquals(expected, buildTower(9));
    }

    @Test
    void testTenFloors() {
        List<String> expected = List.of(
                "         *         ",
                "        ***        ",
                "       *****       ",
                "      *******      ",
                "     *********     ",
                "    ***********    ",
                "   *************   ",
                "  ***************  ",
                " ***************** ",
                "*******************"
        );
        assertEquals(expected, buildTower(10));
    }
}

