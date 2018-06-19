package com.mrathena.java.util.concurrent.locks.basic.lockAndCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mrathena.toolkit.DateTimeKit;

import lombok.AllArgsConstructor;

// public Condition newCondition()
// 返回用来与此 Lock 实例一起使用的 Condition 实例。
// 在使用内置监视器锁时，返回的 Condition 实例支持与 Object 的监视器方法（wait、notify 和 notifyAll）相同的用法。
// ● 在调用 Condition、waiting 或 signalling 这些方法中的任意一个方法时，如果没有保持此锁，则将抛出 IllegalMonitorStateException。
// ● 在调用 waiting 条件方法时，将释放锁，并在这些方法返回之前，重新获取该锁，将锁保持计数恢复为调用方法时所持有的值。
// ● 如果线程在等待时被中断，则等待将终止，并将抛出 InterruptedException，清除线程的中断状态。
// ● 等待线程按 FIFO 顺序收到信号。
// ● 等待方法返回的线程重新获取锁的顺序与线程最初获取锁的顺序相同，在默认情况下，未指定此顺序，但对于公平锁，它们更倾向于那些等待时间最长的线程。

public class SingleConditionDemo {
	public static void main(String[] args) throws InterruptedException {
		SingleConditionService service = new SingleConditionService();
		SingleConditionThread a = new SingleConditionThread(service);
		a.start();
		Thread.sleep(3000);
		service.signal();
	}
}

class SingleConditionService {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

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

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal at " + DateTimeKit.now());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

}

@AllArgsConstructor
class SingleConditionThread extends Thread {

	private SingleConditionService service;

	@Override
	public void run() {
		service.await();
	}

}