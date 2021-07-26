package LeetCode;

/**
 * @author SalmonC
 * @date 2021-07-22 21:16
 */
public class HeapSort {
    public int[] heapSort(int[] arr, int k) {
        int len = arr.length;
        int[] heap = new int[len];
        for (int i = 0; i < len; i++) {
            add(heap, i, arr[i]);
        }
        for (int i = 0; i < k; i++) {
            removeMax(heap, i);
        }
        return heap;
    }

    public void add(int[] heap, int index, int num) {
        heap[index] = num;
        while (index > 0 && heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void removeMax(int[] heap, int len) {
        int n = heap.length - 1;
        if (len == n) {
            return;
        }
        swap(heap, 0, n - len);
        if(len < n-1) {
            for (int i = 0; i <= (n - len - 2) / 2; i = i) {
                int max = i * 2 + 1;
                max = max == n - len - 1 ? max : heap[max] >= heap[max + 1] ? max : max + 1;
                if (heap[i] < heap[max]) {
                    swap(heap, max, i);
                    i = max;
                } else {
                    break;
                }
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
