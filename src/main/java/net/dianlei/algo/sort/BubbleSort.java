package net.dianlei.algo.sort;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int a[]) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length -1; j++) {
                if(a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }
}
