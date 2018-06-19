package com.mrathena.java.util.concurrent.locks.basic.fairAndUnfair;

import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.ThreadKit;

/**
 * 锁公平性demo
 * @author mrathena on 2018-06-19 17:19:42.530
 */
public class LockFairnessDemo {

	public static void main(String[] args) {
		LockFairnessService service = new LockFairnessService(true);
//		LockFairnessService service = new LockFairnessService(false);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.fairnessTest();
			}
		};

		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}

	}

}

class LockFairnessService {

	private ReentrantLock lock;

	public LockFairnessService(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void fairnessTest() {
		try {
			lock.lock();
			System.out.println(ThreadKit.getName() + " get the lock");
//			if (lock.isFair()) {
//				System.out.println(ThreadKit.getName() + " is fair lock");
//			} else {
//				System.out.println(ThreadKit.getName() + " is unfair lock");
//			}
		} finally {
			lock.unlock();
			System.out.println();
		}
	}

}