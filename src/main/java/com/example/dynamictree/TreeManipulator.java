package com.example.dynamictree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A thread that manipulates the dynamic tree by adding and removing nodes. This class is used to
 * demonstrate dynamic updates to the tree. It adds a node and then removes it after a delay.
 */
public class TreeManipulator extends Thread {

  private static final int DELAY = 8_000;

  /** class logger */
  private static final Logger logger = LogManager.getLogger(TreeManipulator.class.getName());

  private DynamicTreePanel dynamicTreePanel;

  TreeManipulator(DynamicTreePanel dynamicTreePanel) {
    super();
    this.dynamicTreePanel = dynamicTreePanel;
  }

  @Override
  public void run() {
    logger.info("TreeManipulator starting");
    logger.info("Adding child1");
    var child1 = dynamicTreePanel.addObject(null, "Auto-remove1", true);
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    logger.info("Removing child1 by method removeNode()");
    dynamicTreePanel.removeNode(child1);
    logger.info("Completed child1 removed by dynamicTree - Successfully updates UI");
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
