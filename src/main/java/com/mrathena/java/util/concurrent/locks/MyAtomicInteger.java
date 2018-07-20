package com.mrathena.java.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyAtomicInteger {

	// 模拟AtomicInteger内部维护的value
	private int value;

	private Lock lock = new ReentrantLock();

	public MyAtomicInteger() {
		super();
	}

	public MyAtomicInteger(int value) {
		super();
		this.value = value;
	}

	public final int get() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}

	public final void set(int newValue) {
		lock.lock();
		try {
			value = newValue;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndSet(int newValue) {
		lock.lock();
		try {
			int oldValue = this.value;
			value = newValue;
			return oldValue;
		} finally {
			lock.unlock();
		}
	}

	public final boolean compareAndSet(int expired, int newValue) {
		lock.lock();
		try {
			int oldValue = value;
			if (expired == oldValue) {
				value = newValue;
				return true;
			}
			return false;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndIncrement() {
		lock.lock();
		try {
			return value++;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndDecrement() {
		lock.lock();
		try {
			return value--;
		} finally {
			lock.unlock();
		}
	}

	public final int incrementAndGet() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}

	public final int decrementAndGet() {
		lock.lock();
		try {
			return value--;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public final String toString() {
		return Integer.toString(value);
	}

}
