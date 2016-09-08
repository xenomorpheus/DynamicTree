package com.example.dynamictree;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Puppeteer extends Thread {

	private static final int DELAY = 1000;

	/** class logger */
	private static final Logger LOGGER = LogManager.getLogger("Puppeteer");

	private ExtendedAbstractTreeModel treeModel;
	private Item root;
	private JTree jTree;

	Puppeteer(ExtendedAbstractTreeModel treeModel, Item root, JTree jTree) {
		super();
		this.treeModel = treeModel;
		this.root = root;
		this.jTree = jTree;
	}

	private void scrollPathToVisible(Item selected) {
		TreePath path = MyTreeModel.getTreePath(selected);
		LOGGER.info("path=" + path);
		jTree.scrollPathToVisible(path);
	}

	@Override
	public void run() {
		Item child1 = new Item("child1 - treeModel will remove");
		treeModel.addObject(root, child1);
		scrollPathToVisible(child1);
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		Item child2 = new Item("child2 - self will remove");
		treeModel.addObject(root, child2);
		scrollPathToVisible(child2);
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		treeModel.removeNode(child1);
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
		// LOGGER.info("MISSING - treeNodesRemoved called on TreeModelEvent");
		LOGGER.info("Child2 removed by removeFromParent - Fails to update UI");

		child2.removeFromParent();

		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}