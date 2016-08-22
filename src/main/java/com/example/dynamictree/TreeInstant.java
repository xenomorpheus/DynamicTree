package com.example.dynamictree;

public class TreeInstant {
	TreeInstant(){
		super();
	}

	public static Item getRoot() {
		Item c1 = new Item("Child 1");
		Item c2 = new Item("Child 2");
		Item p1 = new Item("Parent 1");
		p1.add(c1);
		Item p2 = new Item("Parent 2");
		p2.add(c2);
		Item root = new Item("root");
		root.add(p1);
		root.add(p2);
		return root;
	}
}
