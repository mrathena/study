package com.mrathena.java.util.concurrent.locks.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.ThreadKit;

public class ThreeThreadRelayDemo {
	public static void main(String[] args) {
		ThreeThreadRelayService service = new ThreeThreadRelayService();

		ThreeThreadRelayThread thread = new ThreeThreadRelayThread("T1", 1, service);
		ThreeThreadRelayThread thread2 = new ThreeThreadRelayThread("T2", 2, service);
		ThreeThreadRelayThread thread3 = new ThreeThreadRelayThread("T3", 3, service);

		thread.start();
		thread2.start();
		thread3.start();

		service.signal(1);

	}
}

class ThreeThreadRelayService {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	public void await(int index) {
		lock.lock();
		try {
			switch (index) {
				case 1:
					condition.await();
					break;
				case 2:
					condition2.await();
					break;
				case 3:
					condition3.await();
					break;
				default:
					condition.await();
					condition2.await();
					condition3.await();
					break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal(int index) {
		lock.lock();
		try {
			switch (index) {
				case 1:
					condition.signal();
					break;
				case 2:
					condition2.signal();
					break;
				case 3:
					condition3.signal();
					break;
				default:
					condition.signal();
					condition2.signal();
					condition3.signal();
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

class ThreeThreadRelayThread extends Thread {

	private ThreeThreadRelayService service;
	private int index;

	public ThreeThreadRelayThread(String name, int index, ThreeThreadRelayService service) {
		super(name);
		this.service = service;
		this.index = index;
	}

	@Override
	public void run() {
		service.await(index);
		System.out.println(ThreadKit.getName() + "起跑");
		ThreadKit.sleep(1000);
		System.out.println(ThreadKit.getName() + "跑完了");
	}

}