package codestral.task186;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task186Test {

    private Task186_MISTRAL_codestral_latest solution;

    @BeforeEach
    public void setUp() {
        solution = new Task186_MISTRAL_codestral_latest();
    }

    private ListNode createList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return dummy.next;
    }

    private void assertListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testExample1() {
        ListNode[] lists = new ListNode[] {
                createList(1, 4, 5),
                createList(1, 3, 4),
                createList(2, 6)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(1, 1, 2, 3, 4, 4, 5, 6);
        assertListEquals(expected, result);
    }

    @Test
    public void testExample2() {
        ListNode[] lists = new ListNode[] {};
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = null;
        assertListEquals(expected, result);
    }

    @Test
    public void testExample3() {
        ListNode[] lists = new ListNode[] { createList() };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = null;
        assertListEquals(expected, result);
    }

    @Test
    public void testSingleList() {
        ListNode[] lists = new ListNode[] { createList(1, 2, 3) };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(1, 2, 3);
        assertListEquals(expected, result);
    }

    @Test
    public void testAllEmptyLists() {
        ListNode[] lists = new ListNode[] {
                createList(),
                createList(),
                createList()
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = null;
        assertListEquals(expected, result);
    }

    @Test
    public void testOneEmptyList() {
        ListNode[] lists = new ListNode[] {
                createList(1, 2),
                createList(),
                createList(3, 4)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(1, 2, 3, 4);
        assertListEquals(expected, result);
    }

    @Test
    public void testMultipleLists() {
        ListNode[] lists = new ListNode[] {
                createList(1, 3, 5),
                createList(2, 4, 6),
                createList(0, 7, 8)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertListEquals(expected, result);
    }

    @Test
    public void testLargeLists() {
        ListNode[] lists = new ListNode[] {
                createList(1, 2, 3, 4, 5),
                createList(6, 7, 8, 9, 10),
                createList(11, 12, 13, 14, 15)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assertListEquals(expected, result);
    }

    @Test
    public void testNegativeNumbers() {
        ListNode[] lists = new ListNode[] {
                createList(-5, -3, 1),
                createList(-4, 2, 3),
                createList(-2, 0, 4)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(-5, -4, -3, -2, 0, 1, 2, 3, 4);
        assertListEquals(expected, result);
    }

    @Test
    public void testListsWithDuplicates() {
        ListNode[] lists = new ListNode[] {
                createList(1, 1, 2, 2),
                createList(1, 3, 4, 4),
                createList(0, 2, 5, 6)
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(0, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6);
        assertListEquals(expected, result);
    }
}
