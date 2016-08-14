package com.example.dynamictree;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.log4j.Logger;

public class TreePopulatorDelay extends Thread {

	private static final int DELAY = 8000;

	/** class logger */
	private static final Logger LOGGER = Logger.getLogger(TreePopulatorDelay.class.getName());
	
	private DynamicTreePanel dynamicTreePanel;

	TreePopulatorDelay(DynamicTreePanel dynamicTreePanel) {
		super();
		this.dynamicTreePanel = dynamicTreePanel;
	}

	@Override
	public void run() {
		LOGGER.info("Sleeper must awaken");
		DefaultMutableTreeNode child1 = dynamicTreePanel.addObject(null, "child1 - remove by dynamicTreePanel", true);
		DefaultMutableTreeNode child2 = dynamicTreePanel.addObject(null, "child2 - remove from Parent Node", true);
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dynamicTreePanel.removeNode(child1);
		LOGGER.info("Child1 removed by dynamicTree - Successfully updates UI");
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		child2.removeFromParent();
		LOGGER.info("MISSING - treeNodesRemoved called on TreeModelEvent");
		LOGGER.info("Child2 removed by removeFromParent - Fails to update UI");
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}