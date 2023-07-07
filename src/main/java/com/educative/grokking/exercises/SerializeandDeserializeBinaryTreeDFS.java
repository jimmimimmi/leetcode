package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SerializeandDeserializeBinaryTreeDFS {
    public static List<String> serialize(TreeNode<Integer> root) {
        List<String> stream = new ArrayList<>();
        serializePreOrderDfs(root, stream);
        return stream;
    }

    private static void serializePreOrderDfs(TreeNode<Integer> node, List<String> stream) {
        if (node == null) {
            stream.add("null");
            return;
        }

        stream.add(node.data.toString());
        serializePreOrderDfs(node.left, stream);
        serializePreOrderDfs(node.right, stream);
    }

    public static TreeNode<Integer> deserialize(List<String> stream) {

        var iterator = stream.iterator();
        return deserializePreOrderDfs(iterator);
    }

    private static TreeNode<Integer> deserializePreOrderDfs(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        var val = iterator.next();
        if (val.equals("null")) {
            return null;
        }

        var node = new TreeNode<>(Integer.parseInt(val));
        node.left = deserializePreOrderDfs(iterator);
        node.right = deserializePreOrderDfs(iterator);
        return node;

    }
}
