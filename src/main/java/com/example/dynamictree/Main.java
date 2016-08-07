/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DynamicTreeDemoProject/src/components/DynamicTree.java
 */
package com.example.dynamictree;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.log4j.Logger;

/**
 * A JFrame with a JTree and various buttons to add/remove/clear nodes in the
 * tree.
 * 
 * @author xenomorpheus
 * 
 */
public class Main {
	/** class logger */
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("DynamicTreeDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root Node");

		// Create the components.
		DynamicTree dynamicTree = new DynamicTree(rootNode);

		// Create and set up the content panel.
		DynamicTreePanel newContentPanel = new DynamicTreePanel(dynamicTree);
		DemoTree.populateTree(dynamicTree);

		newContentPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPanel);

		frame.setLocationRelativeTo(null); // This will centre your app.
		frame.pack();
		frame.setVisible(true); // Display the window.

		// UI updates from non-UI calls.
		Sleeper sleeper = new Sleeper(dynamicTree);
		LOGGER.info("Sleeper created");
		sleeper.start();
		LOGGER.info("Sleeper run");

	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	static class Sleeper extends Thread {
		private DynamicTree dynamicTree;

		Sleeper(DynamicTree dynamicTree) {
			super();
			this.dynamicTree = dynamicTree;
		}

		@Override
		public void run() {
			LOGGER.info("Sleeper must awaken");
			DefaultMutableTreeNode sleeper = dynamicTree.addObject(null, "Sleeper must awaken");
			DefaultMutableTreeNode sleeper_child1 = dynamicTree.addObject(sleeper, "Sleeper - child1");
			DefaultMutableTreeNode sleeper_child2 = dynamicTree.addObject(sleeper, "Sleeper - child2", true);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dynamicTree.removeNode(sleeper_child1);
			LOGGER.info("Child1 removed by dynamicTree - Successfully updates UI");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sleeper_child2.removeFromParent();
			LOGGER.info("MISSING - treeNodesRemoved called on TreeModelEvent");
			LOGGER.info("Child2 removed by removeFromParent - Fails to update UI");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dynamicTree.removeNode(sleeper);
			LOGGER.info("Sleeper removed by dynamicTree - Successfully updates UI");
		}
	}
}
