package LeetCode;

import java.util.LinkedList;

/**
 * @author SalmonC
 * @date 2021-06-07 17:37
 */
public class KuaiPai {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,5,2,3,5,6,4,32,5,7,8,9,2};
        so(input, 0, input.length-1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void so(int[] input, int low, int high){
        if(low >= high) {
            return;
        }
        int l = low + 1;
        int r = high;
        int target = input[low];
        while(l < r){
            while(r > l && input[r] >= target){
                r--;
            }
            while(r > l && input[l] <= target){
                l++;
            }
            if(input[l] > input[r]){
                int tmp = input[l];
                input[l] = input[r];
                input[r] = tmp;
            }
        }
        if(target > input[l]){
        input[low] = input[l];
        input[l] = target;
        }
        so(input, low, l-1);
        so(input, l+1, high);
    }
}
