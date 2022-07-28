package rocks.zany.deliberatedeveloper.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeGeneric<T extends Comparable<?>> {

	class TreeNode<U extends Comparable<?>> {
		public U val;
		public TreeNode<U> left;
		public TreeNode<U> right;

		public TreeNode(U val) {
			this.val = val;
		}
	}

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

	public TreeNode<T> createNode(T val) {
		return new TreeNode<>(val);
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
		TreeGeneric<Integer> tree = new TreeGeneric<>();
		tree.add(9);
		tree.add(4);
		tree.add(6);
		tree.add(20);
		tree.add(170);
		tree.add(15);
		tree.add(1);
		tree.toTree(new Integer[] { 5, 1, 4, null, null, 3, 6 });
		tree.printNode(tree.root);

	}

	public TreeGeneric<T> toTree(Integer[] array) {

		int n = array.length;

		TreeGeneric<T>.TreeNode<T> rootNode = createNode((T) array[0]);
		root = rootNode;
		Queue<TreeGeneric<T>.TreeNode<T>> queue = new LinkedList<>();
		queue.add(rootNode);
		int i = 1;
		while (queue.size() > 0) {
			TreeGeneric<T>.TreeNode<T> node = queue.remove();
			if (i < n) {
				Integer val = array[i++];
				if (val != null) {
					node.left = createNode((T) val);
					queue.add(node.left);
				}
			}
			if (i < n) {
				Integer val = array[i++];
				if (val != null) {
					node.right = createNode((T) val);
					queue.add(node.right);
				}
			}
			if (i >= n) {
				break;
			}
		}

		return this;
	}

	public <T extends Comparable<?>> void printNode(TreeNode<T> root) {
		int maxLevel = maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces);

		List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
		for (TreeNode<T> TreeNode : nodes) {
			if (TreeNode != null) {
				System.out.print(TreeNode.val);
				newNodes.add(TreeNode.left);
				newNodes.add(TreeNode.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);

				printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private <T extends Comparable<?>> int maxLevel(TreeNode<T> TreeNode) {
		if (TreeNode == null)
			return 0;

		return Math.max(maxLevel(TreeNode.left), maxLevel(TreeNode.right)) + 1;
	}

	private <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
