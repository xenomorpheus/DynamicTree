package com.example.dynamictree;

//package components;

/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A JPanel with a JTree and various buttons for add/remove/clear nodes in the
 * tree.
 * 
 * @author xenomorpheus
 * 
 */

public class DynamicTreePanel extends JPanel {
	/** serial id. */
	private static final long serialVersionUID = 1L;

	static final String KEY_DYNAMIC_TREE = "DynamicTree";
	static final String KEY_NODE_ID = "Node Id";

	private int newNodeSuffix = 1;

	public DynamicTreePanel(DynamicTree dynamicTree) {
		super(new BorderLayout());

		/** The add button's action. */
		AbstractAction addButtonAction = new AbstractAction("Add") {

			/** Serial ID */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) {

				/** The DynamicTree we are working on. */
				DynamicTree dynamicTree = (DynamicTree) getValue(KEY_DYNAMIC_TREE);

				/**
				 * In this demo we use a counter to give a unique name for each
				 * node.
				 */
				Integer NodeId = (Integer) getValue(KEY_NODE_ID);
				if (NodeId == null) {
					NodeId = 0;
				}

				dynamicTree.addObject("New Node " + newNodeSuffix++);
				putValue(KEY_NODE_ID, NodeId);

			}
		};
		/** The add button. */
		JButton addButton = new JButton(addButtonAction);

		/** The remove button's action. */
		AbstractAction removeButtonAction = new AbstractAction("Remove") {

			/** Serial ID */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) {

				/** The DynamicTree we are working on. */
				DynamicTree dynamicTree = (DynamicTree) getValue(KEY_DYNAMIC_TREE);
				dynamicTree.removeCurrentNode();
			}
		};

		/** The remove button. */
		JButton removeButton = new JButton(removeButtonAction);

		/** The clear button's action. */
		AbstractAction clearButtonAction = new AbstractAction("Clear") {

			/** Serial ID */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) {
				/** The DynamicTree we are working on. */
				DynamicTree dynamicTree = (DynamicTree) getValue(KEY_DYNAMIC_TREE);
				dynamicTree.clear();
			}
		};
		/** The clear button. */
		JButton clearButton = new JButton(clearButtonAction);

		// Lay everything out.
		dynamicTree.setPreferredSize(new Dimension(300, 150));
		add(dynamicTree, BorderLayout.CENTER);

		JPanel panel = new JPanel(new GridLayout(0, 3));

		addButtonAction.putValue(KEY_DYNAMIC_TREE, dynamicTree);
		panel.add(addButton);

		removeButtonAction.putValue(KEY_DYNAMIC_TREE, dynamicTree);
		panel.add(removeButton);

		clearButtonAction.putValue(KEY_DYNAMIC_TREE, dynamicTree);
		panel.add(clearButton);
		add(panel, BorderLayout.SOUTH);
	}

}
