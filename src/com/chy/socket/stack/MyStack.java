package com.chy.socket.stack;

import java.util.Arrays;

/**
 * @author chy
 * @title: MyStack
 * @projectName test
 * @description: 手撕栈源码
 * @date 2021/1/27上午 11:04
 */
public class MyStack {
    //存储数组
    private int[] storage;
    //stack容量
    private int capacity;
    //数组中现有元素数量
    private int count;
    private static final int GROW_FACTOR = 2;

    public MyStack() {
        this.capacity = 8;
        this.storage = new int[8];
        this.count = 0;
    }

    public MyStack(int initCapacity) {
        if (initCapacity < 1) {
            throw new IllegalArgumentException("Stack is too small");
        }
        this.capacity = initCapacity;
        this.storage = new int[initCapacity];
        this.count = 0;
    }

    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    private void push(int value) {
        if (value == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    private int pop() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        count--;
        return storage[count];
    }

    private int peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return storage[count - 1];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private int size() {
        return count;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(3);
        myStack.push(5);
        myStack.push(3);
        myStack.push(9);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
    }

}
