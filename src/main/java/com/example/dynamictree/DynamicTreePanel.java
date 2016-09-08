/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DynamicTreeDemoProject/src/components/DynamicTree.java
 */

package com.example.dynamictree;

//package components;

/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 */

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * A JTree in a JPanel.
 * 
 * @author xenomorpheus
 */

public class DynamicTreePanel extends JPanel {
	/** serial id */
	private static final long serialVersionUID = 1L;
	private ExtendedAbstractTreeModel treeModel;
	private JTree tree = null;

	public DynamicTreePanel(ExtendedAbstractTreeModel treeModel) {
		super(new GridLayout(1, 0));
		this.treeModel = treeModel;

		treeModel.addTreeModelListener(new MyTreeModelListener());

		tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
	}

	protected JTree getTree() {
		return tree;
	}

	/** Remove all nodes except the root node. */
	public void clear() {
		treeModel.clear();
		treeModel.reload();
	}

	/** Remove the currently selected node. */
	public void removeObjectAtCurrentPath() {
		treeModel.removeObjectByPath(tree.getSelectionPath());
	}

	/** Add child to the currently selected node. */
	public void addObjectAtCurrentPath(Item child, boolean shouldBeVisible) {
		TreePath path = tree.getSelectionPath();
		treeModel.addObjectByPath(path, child);

		// Make sure the user can see the lovely new node.
		if (shouldBeVisible) {
			tree.scrollPathToVisible(path);
		}
	}
}
