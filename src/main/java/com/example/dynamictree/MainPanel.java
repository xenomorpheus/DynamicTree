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

public class MainPanel extends JPanel {
	/** serial id. */
	private static final long serialVersionUID = 1L;

	/** The DynamicTree we are working on. */
	final DynamicTreePanel dynamicTree;

	/**
	 * Each new node will have an unique name by adding suffix using an
	 * incrementing integer.
	 */
	private int newNodeSuffix = 1;

	public MainPanel(DynamicTreePanel dynamicTree) {
		super(new BorderLayout());
		this.dynamicTree = dynamicTree;

		/** The add button's action. */
		AbstractAction addButtonAction = new AbstractAction("Add") {

			/** Serial ID */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) {
				dynamicTree.addObjectAtCurrentNode("New Node " + newNodeSuffix++);
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
				dynamicTree.clear();
			}
		};
		/** The clear button. */
		JButton clearButton = new JButton(clearButtonAction);

		// Lay everything out.
		dynamicTree.setPreferredSize(new Dimension(400, 150));
		add(dynamicTree, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(clearButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

}
