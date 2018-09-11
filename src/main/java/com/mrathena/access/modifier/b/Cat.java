package com.mrathena.access.modifier.b;

import com.mrathena.access.modifier.a.Animal;

public class Cat extends Animal {

	// 子类中

	// public,所有包下都可访问
	// protected,同包中和子类中可以访问(super.xxx())

	@Override
	public void publicMethod() {
		System.out.println(super.publicFiled);
//		System.out.println(super.privateFiled);
		super.publicMethod();
	}

	@Override
	protected void protectedMethod() {
		System.out.println(super.protectedFiled);
//		System.out.println(super.defaultFiled);
		super.protectedMethod();
	}

}
