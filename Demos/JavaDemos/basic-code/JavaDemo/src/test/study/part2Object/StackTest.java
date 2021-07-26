package test.study.part2Object;

import LeetCode.HeapSort;
import org.junit.Test;
import LeetCode.StackSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SalmonC
 * @date 2021-07-20 23:34
 */
public class StackTest {
    @Test
    public void st(){
        StackSample<Integer> s = new StackSample<>();
        s.push(1);
        s.push(2);
        s.push(123);
        s.push(563);
        s.push(327);
        for (int i = 0; i < 5; i++) {
            System.out.print("size = " + s.size() + ", value = " + s.pop()+ ",");
        }
    }
    @Test
    public void lltest(){
        LinkedList<Integer> l = new LinkedList<>();
        l.push(1);
        l.push(2);
        l.push(3);
        l.offer(4);
        l.offer(5);
        while (!l.isEmpty()){
            System.out.print(l.pop() + ",");
        }
    }
    @Test
    public void arrTest(){
        int[] a = new int[]{1,2,3};
        List<Integer> arr = Arrays.asList(1,3,2);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
            //System.arraycopy();
        }
    }

    @Test
    public void heapSortTest(){
        HeapSort hs = new HeapSort();
        int[] ans = hs.heapSort(new int[]{4,2,3,5,7,9,5,12,532}, 7);
        int[] ans1 = hs.heapSort(new int[]{4,2,3,5,7,9,5,12,532}, 8);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println("");
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + ",");
        }
    }

    @Test
    public void copyOfRangeTest(){
        int[] t = new int[]{0,1,2,3,4,5};
        int[] c = Arrays.copyOfRange(t, 0, 5);
        for(int n : c){
            System.out.print(n+",");
        }
    }

    @Test
    public void inttest1(){
        Integer a = new Integer(5);
        System.out.println(a);
    }

    public void inttest2(Integer a){
        a = new Integer(6);
    }
}
