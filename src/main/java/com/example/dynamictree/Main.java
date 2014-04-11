package com.example.dynamictree;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A JFrame with a JTree and various buttons for add/remove/clear nodes in the
 * tree.
 * 
 * @author xenomorpheus
 * 
 */
public class Main {

	public static void populateTree(DynamicTree treePanel) {
		String p1Name = new String("Parent 1");
		String p2Name = new String("Parent 2");
		String c1Name = new String("Child 1");
		String c2Name = new String("Child 2");

		DefaultMutableTreeNode p1, p2;

		p1 = treePanel.addObject(null, p1Name);
		p2 = treePanel.addObject(null, p2Name);

		treePanel.addObject(p1, c1Name);
		treePanel.addObject(p1, c2Name);

		treePanel.addObject(p2, c1Name);
		treePanel.addObject(p2, c2Name);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("DynamicTreeDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
				"Root Node");

		// Create the components.
		DynamicTree dynamicTree = new DynamicTree(rootNode);

		// Create and set up the content panel.
		DynamicTreePanel newContentPanel = new DynamicTreePanel(dynamicTree);
		populateTree(dynamicTree);

		newContentPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPanel);

		frame.setLocationRelativeTo(null); // This will center your app
		frame.pack();
		frame.setVisible(true); // Display the window.
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
