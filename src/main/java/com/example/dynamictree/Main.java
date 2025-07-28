/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DynamicTreeDemoProject/src/components/DynamicTree.java
 */
package com.example.dynamictree;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Main class to run the Dynamic Tree example. This class initializes the tree with a root node and
 * sets up the GUI. It also starts a thread to manipulate the tree.
 *
 * @author xenomorpheus
 */
public class Main {

  public static void main(String[] args) {

    var rootNode = new DefaultMutableTreeNode("Root Node");

    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    SwingUtilities.invokeLater(
        () -> { // Create and set up the window.
          JFrame frame = new JFrame("DynamicTreeDemo");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          // Create the components.
          var dynamicTree = new DynamicTreePanel(rootNode);

          // Create and set up the content panel.
          var newContentPanel = new MainPanel(dynamicTree);
          TreePopulator.populateTree(dynamicTree);

          newContentPanel.setOpaque(true); // content panes must be opaque
          frame.setContentPane(newContentPanel);

          frame.setLocationRelativeTo(null); // This will centre your app.
          frame.pack();
          frame.setVisible(true); // Display the window.

          // UI updates from non-UI calls.
          TreeManipulator manipulator = new TreeManipulator(dynamicTree);
          manipulator.start();
        });
  }
}
