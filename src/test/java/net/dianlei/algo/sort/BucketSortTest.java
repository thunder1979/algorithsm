package net.dianlei.algo.sort;

import net.dianlei.algo.sort.util.SortUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BucketSortTest {

    @Test
    public void testSort() {
         for (int i = 0; i < 1000; i++) {
            int[] a = SortUtil.createRandomArray(50, 1000000);
            // int[] a = new int[] {44599,7440,31002,71283,5976,2756,82413,14026,20907,90473,53077,41607,83615,68740,25072,3887,56540,54833,8660,25613,39677,10048,65622,39135,59591,7022,16222};
            int[] expected = SortUtil.copyArray(a);
            Arrays.sort(expected);
            SortUtil.printArray(a, "BucketSort Before Sort");
            Sort sort = new BucketSort();
            int[] b = sort.sort(a);
            SortUtil.printArray(b, "BucketSort After Sort");
            Assert.assertTrue(SortUtil.isEqual(expected, b));
         }
    }
}
