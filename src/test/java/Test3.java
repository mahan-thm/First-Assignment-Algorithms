import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test3 {
    static Exercises2 handle;

    @BeforeAll
    static void setUp() {
        handle = new Exercises2();
    }

    @Test
    void permuteTest1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2, 3));
        expected.add(List.of(2, 3, 1));
        expected.add(List.of(1, 3, 2));
        expected.add(List.of(3, 2, 1));
        expected.add(List.of(3, 1, 2));
        expected.add(List.of(2, 1, 3));
        List<List<Integer>> result = handle.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void permuteTest2() {
        int[] nums = {1, 2};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2));
        expected.add(List.of(2, 1));
        List<List<Integer>> result = handle.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void permuteTest3() {
        int[] nums = {1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));
        List<List<Integer>> result = handle.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

}