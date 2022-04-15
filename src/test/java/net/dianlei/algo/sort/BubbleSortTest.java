package net.dianlei.algo.sort;

import net.dianlei.algo.sort.util.SortUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        int[] a = SortUtil.createRandomArray(50, 1000);
        int[] expected = SortUtil.copyArray(a);
        Arrays.sort(expected);
        SortUtil.printArray(a, "BubbleSort Before Sort");
        Sort sort = new BubbleSort();
        a= sort.sort(a);
        SortUtil.printArray(a, "BubbleSort After Sort");
        Assert.assertTrue(SortUtil.isEqual(expected, a));

//        Assert.assertTrue(SortUtil.isEqual(a, b));
//        Assert.assertTrue(SortUtil.isEqual(a, c));
//        Assert.assertTrue(SortUtil.isEqual(a, d));
//        Assert.assertTrue(SortUtil.isEqual(a, e));
//
//        SortUtil.printArray(a, "InsertionSort Before Sort");
//        Sortor sorter = new InsertionSort();
//        sorter.sort(a);
//        SortUtil.printArray(a, "InsertionSort After Sort");
//
//        SortUtil.printArray(b, "BubbleSort Before Sort");
//        sorter = new BubbleSort();
//        sorter.sort(b);
//        SortUtil.printArray(b, "BubbleSort After Sort");
//
//        SortUtil.printArray(c, "MergeSort Before Sort");
//        sorter = new MergeSort();
//        sorter.sort(c);
//        SortUtil.printArray(c, "MergeSort After Sort");
//
//        SortUtil.printArray(d, "HeapSort Before Sort");
//        sorter = new HeapSort();
//        sorter.sort(d);
//        SortUtil.printArray(d, "HeapSort After Sort");
//
//        SortUtil.printArray(e, "QuickSort Before Sort");
//        sorter = new QuickSort();
//        sorter.sort(e);
//        SortUtil.printArray(e, "QuickSort After Sort");
//
//        Assert.assertTrue(SortUtil.isEqual(a, b));
//        Assert.assertTrue(SortUtil.isEqual(a, c));
//        Assert.assertTrue(SortUtil.isEqual(a, d));
//        Assert.assertTrue(SortUtil.isEqual(a, e));
    }
}

//public class SortTest {
//    @Test
//    public void testInsertionSort() {
//        int[] a = SortUtil.createRandomArray(18, 1000);
//        int[] b = SortUtil.copyArray(a);
//        int[] c = SortUtil.copyArray(a);
//        int[] d = SortUtil.copyArray(a);
//        int[] e = SortUtil.copyArray(a);
//
//        Assert.assertTrue(SortUtil.isEqual(a, b));
//        Assert.assertTrue(SortUtil.isEqual(a, c));
//        Assert.assertTrue(SortUtil.isEqual(a, d));
//        Assert.assertTrue(SortUtil.isEqual(a, e));
//
//        SortUtil.printArray(a, "InsertionSort Before Sort");
//        Sortor sorter = new InsertionSort();
//        sorter.sort(a);
//        SortUtil.printArray(a, "InsertionSort After Sort");
//
//        SortUtil.printArray(b, "BubbleSort Before Sort");
//        sorter = new BubbleSort();
//        sorter.sort(b);
//        SortUtil.printArray(b, "BubbleSort After Sort");
//
//        SortUtil.printArray(c, "MergeSort Before Sort");
//        sorter = new MergeSort();
//        sorter.sort(c);
//        SortUtil.printArray(c, "MergeSort After Sort");
//
//        SortUtil.printArray(d, "HeapSort Before Sort");
//        sorter = new HeapSort();
//        sorter.sort(d);
//        SortUtil.printArray(d, "HeapSort After Sort");
//
//        SortUtil.printArray(e, "QuickSort Before Sort");
//        sorter = new QuickSort();
//        sorter.sort(e);
//        SortUtil.printArray(e, "QuickSort After Sort");
//
//        Assert.assertTrue(SortUtil.isEqual(a, b));
//        Assert.assertTrue(SortUtil.isEqual(a, c));
//        Assert.assertTrue(SortUtil.isEqual(a, d));
//        Assert.assertTrue(SortUtil.isEqual(a, e));
//    }
//}