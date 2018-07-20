package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	public static void main(String[] args) {
		AtomicReference<String> atomicReference = new AtomicReference<>("你好");
		System.out.println(atomicReference.get());

		atomicReference.set("我不好");
		System.out.println(atomicReference.get());
	}

}
