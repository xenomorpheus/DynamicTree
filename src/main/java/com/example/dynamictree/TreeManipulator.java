package com.example.dynamictree;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TreeManipulator extends Thread {

	private static final int DELAY = 8000;

	/** class logger */
	private static final Logger logger = LogManager.getLogger(TreeManipulator.class.getName());

	private DynamicTreePanel dynamicTreePanel;

	TreeManipulator(DynamicTreePanel dynamicTreePanel) {
		super();
		this.dynamicTreePanel = dynamicTreePanel;
	}

	@Override
	public void run() {
		logger.info("TreeManipulator starting");
		logger.info("Adding child1");
		DefaultMutableTreeNode child1 = dynamicTreePanel.addObject(null, "child1 - To be removed by method removeNode()", true);
		logger.info("Adding child2");
		DefaultMutableTreeNode child2 = dynamicTreePanel.addObject(null, "child2 - To be removed by method removeFromParent()", true);
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Removing child1 by method removeNode()");
		dynamicTreePanel.removeNode(child1);
		logger.info("Completed child1 removed by dynamicTree - Successfully updates UI");
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Removing child2 by method removeFromParent()");
		child2.removeFromParent();

		logger.info("ERROR: MISSING notification - treeNodesRemoved called on TreeModelEvent");
		logger.info("ERROR: Completed child2 removed by removeFromParent - Fails to update UI");
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}