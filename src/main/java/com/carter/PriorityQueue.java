package com.carter;

import java.util.Arrays;

/**
 * 最大
 * 优先级队列
 */
public class PriorityQueue {
    private int[] arr;
    private int size;

    public PriorityQueue() {
        arr = new int[32];
    }

    public void enQueue(int key) {
        if (size >= arr.length) {
            resize();
        }
        arr[size++] = key;
        upAdjust();
    }

    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("empty");
        }
        int head = arr[0];
        arr[0] = arr[--size];
        downAdjust();
        return head;
    }


    private void upAdjust() {
        int childIndex = this.size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = this.arr[childIndex];
        while (childIndex > 0 && temp > this.arr[parentIndex]) {
            this.arr[childIndex] = this.arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        this.arr[childIndex] = temp;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int temp = this.arr[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            if (childIndex + 1 < size && this.arr[childIndex] < this.arr[childIndex + 1]) {
                childIndex++;
            }
            if (temp > this.arr[childIndex]) {
                break;
            }
            this.arr[parentIndex] = this.arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        this.arr[parentIndex] = temp;
    }

    private void resize() {
        int newSize = this.size * 2;
        this.arr = Arrays.copyOf(this.arr, newSize);
    }

    public void print() {
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String... args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(0);
        priorityQueue.enQueue(21);
        priorityQueue.print();
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
    }
}
