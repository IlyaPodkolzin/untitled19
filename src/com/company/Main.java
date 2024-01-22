package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void splitStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        Queue<Integer> queue = new LinkedList<>();
        int size = stack.size();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            if (queue.peek() < 0) {
                stack.add(queue.poll());
            } else {
                queue.add(queue.poll());
            }
        }

        while (!queue.isEmpty()) {
            stack.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(-1);
        stack.add(21);
        stack.add(0);
        stack.add(-991);
        stack.add(-8881);

        System.out.println(stack);
        splitStack(stack);
        System.out.println(stack);
    }
}
