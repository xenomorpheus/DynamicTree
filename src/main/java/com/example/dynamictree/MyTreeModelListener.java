package com.example.dynamictree;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyTreeModelListener implements TreeModelListener {

	/** class logger */
	private static final Logger logger = LogManager.getLogger(MyTreeModelListener.class);

	public void treeNodesChanged(TreeModelEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());
		logger.debug("treeNodesChanged called on TreeModelEvent " + e);

		/*
		 * If the event lists children, then the changed node is the child of
		 * the node we've already gotten. Otherwise, the changed node and the
		 * specified node are the same.
		 */

		int[] childIndices = e.getChildIndices();
		if (childIndices != null) {
			int index = childIndices[0];
			node = (DefaultMutableTreeNode) (node.getChildAt(index));
		}

		logger.debug("The user has finished editing the node " + node);
		logger.debug("New value: " + node.getUserObject());
	}

	public void treeNodesInserted(TreeModelEvent e) {
		logger.debug("treeNodesInserted called on TreeModelEvent " + e);
	}

	public void treeNodesRemoved(TreeModelEvent e) {
		logger.debug("treeNodesRemoved called on TreeModelEvent " + e);
	}

	public void treeStructureChanged(TreeModelEvent e) {
		logger.debug("treeStructureChanged called on TreeModelEvent " + e);
	}
}