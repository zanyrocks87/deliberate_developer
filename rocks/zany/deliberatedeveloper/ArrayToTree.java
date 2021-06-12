package rocks.zany.deliberatedeveloper;

import java.util.LinkedList;
import java.util.Queue;

import rocks.zany.deliberatedeveloper.graph.Tree;
import rocks.zany.deliberatedeveloper.graph.TreeNode;

public class ArrayToTree {

	public Tree toTree(Integer[] array) {

		Tree tree = new Tree();

		int n = array.length;

		TreeNode<Integer> rootNode = new TreeNode<Integer>(array[0]);
		tree.root = rootNode;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(rootNode);
		int i = 1;
		while (queue.size() > 0) {
			TreeNode<Integer> node = queue.remove();
			if (i < n) {
				Integer val=array[i++];
				if(val!=null) {
					node.left = new TreeNode<Integer>(val);
					queue.add(node.left);
				}
			}
			if (i < n) {
				Integer val=array[i++];
				if(val!=null) {
					node.right =  new TreeNode<Integer>(val);
					queue.add(node.right);
				}
			}
			if (i >= n) {
				break;
			}
		}

		return tree;
	}

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 5, 1, 4, null, null, 3, 6 };
		ArrayToTree arrayToTree = new ArrayToTree();
		Tree<Integer> tree = arrayToTree.toTree(array);
		Util.print(tree.root, null);
	}

}
