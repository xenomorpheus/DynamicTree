/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DynamicTreeDemoProject/src/components/DynamicTree.java
 */

package com.example.dynamictree;

// package components;

/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 */

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * A JTree in a JPanel.
 *
 * @author xenomorpheus
 */
public class DynamicTreePanel extends JPanel {
  /** serial id */
  private static final long serialVersionUID = 1L;

  private DefaultMutableTreeNode rootNode;
  private DefaultTreeModel treeModel;
  private JTree tree;
  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  public DynamicTreePanel(DefaultMutableTreeNode rootNode) {
    super(new GridLayout(1, 0));

    this.rootNode = rootNode;
    treeModel = new DefaultTreeModel(rootNode);
    tree = new JTree(treeModel);
    tree.setEditable(true);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setShowsRootHandles(true);

    JScrollPane scrollPane = new JScrollPane(tree);
    add(scrollPane);
  }

  /** Remove all nodes except the root node. */
  public void clear() {
    rootNode.removeAllChildren();
    treeModel.reload();
  }

  /** Remove the node. */
  public void removeNode(MutableTreeNode node) {
    MutableTreeNode parent = (MutableTreeNode) (node.getParent());
    if (parent != null) {
      treeModel.removeNodeFromParent(node);
    }
  }

  /** Remove the currently selected node. */
  public void removeCurrentNode() {
    TreePath currentSelection = tree.getSelectionPath();
    if (currentSelection != null) {
      MutableTreeNode currentNode = (MutableTreeNode) (currentSelection.getLastPathComponent());
      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
      if (parent != null) {
        this.removeNode(currentNode);
        return;
      }
    }

    // Either there was no selection, or the root was selected.
    toolkit.beep();
  }

  /** Add child to the currently selected node. */
  public MutableTreeNode addObjectAtCurrentNode(Object child) {
    MutableTreeNode parentNode = null;
    TreePath parentPath = tree.getSelectionPath();

    if (parentPath == null) {
      parentNode = rootNode;
    } else {
      parentNode = (MutableTreeNode) (parentPath.getLastPathComponent());
    }

    return addObject(parentNode, child, true);
  }

  public MutableTreeNode addObject(MutableTreeNode parent, Object child) {
    return addObject(parent, child, false);
  }

  public MutableTreeNode addObject(MutableTreeNode parent, Object child, boolean shouldBeVisible) {
    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

    if (parent == null) {
      parent = rootNode;
    }

    // It is key to invoke this on the TreeModel, and NOT
    // MutableTreeNode
    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

    // Make sure the user can see the lovely new node.
    if (shouldBeVisible) {
      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
    }
    return childNode;
  }
}
