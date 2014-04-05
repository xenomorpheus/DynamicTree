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

public class DynamicTreeDemo extends JPanel implements ActionListener {
	/** serial id. */
	private static final long serialVersionUID = 1L;
	private int newNodeSuffix = 1;
	private static String ADD_COMMAND = "add";
	private static String REMOVE_COMMAND = "remove";
	private static String CLEAR_COMMAND = "clear";

	private DynamicTree treePanel;

	public DynamicTreeDemo(DynamicTree treePanel) {
		super(new BorderLayout());

        this.treePanel = treePanel;

		JButton addButton = new JButton("Add");
		addButton.setActionCommand(ADD_COMMAND);
		addButton.addActionListener(this);

		JButton removeButton = new JButton("Remove");
		removeButton.setActionCommand(REMOVE_COMMAND);
		removeButton.addActionListener(this);

		JButton clearButton = new JButton("Clear");
		clearButton.setActionCommand(CLEAR_COMMAND);
		clearButton.addActionListener(this);

		// Lay everything out.
		treePanel.setPreferredSize(new Dimension(300, 150));
		add(treePanel, BorderLayout.CENTER);

		JPanel panel = new JPanel(new GridLayout(0, 3));
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(clearButton);
		add(panel, BorderLayout.SOUTH);
	}


	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (ADD_COMMAND.equals(command)) {
			// Add button clicked
			treePanel.addObject("New Node " + newNodeSuffix++);
		} else if (REMOVE_COMMAND.equals(command)) {
			// Remove button clicked
			treePanel.removeCurrentNode();
		} else if (CLEAR_COMMAND.equals(command)) {
			// Clear button clicked.
			treePanel.clear();
		}
	}


}
