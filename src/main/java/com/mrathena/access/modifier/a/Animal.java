package com.mrathena.access.modifier.a;

/**
 * 本类
 */
public class Animal {

	public String publicFiled = "public";
	protected String protectedFiled = "protected";
	String defaultFiled = "default";
	private String privateFiled = "private";

	public void publicMethod() {
		System.out.println(publicFiled);
	}

	protected void protectedMethod() {
		System.out.println(protectedFiled);
	}

	void defaultMethod() {
		System.out.println(defaultFiled);
	}

	private void privateMethod() {
		System.out.println(privateFiled);
	}

	/**
	 * [public]修饰的属性和方法[可以]在[本类]中访问
	 */
	public static void public_test() {
		Animal animal = new Animal();
		System.out.println(animal.publicFiled);
		animal.publicMethod();
	}

	/**
	 * [protected]修饰的属性和方法[可以]在[本类]中访问
	 */
	public static void protected_test() {
		Animal animal = new Animal();
		System.out.println(animal.protectedFiled);
		animal.protectedMethod();
	}

	/**
	 * [default]修饰的属性和方法[可以]在[本类]中访问
	 */
	public static void default_test() {
		Animal animal = new Animal();
		System.out.println(animal.defaultFiled);
		animal.defaultMethod();
	}

	/**
	 * [private]修饰的属性和方法[可以]在[本类]中访问
	 */
	public static void private_test() {
		Animal animal = new Animal();
		System.out.println(animal.privateFiled);
		animal.privateMethod();
	}

}
