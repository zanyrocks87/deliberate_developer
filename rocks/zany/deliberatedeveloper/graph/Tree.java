package rocks.zany.deliberatedeveloper.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import rocks.zany.deliberatedeveloper.Util;

public class Tree {
	public TreeNode root;

	public void add(int val) {
		add(new TreeNode(val));
	}

	public void add(TreeNode node) {
		if (root == null) {
			root = node;
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			TreeNode parent = queue.remove();
			if (node.val <= parent.val) {
				if (parent.left != null) {
					queue.add(parent.left);
				} else {
					parent.left = node;
					return;
				}
			} else {
				if (parent.right != null) {
					queue.add(parent.right);
				} else {
					parent.right = node;
					return;
				}
			}
		}
	}

	public List<Integer> breadthFirstSearch(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			TreeNode parent = queue.remove();
			list.add(parent.val);

			if (parent.left != null) {
				queue.add(parent.left);
			}

			if (parent.right != null) {
				queue.add(parent.right);
			}
		}
		return list;
	}

	public List<Integer> dfsPreOrder(TreeNode root, List<Integer> list) {

		list.add(root.val);

		if (root.left != null) {
			dfsPreOrder(root.left, list);
		}

		if (root.right != null) {
			dfsPreOrder(root.right, list);
		}

		return list;
	}

	public List<Integer> dfsInOrder(TreeNode root, List<Integer> list) {

		if (root.left != null) {
			dfsInOrder(root.left, list);
		}

		list.add(root.val);

		if (root.right != null) {
			dfsInOrder(root.right, list);
		}
		return list;
	}

	public List<Integer> dfsPostOrder(TreeNode root, List<Integer> list) {

		if (root.left != null) {
			dfsPostOrder(root.left, list);
		}

		if (root.right != null) {
			dfsPostOrder(root.right, list);
		}

		list.add(root.val);
		return list;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(9);
		tree.add(4);
		tree.add(6);
		tree.add(20);
		tree.add(170);
		tree.add(15);
		tree.add(1);

		Util.print(tree.breadthFirstSearch(tree.root), "breadthFirstSearch");

		Util.print(tree.dfsInOrder(tree.root, new ArrayList<>()), "DFS Inorder");
		Util.print(tree.dfsPreOrder(tree.root, new ArrayList<>()), "DFS Preorder");
		Util.print(tree.dfsPostOrder(tree.root, new ArrayList<>()), "DFS PostOrder");
	}
}
