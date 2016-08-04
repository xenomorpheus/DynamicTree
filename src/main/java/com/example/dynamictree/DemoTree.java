package com.example.dynamictree;

import javax.swing.tree.DefaultMutableTreeNode;

public class DemoTree {

	public static void populateTree(DynamicTree dynamicTree) {
		String p1Name = new String("Parent 1");
		String p2Name = new String("Parent 2");
		String c1Name = new String("Child 1");
		String c2Name = new String("Child 2");

		DefaultMutableTreeNode p1, p2;

		p1 = dynamicTree.addObject(null, p1Name);
		p2 = dynamicTree.addObject(null, p2Name);

		dynamicTree.addObject(p1, c1Name);
		dynamicTree.addObject(p1, c2Name);

		dynamicTree.addObject(p2, c1Name);
		dynamicTree.addObject(p2, c2Name);
	}
}
