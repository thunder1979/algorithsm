package net.dianlei.algo.sort;

import net.dianlei.algo.sort.util.SortUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        for (int i = 0; i < 20; i++) {
            int a[] = SortUtil.createRandomArray(50, 100);
            BubbleSort bubble = new BubbleSort();
            bubble.sort(a);
            int key = (int) (100 * Math.random());
            SortUtil.printArray(a, "Array");
            BinarySearch bs = new BinarySearch();
            int idx = Arrays.binarySearch(a, key);
            int idx1 = bs.search(a, key);
            int idx2 = bs.searchRecursively(a, key);
            System.out.println("key=" + key + " idx=" + idx + " idx1=" + idx1 + " idx2=" + idx2);
            if(idx >= 0 ) {
                Assert.assertEquals(idx, idx1);
                Assert.assertEquals(idx, idx2);
            } else {
                Assert.assertEquals(idx1, -1);
                Assert.assertEquals(idx2, -1);
            }



            // boundary test
            key = a[0];
            idx = Arrays.binarySearch(a, key);
            idx1 = bs.search(a, key);
            idx2 = bs.searchRecursively(a, key);
            System.out.println("key=" + key + " idx1=" + idx1 + " idx2=" + idx2);
            if(idx >= 0 ) {
                Assert.assertEquals(idx, idx1);
                Assert.assertEquals(idx, idx2);
            } else {
                Assert.assertEquals(idx1, -1);
                Assert.assertEquals(idx2, -1);
            }

            key = a[a.length-1];
            idx = Arrays.binarySearch(a, key);
            idx1 = bs.search(a, key);
            idx2 = bs.searchRecursively(a, key);
            System.out.println("key=" + key + " idx=" + idx + " idx1=" + idx1 + " idx2=" + idx2);
            if(idx >= 0 ) {
                Assert.assertEquals(idx, idx1);
                Assert.assertEquals(idx, idx2);
            } else {
                Assert.assertEquals(idx1, -1);
                Assert.assertEquals(idx2, -1);
            }
        }
    }
}
