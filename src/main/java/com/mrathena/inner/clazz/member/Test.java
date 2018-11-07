package com.mrathena.inner.clazz.member;

import com.mrathena.inner.clazz.member.Outer.Inner;

public class Test {

	public static void main(String[] args) {
		// 外部创建成员内部类实例对象
		Outer outer = new Outer();
		// 方式1
		Inner memberInnerClass = outer.new Inner();
		System.out.println(memberInnerClass);
		// 方式2
		Inner memberInnerClass2 = outer.getInner();
		System.out.println(memberInnerClass2);
	}

}
