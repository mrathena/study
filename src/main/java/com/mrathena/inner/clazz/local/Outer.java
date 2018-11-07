package com.mrathena.inner.clazz.local;

public class Outer {

	public static void main(String[] args) {
		getInner();
	}

	public static void getInner() {
		// 局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的

		class Inner {
			private int age = 15;
		}

		Inner inner = new Inner();
		System.out.println(inner.age);
	}

}
