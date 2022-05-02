package Learning;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue1 {
    public static void main(String[] args) {
        //Queue is interface
        DefineQueue();
        addelementToQueue();
        BlockingQueue();
        getElementFromQueue(2);
        getElementFromQueue(1);

    }

    public static void DefineQueue() {
        Queue<Integer> q = new LinkedList<>();
//        q = new LinkedList<>(int[] {1, 1, 2, 3, 5, 8})
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);
        q.addAll(q);
        System.out.println(q);
    }

    public static void addelementToQueue() {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);
        q1.add(70);
        q1.add(60);
        System.out.println("Elements in Queue:" + q1);
        //remove () method =>removes first element from the queue
        System.out.println("Element removed from the queue: " + q1.remove());
        //element() => returns head of the queue
        System.out.println("Head of the queue: " + q1.element());
        //poll () => removes and returns the head
        System.out.println("Poll():Returned Head of the queue: " + q1.poll());
        //returns head of the queue
        System.out.println("peek():Head of the queue: " + q1.peek());
        System.out.println("Adding to tail of Queue: " + q1.offer(100));
        //print the contents of the Queue
        System.out.println("Final Queue:" + q1);
        System.out.println("Size of Queue: " + q1.stream().count());
        System.out.println("Size of Queue: " + q1.stream().count());

    }

    public static void BlockingQueue() {
        BlockingQueue blockingQueue = new LinkedBlockingDeque(5);
        blockingQueue.add(10);
        blockingQueue.add(20);
        blockingQueue.add(30);
        blockingQueue.add(40);
        System.out.println(blockingQueue);
        try {
            blockingQueue.add(null);
            System.out.println(blockingQueue);
        } catch (NullPointerException e) {
            System.out.println("You have inserted null element");
        }
    }

    public static void getElementFromQueue(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        Iterator it = q.iterator();
        int count = 0;
        while (it.hasNext()) {
            Object e = it.next();
            if (count == index) {
                it.remove();
                System.out.println("Element at " + index + " is :" + e);
            }
            count++;
        }
    }
}
