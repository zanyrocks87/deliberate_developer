package rocks.zany.deliberatedeveloper.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import rocks.zany.deliberatedeveloper.Util;

public class Tree<T extends Comparable<?>> {
	public TreeNode<T> root;

	public void add(T val) {
		add(new TreeNode<T>(val));
	}

	public void add(TreeNode<T> node) {
		if (root == null) {
			root = node;
			return;
		}

		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			TreeNode<T> parent = queue.remove();
			// FIXME make the int generic
			if ((int) node.val <= (int) parent.val) {
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

	public List<T> breadthFirstSearchR(Queue<TreeNode<T>> queue, List<T> list) {
		if (queue.size() > 0) {
			TreeNode<T> node = queue.remove();
			list.add(node.val);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
			breadthFirstSearchR(queue, list);
		}

		return list;
	}

	public List<T> breadthFirstSearch(TreeNode<T> root) {
		List<T> list = new ArrayList<>();
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			TreeNode<T> parent = queue.remove();
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

	public List<T> dfsPreOrder(TreeNode<T> root, List<T> list) {

		list.add(root.val);

		if (root.left != null) {
			dfsPreOrder(root.left, list);
		}

		if (root.right != null) {
			dfsPreOrder(root.right, list);
		}

		return list;
	}

	public List<T> dfsInOrder(TreeNode<T> root, List<T> list) {

		if (root.left != null) {
			dfsInOrder(root.left, list);
		}

		list.add(root.val);

		if (root.right != null) {
			dfsInOrder(root.right, list);
		}
		return list;
	}

	public List<T> dfsPostOrder(TreeNode<T> root, List<T> list) {

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
		Tree<Integer> tree = new Tree<>();
		tree.add(9);
		tree.add(4);
		tree.add(6);
		tree.add(20);
		tree.add(170);
		tree.add(15);
		tree.add(1);
		Util.print(tree.root, "MyTree");
		Util.print(tree.breadthFirstSearch(tree.root), "breadthFirstSearch");

		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(tree.root);
		Util.print(tree.breadthFirstSearch(tree.root), "breadthFirstSearch Recursive");

		Util.print(tree.dfsInOrder(tree.root, new ArrayList<>()), "DFS Inorder");
		Util.print(tree.dfsPreOrder(tree.root, new ArrayList<>()), "DFS Preorder");
		Util.print(tree.dfsPostOrder(tree.root, new ArrayList<>()), "DFS PostOrder");
	}
}
