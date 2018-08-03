package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	/*
	 * 内部:V, 就是泛型传入一个类型
	 */
	public static void main(String[] args) {
		AtomicReference<String> atomicReference = new AtomicReference<>("你好");
		System.out.println(atomicReference.get());

		atomicReference.set("我不好");
		System.out.println(atomicReference.get());

		System.out.println(atomicReference.compareAndSet("你好", "aaa"));
		System.out.println(atomicReference.compareAndSet("我不好", "aaa"));
	}

}
