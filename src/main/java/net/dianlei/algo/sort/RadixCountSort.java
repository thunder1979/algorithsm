package net.dianlei.algo.sort;

/**
 * To reduce the space of Bucket Sort, combine logic of count sort and bucket sort
 * Suppose there n digits of the numbers to be sorted
 * There will be n rounds of sorting.
 * For each round:
 *  1) for each element from input a[], derive the bucket number
 *  2) for that bucket, total number + 1
 *  3) for each element from input a[], copy it to the right position of temp array
 *  4) switch input a[] with temp array
 *  5) next round
 *
 */
public class RadixCountSort implements Sort {

    @Override
    public int[] sort(int[] a) {
        if (a.length < 1) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = a[i] > max ? a[i] : max;
        }
        int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; ; i++) {
            if (max <= sizeTable[i]) {
                maxLen = i + 1;
                break;
            }
        }
        int[] b = new int[a.length]; // intermedia result of each round of sorting
        int[] bucketSize = new int[10];
        int m = 1;
        for(int i = 0; i < maxLen; i++) {
            m = m * 10;
            int bucketNum;
            for(int j = 0; j < a.length; j ++) {
                bucketNum = (a[j] % m)/(m/10);
                bucketSize[bucketNum] ++;
            }
            // Accumulate total number of element before current bucket, which is absolute position of the element
            for(int j = 1; j < 10; j ++) {
                bucketSize[j] = bucketSize[j] + bucketSize[j-1];
            }
            for(int j = a.length - 1; j >= 0; j--) {
                // iterate the a[] from back to end to keep the stability of sorting which is critical to make sure Bucket sort works
                bucketNum = (a[j] % m)/(m/10);
                b[bucketSize[bucketNum] - 1] = a[j];
                bucketSize[bucketNum] --;
            }
            // clean bucket size for next round
            for(int j = 0; j < 10; j ++) {
                bucketSize[j] = 0;
            }
            // next round sort should be based on intermedia result b[]
            a = b;
        }
        return a;
    }
}
