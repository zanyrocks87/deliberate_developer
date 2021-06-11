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

	public List<Integer> bfsPreOrder(TreeNode root) {
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

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(9);
		tree.add(4);
		tree.add(6);
		tree.add(20);
		tree.add(15);
		tree.add(1);
		
		System.out.println(Util.stringify(tree.bfsPreOrder(tree.root)));

	}
}
