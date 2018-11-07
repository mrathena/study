package com.mrathena.inner.clazz.local;

public class Test {

	// 说明 为什么局部内部类和匿名内部类只能访问局部final变量？

	public void test() {
		final int a = 11;
		new Thread() {
			@Override
			public void run() {
				System.out.println(a);
			};
		}.start();
	}

	public void test2(final int b) {
		new Thread() {
			@Override
			public void run() {
				System.out.println(b);
			};
		}.start();
	}

	// 编译结果是 Test.class, Test$1.class, Test$2.class

}
