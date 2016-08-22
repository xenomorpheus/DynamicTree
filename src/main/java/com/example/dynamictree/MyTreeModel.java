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
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		Item node = (Item) parent;
		return node.get(index);
	}

	@Override
	public int getChildCount(Object parent) {
		Item node = (Item) parent;
		return node.size();
	}

	@Override
	public boolean isLeaf(Object object) {
		return false;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		LOGGER.error("valueForPathChanged called on path=" + path + ", and object=" + newValue);
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Item parentNode = (Item) parent;
		return parentNode.indexOf((Item) child);
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObjectByPath(TreePath selectionPath) {
		// TODO Auto-generated method stub
		LOGGER.error("removeObjectByPath called on path=" + selectionPath);
	}

	@Override
	public void addObjectByPath(TreePath path, Item child) {
		((Item) path.getLastPathComponent()).add(child);
	}

	@Override
	public void addObject(Item parent, Item child, boolean uiSelect) {
		parent.add(child);

		// TODO if b true, then set parent as selected node
	}

	@Override
	public void removeNode(Item node) throws Exception {
		node.removeFromParent();
	}

}
