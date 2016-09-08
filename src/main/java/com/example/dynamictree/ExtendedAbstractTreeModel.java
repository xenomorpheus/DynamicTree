package com.example.dynamictree;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

// This class takes care of the event listener lists required by TreeModel.
// It also adds "fire" methods that call the methods in TreeModelListener.
// Look in TreeModelSupport for all of the pertinent code.
public interface ExtendedAbstractTreeModel extends TreeModel {

	void reload();

	void clear();

	void removeObjectByPath(TreePath path);

	void addObjectByPath(TreePath path, Item child);

	void addObject(Item root, Item child1);

	void removeNode(Item child1);
}


