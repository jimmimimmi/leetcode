package com.educative.grokking.templates;

import java.util.List;

class BinaryTree{
    public BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Integer nodeData) {
        this.root = new BinaryTreeNode(nodeData);
    }

    public BinaryTree(List<Integer> nodeDataList) {
        this.root = null;
        for (Integer nodeData : nodeDataList) {
            insert(nodeData);
        }
    }
    // for BST insertion
    public void insert(int nodeData) {
        BinaryTreeNode newNode = new BinaryTreeNode(nodeData);
        if (this.root == null) {
            this.root = newNode;
        } else {
            BinaryTreeNode parent = null;
            BinaryTreeNode tempNode = this.root;
            while (tempNode != null) {
                parent = tempNode;
                if (nodeData <= tempNode.data) {
                    tempNode = tempNode.left;
                } else {
                    tempNode = tempNode.right;
                }
            }
            if (nodeData <= parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
    private BinaryTreeNode findInBSTRec(BinaryTreeNode node, int nodeData) {
        if (node == null)
            return null;

        if (node.data == nodeData) {
            return node;
        } else if (node.data > nodeData) {
            return findInBSTRec(node.left, nodeData);
        } else {
            return findInBSTRec(node.right, nodeData);
        }
    }
    public BinaryTreeNode findInBST(int nodeData) {
        return findInBSTRec(this.root, nodeData);
    }
    public int getSubTreeNodeCount(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSubTreeNodeCount(node.left) + getSubTreeNodeCount(node.right);
        }
    }
    private BinaryTreeNode getTreeDeepCopyRec(BinaryTreeNode node) {
        if (node != null) {
            BinaryTreeNode newNode = new BinaryTreeNode(node.data);
            newNode.left = getTreeDeepCopyRec(node.left);
            newNode.right = getTreeDeepCopyRec(node.right);
            return newNode;
        } else {
            return null;
        }
    }
    public BinaryTree getTreeDeepCopy() {
        if (this.root == null) {
            return null;
        } else {
            BinaryTree treeCopy = new BinaryTree();
            treeCopy.root = getTreeDeepCopyRec(root);
            return treeCopy;
        }
    }
}