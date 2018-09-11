package com.mrathena.access.modifier.a;

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

}
