package com.example.demo.test;

public class Test {
	
	Parent parent;
	public static void main(String[] args) {
		Test test = new Test();
		test.callP();
		test.testParent();
	}
	
    Parent callP() {
		parent = new Parent();
		parent.i = 4;
		return parent;
	}
    
    void testParent() {
    	System.out.println("Parent.i : " + parent.i);
    }
}


 class Parent {
	 int i;
	 void methP() {
		 System.out.println("methoP");
	 }
 }
 
 class Child extends Parent {
	 void methC() {
		 System.out.println("mehoC");
	 }
 }
