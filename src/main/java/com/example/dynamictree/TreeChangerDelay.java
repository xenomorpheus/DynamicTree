package com.example.dynamictree;

import org.apache.log4j.Logger;

public class TreeChangerDelay extends Thread {

	private static final int DELAY = 1000;

	/** class logger */
	private static final Logger LOGGER = Logger.getLogger(TreeChangerDelay.class.getName());

	private ExtendedAbstractTreeModel treeModel;

	private Item root;

	TreeChangerDelay(ExtendedAbstractTreeModel treeModel, Item root) {
		super();
		this.treeModel = treeModel;
		this.root = root;
	}

	@Override
	public void run() {
		Item child1 = new Item("child1 - remove by treeModel");
		treeModel.addObject(root, child1, true);
		Item child2 = new Item("child2 - remove from Parent Node");
		treeModel.addObject(root, child2, true);
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			treeModel.removeNode(child1);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		LOGGER.info("Child1 removed by dynamicTree - Successfully updates UI");
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// child2.removeFromParent();
		// TODO phase 1 - tree model to fire Tree Node removed
		// nodesWereRemoved in DefaultTreeModel class.
		// TODO phase 2 - get fire to happen automatically
		LOGGER.info("MISSING - treeNodesRemoved called on TreeModelEvent");
		LOGGER.info("Child2 removed by removeFromParent - Fails to update UI");

		try {
			child2.removeFromParent();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}