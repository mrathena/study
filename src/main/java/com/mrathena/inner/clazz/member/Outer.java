package com.mrathena.inner.clazz.member;

public class Outer {

	public Inner instance = null;

	public Inner getInner() {
		if (instance == null) {
			instance = new Inner();
		}
		return instance;
	}

	private int age = 15;
	private int age2 = 15;
	public static final String name = "mrathena";

	public void test() {
		System.out.println("outer");
	}

	public void 外部类访问内部类的成员变量() {
		Inner memberInnerClass = new Inner();
		System.out.println(memberInnerClass.age);
	}

	/**
	 * 成员内部类
	 */
	class Inner {

		// 成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象
		private int age = 16;

		public void test() {
			// 外部类的private成员
			// 这个age是内部类的age, 而不是外部类的age
			System.out.println(age);
			System.out.println(age2);
			// 外部类的static成员
			System.out.println(name);
		}

		public void 内部类访问外部类的同名成员变量和方法() {
			System.out.println(Outer.this.age);
			Outer.this.test();
		}
	}

}
