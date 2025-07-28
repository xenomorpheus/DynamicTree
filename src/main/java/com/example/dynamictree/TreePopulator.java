package com.example.dynamictree;

/**
 * Populates the dynamic tree with initial nodes. This class is used to add predefined nodes to the
 * tree.
 */
public class TreePopulator {
  TreePopulator() {
    super();
  }

  public static void populateTree(DynamicTreePanel dynamicTree) {
    String p1Name = new String("Parent 1");
    String p2Name = new String("Parent 2");
    String c1Name = new String("Child 1");
    String c2Name = new String("Child 2");

    var p1 = dynamicTree.addObject(null, p1Name);
    var p2 = dynamicTree.addObject(null, p2Name);

    dynamicTree.addObject(p1, c1Name);
    dynamicTree.addObject(p1, c2Name);

    dynamicTree.addObject(p2, c1Name);
    dynamicTree.addObject(p2, c2Name);
  }
}
