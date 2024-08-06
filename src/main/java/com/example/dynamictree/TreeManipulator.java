package com.example.dynamictree;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TreeManipulator extends Thread {

	private static final int DELAY = 1000;

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
	}
}