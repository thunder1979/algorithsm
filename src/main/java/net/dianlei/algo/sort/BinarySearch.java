package net.dianlei.algo.sort;

public class BinarySearch  {
    public int search(int[] a, int value) {
        int p = 0;
        int q = a.length - 1;
        while (p <= q) {
            int mid = (p + q)/2;
            if(a[mid] == value) {
                return mid;
            } else if(a[mid] < value) {
                p = mid + 1;
            } else {
                q = mid - 1;
            }
        }
        return - 1;
    }

    public int searchRecursively(int[] a, int value) {
        return search(a, value, 0, a.length - 1);
    }

    private int search(int[] a, int value, int p, int q) {
        if(p <= q) {
            int mid = (p + q)/2;
            if(a[mid] == value) {
                return mid;
            } else if(a[mid] < value) {
                return search(a, value, mid + 1, q);
            } else {
                return search(a, value, p, mid - 1);
            }
        }
        return -1;
    }
}
