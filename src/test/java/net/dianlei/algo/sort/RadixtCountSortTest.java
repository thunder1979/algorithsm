package net.dianlei.algo.sort;

import net.dianlei.algo.sort.util.SortUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RadixtCountSortTest {

    @Test
    public void testSort() {

        for (int i = 0; i < 1000; i++) {
            int[] a = SortUtil.createRandomArray(50, 100000);
            // int[] a = new int[] {63,73,71,83,93,8,52,39,17,92,52,14,70,88,61,37,76,3,13,10,8,74,67,96,31,93,36,55,76,2,8,71,58,15, };
            int[] expected = SortUtil.copyArray(a);
            Arrays.sort(expected);
            SortUtil.printArray(a, "RadixSort Before Sort");
            Sort sort = new RadixCountSort();
            int[] b = sort.sort(a);
            SortUtil.printArray(b, "RadixSort After Sort");
            Assert.assertTrue(SortUtil.isEqual(expected, b));
        }
    }
}
