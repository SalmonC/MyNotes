package LeetCode;

import java.util.Arrays;

/**
 * @author SalmonC
 * @date 2021-07-19 23:46
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{1,5,3,2,5,7,7,34,15,2,12};
        MergeSort.mergeSort(test);
        for(int n : test) {
            System.out.print(n + ",");
        }
    }
    static void mergeSort(int... arr){
        int len = arr.length;
        int[] tmp = new int[len];
        sort(arr, 0, len-1, tmp);
    }
    static void sort(int[] arr, int l, int r, int[] tmp){
        if(l < r){
            int mid = l + (r - l) / 2;
            sort(arr, l, mid, tmp);
            sort(arr, mid+1, r, tmp);
            merge(arr, l, mid, r, tmp);
        }
    }
    static void merge(int[] arr, int l, int mid, int r, int[] tmp){
        int i = l, j = mid + 1, cur = l;
        while(i <= mid && j <= r){
            if(arr[i] <= arr[j]){
                tmp[l++] = arr[i++];
            }else{
                tmp[l++] = arr[j++];
            }
        }
        while(i <= mid){
            tmp[l++]= arr[i++];
        }
        while(j <= r){
            tmp[l++]= arr[j++];
        }
        for(int m = cur; cur <= r; cur++){
            arr[cur] = tmp[cur];
        }
    }
}
