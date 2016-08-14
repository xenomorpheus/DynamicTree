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
		DynamicTreePanel dynamicTree = new DynamicTreePanel(rootNode);

		// Create and set up the content panel.
		MainPanel newContentPanel = new MainPanel(dynamicTree);
		//TreePopulator.populateTree(dynamicTree);

		newContentPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPanel);

		frame.setLocationRelativeTo(null); // This will centre your app.
		frame.pack();
		frame.setVisible(true); // Display the window.

		// UI updates from non-UI calls.
		TreePopulatorDelay sleeper = new TreePopulatorDelay(dynamicTree);
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

}
