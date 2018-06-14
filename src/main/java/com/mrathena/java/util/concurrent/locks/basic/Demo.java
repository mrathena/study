package com.mrathena.java.util.concurrent.locks.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.DateTimeKit;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// 单condition
//		MyService service = new MyService();
//		MyThread a = new MyThread(service);
//		a.start();
//		Thread.sleep(3000);
//		service.signal();
		// 多condition
		MyService2 service = new MyService2();
		MyThread2 a = new MyThread2(service);
		a.setName("A");
		a.start();
		MyThread2 b = new MyThread2(service);
		b.setName("B");
		b.start();
		Thread.sleep(3000);
		service.signalAll_A();
	}

}

class MyService {

	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("begin await " + DateTimeKit.now());
			condition.await();
			System.out.println("end await " + DateTimeKit.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal " + DateTimeKit.now());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

}

class MyThread extends Thread {

	private SingleConditionService service;

	public MyThread(SingleConditionService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.await();
	}

}

class MyService2 {

	// 可以使用多个Condition实现通知部分线程的用法

	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();
	public Condition condition2 = lock.newCondition();

	public void awaitA() {
		try {
			String threadName = Thread.currentThread().getName();
			lock.lock();
			System.out.println("begin awaitA " + DateTimeKit.now() + " ThreadName=" + threadName);
			condition.await();
			System.out.println("  end awaitA " + DateTimeKit.now() + " ThreadName=" + threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void awaitB() {
		try {
			String threadName = Thread.currentThread().getName();
			lock.lock();
			System.out.println("begin awaitB " + DateTimeKit.now() + " ThreadName=" + threadName);
			condition2.await();
			System.out.println("  end awaitB " + DateTimeKit.now() + " ThreadName=" + threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll_A() {
		try {
			String threadName = Thread.currentThread().getName();
			lock.lock();
			System.out.println("signalAll_A " + DateTimeKit.now() + " ThreadName=" + threadName);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll_B() {
		try {
			String threadName = Thread.currentThread().getName();
			lock.lock();
			System.out.println("signalAll_B " + DateTimeKit.now() + " ThreadName=" + threadName);
			condition2.signalAll();
		} finally {
			lock.unlock();
		}
	}
}

class MyThread2 extends Thread {

	private MyService2 service;

	public MyThread2(MyService2 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}
