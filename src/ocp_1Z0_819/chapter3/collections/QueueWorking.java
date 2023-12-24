package ocp_1Z0_819.chapter3.collections;

import java.util.*;

public class QueueWorking {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>(); // LinkedList could be replaced with ArrayDeque (out of scope of exam)
		
		print(queue.offer(1));
		print(queue.offer(2));
		print(queue.peek());
		print(queue.peek());

		print(queue.poll()); // removes element at the front of the queue
		print(queue.peek()); // peeks element at the front of the queue
		print(queue.poll()); 
		print(queue.peek()); // null 
	}


	public static void print(Object o) {
		System.out.println(o);
	}
}