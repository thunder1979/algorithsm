package net.dianlei.algo.sort;

public class RadixSort implements Sort {

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

        int[][] buckets = new int[10][a.length];
        int[] bucketSize = new int[10];
        int m = 1; // 10^(i+1), a[j] modulo m to get reminder, reminder / 10^(i-1) = i-th digit of a[i]
        for(int i = 0; i < maxLen; i++) {
            m = m * 10;
            for(int j = 0; j < a.length; j++) {
                int bucketNum = (a[j] % m)/(m/10);
                buckets[bucketNum][bucketSize[bucketNum]] = a[j];
                bucketSize[bucketNum] ++;
            }
            // i-th round of sorting
            int idx = 0; // index of the input a[]
            for(int k = 0; k < 10; k++) {
                for(int l = 0; l < bucketSize[k]; l++) {
                 a[idx] = buckets[k][l];
                 idx ++;
                }
            }
            // clean bucket
            for(int k = 0; k < 10; k++) {
                bucketSize[k] = 0;
            }
        }
        return a;
    }
}
