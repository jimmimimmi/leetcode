package com.educative.grokking.templates;

public class EduTreeNode<T> {
    public T data;
    public EduTreeNode<T> left;
    public EduTreeNode<T> right;
    public EduTreeNode<T> next;

    EduTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
