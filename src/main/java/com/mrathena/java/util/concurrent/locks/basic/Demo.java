package com.mrathena.java.util.concurrent.locks.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.DateTimeKit;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		MyThread a = new MyThread(service);
		a.start();
		Thread.sleep(3000);
		service.signal();
	}

}

class MyService {

	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("await " + DateTimeKit.now());
			condition.await();
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

	private MyService service;

	public MyThread(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.await();
	}
}
