package com.example.dynamictree;

import java.util.ArrayList;
import java.util.List;

public class Item implements ItemList {
	private String name;
	private Item parent;
	List<Item> children = new ArrayList<>();

	public Item(String name){
		super();
		this.name = name;
		this.parent = null;
	}

	@Override
	public int size() {
		return children.size();
	}

	@Override
	public Item get(int index) {
		return children.get(index);
	}

	@Override
	public int indexOf(Item child) {
		return children.indexOf(child);
	}

	@Override
	public void add(int index, Item newNode) {
		children.add(index, newNode);
		newNode.parent = this;
	}

	@Override
	public void add(Item item) {
		add(size(), item);		
	}

	public String toString(){
		return name;
	}

	public Item getParent() {
		return parent;
	}
	
	private void remove(Item child){
		children.remove(child);
	}

	public void removeFromParent() throws Exception {
		if (parent == null){
			throw new Exception("Parent is null");
		}
		parent.remove(this);
	}
}
