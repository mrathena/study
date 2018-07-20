package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

	public static void main(String[] args) {
		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(3);
		System.out.println(atomicIntegerArray);

		// 小心数组越界
//		System.out.println(atomicIntegerArray.get(3));

		atomicIntegerArray.set(1, 100);
		System.out.println(atomicIntegerArray);
	}

}
