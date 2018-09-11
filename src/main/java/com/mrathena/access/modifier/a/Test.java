package com.mrathena.access.modifier.a;

public class Test {

	// 同包中

	// public,所有包下都可访问
	// protected,同包中和子类中可以访问(super.xxx())
	// default,同包中可以访问
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.publicFiled);
		System.out.println(animal.protectedFiled);
		System.out.println(animal.defaultFiled);
//		System.out.println(animal.privateFiled);
		animal.publicMethod();
		animal.protectedMethod();
		animal.defaultMethod();
//		animal.privateMethod();
	}

}
