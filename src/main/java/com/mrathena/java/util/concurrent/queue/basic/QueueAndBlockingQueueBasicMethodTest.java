package com.mrathena.java.util.concurrent.queue.basic;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.mrathena.toolkit.ThreadKit;

public class QueueAndBlockingQueueBasicMethodTest {

	public static void main(String[] args) {

		// 队列的非阻塞方法: Queue接口定义了6个非阻塞队列方法, add, offer, remove, poll, element, peek
		// 队列的阻塞方法: BlockingQueue继承Queue, put, take, offer(E e,long timeout, TimeUnit unit), poll(long timeout, TimeUnit unit)

		// 方法\处理方式 抛出异常 返回特殊值 一直阻塞 超时阻塞退出
		// 插入方法 add(e) offer(e) put(e) offer(e,time,unit)
		// 移除方法 remove() poll() take() poll(time,unit)
		// 检查方法 element() peek() 不可用 不可用

		String element = "TEST";

		// 非阻塞队列方法测试
		System.out.println("非阻塞队列方法测试");
		System.out.println("-------------------------------------------------------------------------");

		// add(E e):将元素e插入到队列末尾，如果插入成功，则返回true；如果插入失败（即队列已满），则会抛出异常；java.lang.IllegalStateException: Queue full
		System.out.println("第一个有界非阻塞队列, 测试 add(E e)");
		Queue<String> queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		System.out.println(queue.add(element));
		System.out.println(queue);
		try {
			System.out.println(queue.add(element));
			System.out.println(queue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// offer(E e)：将元素e插入到队列末尾，如果插入成功，则返回true；如果插入失败（即队列已满），则返回false；
		System.out.println("第二个有界非阻塞队列, 测试 offer(E e)");
		queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		System.out.println(queue.offer(element));
		System.out.println(queue);
		System.out.println(queue.offer(element));
		System.out.println(queue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// remove()：获取并移除队首元素，若移除成功，则返回true；如果移除失败（队列为空），则会抛出异常；java.util.NoSuchElementException
		System.out.println("第三个有界非阻塞队列, 测试 remove()");
		queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		System.out.println(queue.offer(element));
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		try {
			System.out.println(queue.remove());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(queue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// poll()：获取并移除队首元素，若成功，则返回队首元素；否则返回null；
		System.out.println("第四个有界非阻塞队列, 测试 poll()");
		queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		System.out.println(queue.offer(element));
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// element()：获取队首元素(不移除)，若成功，则返回队首元素；否则抛出异常; java.util.NoSuchElementException
		System.out.println("第五个有界非阻塞队列, 测试 element()");
		queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		// System.out.println(queue.offer(element));
		System.out.println(queue);
		try {
			System.out.println(queue.element());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(queue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// peek()：获取队首元素(不移除)，若成功，则返回队首元素；否则返回null
		System.out.println("第六个有界非阻塞队列, 测试 peek()");
		queue = new ArrayBlockingQueue<>(1);
		System.out.println(queue);
		System.out.println(queue.offer(element));
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// 阻塞队列方法测试
		System.out.println("阻塞队列方法测试");
		System.out.println("-------------------------------------------------------------------------");

		// put(E e)方法用来向队尾存入元素，如果队列满，则等待；没有返回值
		System.out.println("第一个有界阻塞队列, 测试 peek()");
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
		System.out.println(blockingQueue);
		try {
			blockingQueue.put(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(blockingQueue);
//		try {
//			blockingQueue.put(element);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(blockingQueue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// take()方法用来从队首取元素，如果队列为空，则等待；
		System.out.println("第二个有界阻塞队列, 测试 take()");
		blockingQueue = new ArrayBlockingQueue<>(1);
		System.out.println(blockingQueue);
//		try {
//			System.out.println(blockingQueue.take());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(blockingQueue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// offer(E e,long timeout, TimeUnit unit)方法用来向队尾存入元素，如果队列满，则等待一定的时间，当时间期限达到时，如果还没有插入成功，则返回false；否则返回true；
		System.out.println("第三个有界阻塞队列, 测试 offer(e,timeout,unit)");
		blockingQueue = new ArrayBlockingQueue<>(1);
		System.out.println(blockingQueue);
		try {
			System.out.println(blockingQueue.offer(element, 1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(blockingQueue);
		try {
			System.out.println(blockingQueue.offer(element, 2, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(blockingQueue);
		ThreadKit.sleep(1);
		System.out.println("-------------------------------------------------------------------------");

		// poll(long timeout, TimeUnit unit)方法用来从队首取元素，如果队列空，则等待一定的时间，当时间期限达到时，如果取到，则返回null；否则返回取得的元素；
		System.out.println("第四个有界阻塞队列, 测试 poll(timeout,unit)");
		blockingQueue = new ArrayBlockingQueue<>(1);
		System.out.println(blockingQueue);
		try {
			System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(blockingQueue);
	}

}
