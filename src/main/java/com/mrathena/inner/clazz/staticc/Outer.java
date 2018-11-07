package com.mrathena.inner.clazz.staticc;

public class Outer {

	private int age = 15;

	public int getAge() {
		return age;
	}

	static class Inner {
		public Inner() {
//			System.out.println(age);
		}
	}

}
