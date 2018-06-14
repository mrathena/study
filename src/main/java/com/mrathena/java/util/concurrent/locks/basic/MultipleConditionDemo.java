package com.mrathena.java.util.concurrent.locks.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.DateTimeKit;

public class MultipleConditionDemo {
	public static void main(String[] args) {

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

}