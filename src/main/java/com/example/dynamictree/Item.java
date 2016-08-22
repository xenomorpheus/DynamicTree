package com.example.dynamictree;

import java.util.ArrayList;
import java.util.List;

public class Item implements ItemList {
	private String name;
	private Item parent;
	List<Item> children;

	public Item(String name){
		super();
		this.name = name;
		parent = null;
		children = new ArrayList<>();
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
	
	private boolean remove(Item child){
		return children.remove(child);
	}

	public boolean removeFromParent() {
		if (parent == null){
			throw new RuntimeException("Parent is null");
		}
		boolean result = parent.remove(this);
		parent = null;
		return result;
	}
}
