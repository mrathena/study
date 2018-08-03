package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {

	/*
	 * 内部:int, 值=1代表true, 否则代表false
	 */
	public static void main(String[] args) {
		AtomicBoolean atomicBoolean = new AtomicBoolean();
		System.out.println(atomicBoolean.get());

		atomicBoolean.set(true);
		System.out.println(atomicBoolean.get());

		atomicBoolean.compareAndSet(false, false);
		System.out.println(atomicBoolean.get());
		atomicBoolean.compareAndSet(true, false);
		System.out.println(atomicBoolean.get());

		System.out.println(atomicBoolean.getAndSet(true));
		System.out.println(atomicBoolean.get());

	}

}
