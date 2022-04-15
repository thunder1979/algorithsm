package net.dianlei.algo.sort;

public class BucketSort implements Sort {

    @Override
    public int[] sort(int[] a) {

        Link[] buckets = new Link[10];
        int[] intSizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
        for (int i = 0; i < a.length; i++) {
            int bucketNum = 0;
            for (int j = 0; ; j++) {
                if (a[i] <= intSizeTable[j]) {
                    bucketNum = j + 1;
                    break;
                }
            }
            Link link = new Link();
            link.value = a[i];
            if (buckets[bucketNum] == null) {
                buckets[bucketNum] = link;
            } else {
                Link tmpLink = buckets[bucketNum];
                while (tmpLink.next != null) {
                    tmpLink = tmpLink.next;
                }
                tmpLink.next = link;
                link.pre = tmpLink;
            }
        }

        // sort each bucket using insertion sort
        for (int k = 0; k < 10; k++) {
            Link currentLink = buckets[k];
            while (currentLink != null) {
                Link tmpLink = currentLink;
                int currentValue = currentLink.value;
                while(tmpLink.pre != null && currentValue < tmpLink.pre.value) {
                    tmpLink.value = tmpLink.pre.value;
                    tmpLink = tmpLink.pre;
                }
                tmpLink.value = currentValue;
                currentLink = currentLink.next;
            }
        }

        // collect elements from each bucket and copy back to right position of a[]
        int idx = 0;
        for (int k = 0; k < 10; k++) {
            Link tmpLink = buckets[k];
            while (tmpLink != null) {
                a[idx] = tmpLink.value;
                idx ++;
                tmpLink = tmpLink.next;
            }
        }
        return a;
    }
}

class Link {
    Link pre;
    int value;
    Link next;
}
