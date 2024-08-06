DynamicTree
===========

DynamicTree - example Dynamic JTree swing maven project

Build
=====

mvn package

Run
===

java -jar target/DynamicTree-0.0.1-SNAPSHOT-jar-with-dependencies.jar


Correct Behaviour
=================

The JTree will be correctly updated when adding or removing nodes by directly calling methods on the DynamicTreePanel.

Faults
======

The JTree fails to be updated when adding/removing nodes to/from existing nodes.

The MyTreeModelListener instance fails to be notified of changes to the DefaultTreeModel.

