package LeetCode;

import java.util.LinkedList;

/**
 * @author SalmonC
 * @date 2021-07-20 23:09
 */
public class StackSample<T> {
    private Node<T> head;
    private int N;

    public StackSample(Node<T> head, int n) {
        this.head = head;
        N = n;
    }

    public StackSample() {
        this.head = new Node();
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node<T> cur = head;
        head = head.next;
        N--;
        return cur.value;
    }

    public void push(T value){
        Node<T> cur = new Node(value);
        cur.next = head;
        head = cur;
        N++;
    }

    private class Node<T> {
        public T value;
        public Node<T> next;

        private Node(){
            value = null;
            next = null;
        }
        private Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
