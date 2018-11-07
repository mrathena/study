package com.mrathena.inner.clazz.member;

public class Outer2 {

	// javap -v Outter2$Inner, 反编译命令

	private Inner inner = null;

	public Outer2() {}

	public Inner getInnerInstance() {
		if (inner == null) {
			inner = new Inner("");
		}
		return inner;
	}

	protected class Inner {
		public Inner() {}

		public Inner(String string) {
			System.out.println(string);
		}
	}

}
