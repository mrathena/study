package com.mrathena.java.util.concurrent.locks.basic.fairAndUnfair;

import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.ThreadKit;

/**
 * 锁公平性demo
 * @author mrathena on 2018-06-19 17:19:42.530
 */
public class LockFairnessDemo {

	// 这个例子并不太好,看不出明显的效果

	public static void main(String[] args) {
		LockFairnessService service = new LockFairnessService(true);
//		LockFairnessService service = new LockFairnessService(false);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.fairnessTest();
			}
		};

		Thread[] threadArray = new Thread[100];
		for (int i = 0; i < 100; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 100; i++) {
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