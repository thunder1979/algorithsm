package net.dianlei.algo.sort;

import net.dianlei.algo.sort.Sort;

public class CountSort implements Sort {

    @Override
    public int[] sort(int[] a) {
        if(a.length < 1) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i ++) {
            max = a[i] > max? a[i] : max;
        }
        // slots for count each element in a[]
        int[] c = new int[max + 1];
        // count each element
        for(int i = 0; i < a.length; i ++) {
            c[a[i]] ++;
        }
        // calculate total count of current elements which is less than current element
        for(int i = 1; i < c.length;  i++){
            c[i] = c[i - 1] + c[i];
        }
        int b[] = new int[a.length];
        // copy the element from a[] to be to the right position
        for(int i = a.length - 1; i >= 0; i--) {
            // it's important to iterate element of a[] from end to keep the sort to be stable
            b[c[a[i]] - 1] = a[i];
            c[a[i]] --;
        }
        return b;
    }
}
