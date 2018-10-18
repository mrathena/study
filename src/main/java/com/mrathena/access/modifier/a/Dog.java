package com.mrathena.access.modifier.a;

/**
 * 同包.子类
 */
public class Dog extends Animal {

	/**
	 * [public]修饰的属性和方法[可以]在[同包.子类]中访问
	 */
	public static void public_test() {
		Animal animal = new Animal();
		System.out.println(animal.publicFiled);
		animal.publicMethod();
	}

	/**
	 * [protected]修饰的属性和方法[可以]在[同包.子类]中访问
	 */
	public static void protected_test() {
		Animal animal = new Animal();
		System.out.println(animal.protectedFiled);
		animal.protectedMethod();
	}

	/**
	 * [default]修饰的属性和方法[可以]在[同包.子类]中访问
	 */
	public static void default_test() {
		Animal animal = new Animal();
		System.out.println(animal.defaultFiled);
		animal.defaultMethod();
	}

	/**
	 * [private]修饰的属性和方法[不可以]在[同包.子类]中访问
	 */
	public static void private_test() {
		Animal animal = new Animal();
//		System.out.println(animal.privateFiled);
//		animal.privateMethod();
	}

	/**
	 * 子类专属
	 * super.xxx
	 */
	public void test() {
		System.out.println(super.publicFiled);
		System.out.println(super.protectedFiled);
		System.out.println(super.defaultFiled);
//		System.out.println(super.privateFiled);
		super.publicMethod();
		super.protectedMethod();
		super.defaultMethod();
//		super.privateMethod();
	}

}
