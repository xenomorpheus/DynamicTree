DynamicTree
===========

DynamicTree - example Dynamic JTree swing maven project.
Nodes are added/removed via the TreeModel.
There is no non-swing representation of the tree, not even
user objects within the MutableTreeNode.

Build
=====

mvn package

Run
===

java -jar target/DynamicTree-0.0.1-SNAPSHOT-jar-with-dependencies.jar


Correct Behaviour
=================

The JTree will be correctly updated when adding or removing nodes by directly calling methods on the DynamicTreePanel.


