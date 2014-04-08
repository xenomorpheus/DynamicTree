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
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A JPanel with a JTree and various buttons for add/remove/clear nodes in the tree.
 * 
 * @author xenomorpheus
 *
 */

public class DynamicTreePanel extends JPanel {
	/** serial id. */
	private static final long serialVersionUID = 1L;
	private int newNodeSuffix = 1;


    protected final DynamicTree dynamicTree;

	public DynamicTreePanel(DynamicTree newDynamicTree) {
		super(new BorderLayout());

		this.dynamicTree = newDynamicTree;

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dynamicTree.addObject("New Node " + newNodeSuffix++);
			}
		});

		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dynamicTree.removeCurrentNode();
			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dynamicTree.clear();
			}
		});

		// Lay everything out.
		dynamicTree.setPreferredSize(new Dimension(300, 150));
		add(dynamicTree, BorderLayout.CENTER);

		JPanel panel = new JPanel(new GridLayout(0, 3));
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(clearButton);
		add(panel, BorderLayout.SOUTH);
	}

}
