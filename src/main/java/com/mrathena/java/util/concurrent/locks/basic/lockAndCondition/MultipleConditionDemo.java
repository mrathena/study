package com.mrathena.java.util.concurrent.locks.basic.lockAndCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.DateTimeKit;
import com.mrathena.toolkit.ThreadKit;

public class MultipleConditionDemo {
	public static void main(String[] args) {
		MultipleConditionService service = new MultipleConditionService();

		// thread和thread2会绑定在condition上,thread3和thread4会绑定在condtion2上
		MultipleConditionThread thread = new MultipleConditionThread("T1-1-1", 1, service);
		MultipleConditionThread thread2 = new MultipleConditionThread("T2-1-2", 1, service);
		MultipleConditionThread thread3 = new MultipleConditionThread("T3-2-1", 2, service);
		MultipleConditionThread thread4 = new MultipleConditionThread("T4-2-2", 2, service);

		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();

		ThreadKit.sleep(1000);
		// 唤醒condition上的一个线程
//		service.signal();
		ThreadKit.sleep(1000);
		// 唤醒condition2上的一个线程
//		service.signal2();
		// 唤醒condition上的所有线程
		ThreadKit.sleep(1000);
		service.signalAll();
		// 唤醒condition2上的所有线程
		ThreadKit.sleep(1000);
		service.signalAll2();

	}
}

class MultipleConditionService {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Condition condition2 = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("await begin at " + DateTimeKit.now());
			condition.await();
			System.out.println("await end at " + DateTimeKit.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void await2() {
		try {
			lock.lock();
			System.out.println("await2 begin at " + DateTimeKit.now());
			condition2.await();
			System.out.println("await2 end at " + DateTimeKit.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		try {
			lock.lock();
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void signal2() {
		try {
			lock.lock();
			condition2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll() {
		try {
			lock.lock();
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll2() {
		try {
			lock.lock();
			condition2.signalAll();
		} finally {
			lock.unlock();
		}
	}

}

class MultipleConditionThread extends Thread {

	private MultipleConditionService service;
	private int index;

	public MultipleConditionThread(String name, int index, MultipleConditionService service) {
		super(name);
		this.service = service;
		this.index = index;
	}

	@Override
	public void run() {
		switch (index) {
			case 1:
				service.await();
				break;
			case 2:
				service.await2();
				break;
			default:
				break;
		}
		System.out.println();
		System.out.println(ThreadKit.getName() + "恢复");
	}

}