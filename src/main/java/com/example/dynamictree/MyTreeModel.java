package com.example.dynamictree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyTreeModel extends AbstractTreeModel implements ExtendedAbstractTreeModel {

	/** class logger */
	private static final Logger LOGGER = LogManager.getLogger("MyTreeModel");
	Item root;

	public MyTreeModel(Item root) {
		this.root = root;
	}

	@Override
	public Object getRoot() {
		LOGGER.info("getRoot root="+root);
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		Item node = (Item) parent;
		Item child = node.get(index);
		LOGGER.info("getChild parent="+parent+", index="+index+", child="+child);
		return child;
	}

	@Override
	public int getChildCount(Object parent) {
		Item node = (Item) parent;
		int size = node.size();
		LOGGER.info("getChildCount parent="+parent+", size="+size);
		return size;
	}

	@Override
	public boolean isLeaf(Object object) {
		return false; // getChildCount(object) < 1;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		LOGGER.error("valueForPathChanged called on path=" + path + ", and object=" + newValue);
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Item parentNode = (Item) parent;
		int index = parentNode.indexOf((Item) child);
		LOGGER.info("getIndexOfChild parent="+parent+", child="+child+", index="+index);
		return index;
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		LOGGER.info("reload");

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		LOGGER.info("clear");

	}

	@Override
	public void removeObjectByPath(TreePath selectionPath) {
		// TODO Auto-generated method stub
		LOGGER.error("removeObjectByPath called on path=" + selectionPath);
	}

	@Override
	public void addObjectByPath(TreePath path, Item child) {
		LOGGER.info("addObjectByPath path="+path+", child="+child);
		((Item) path.getLastPathComponent()).add(child);
	}

	@Override
	public void addObject(Item parent, Item child) {
		LOGGER.info("addObject parent="+parent+", child="+child);
		parent.add(child);
	}

	@Override
	public void removeNode(Item node){
		LOGGER.info("removeNode node="+node);
		node.removeFromParent();
	}

	/** Build a TreePath by following a node up to root */
	static public TreePath getTreePath(Item node) {
		List<Item> itemList = new ArrayList<>();
		while (node != null) {
			itemList.add(0,node);
			node = node.getParent();
		}
		Item[] itemArray = itemList.toArray(new Item[itemList.size()]);
		return new TreePath(itemArray);
	}

}
