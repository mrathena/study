package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

	/*
	 * 内部:int[], 原子操作针对数组里面的每一项, 而不是这个数组本身, 注意IndexOutOfBoundsException
	 */
	public static void main(String[] args) {
		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(3);
		System.out.println(atomicIntegerArray);

		// 小心数组越界
//		System.out.println(atomicIntegerArray.get(3));

		atomicIntegerArray.set(1, 100);
		System.out.println(atomicIntegerArray);
	}

}
