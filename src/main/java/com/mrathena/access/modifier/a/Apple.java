package com.mrathena.access.modifier.a;

/**
 * 同包.非子类
 */
public class Apple {

	/**
	 * [public]修饰的属性和方法[可以]在[同包.非子类]中访问
	 */
	public static void public_test() {
		Animal animal = new Animal();
		System.out.println(animal.publicFiled);
		animal.publicMethod();
	}

	/**
	 * [protected]修饰的属性和方法[可以]在[同包.非子类]中访问
	 */
	public static void protected_test() {
		Animal animal = new Animal();
		System.out.println(animal.protectedFiled);
		animal.protectedMethod();
	}

	/**
	 * [default]修饰的属性和方法[可以]在[同包.非子类]中访问
	 */
	public static void default_test() {
		Animal animal = new Animal();
		System.out.println(animal.defaultFiled);
		animal.defaultMethod();
	}

	/**
	 * [private]修饰的属性和方法[不可以]在[同包.非子类]中访问
	 */
	public static void private_test() {
		Animal animal = new Animal();
//		System.out.println(animal.privateFiled);
//		animal.privateMethod();
	}

}
