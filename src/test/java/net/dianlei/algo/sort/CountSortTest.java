package net.dianlei.algo.sort;

import net.dianlei.algo.sort.util.SortUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CountSortTest {

    @Test
    public void testSort() {
        for (int i = 0; i < 1000; i++) {
            int[] a = SortUtil.createRandomArray(50, 100);
            // int[] a = new int[] {51,31,23,19,5,3,4,62,96 };
            int[] expected = SortUtil.copyArray(a);
            Arrays.sort(expected);
            SortUtil.printArray(a, "CountSort Before Sort");
            Sort sort = new CountSort();
            int[] b = sort.sort(a);
            SortUtil.printArray(b, "CountSort After Sort");
            Assert.assertTrue(SortUtil.isEqual(expected, b));
        }
    }
}
