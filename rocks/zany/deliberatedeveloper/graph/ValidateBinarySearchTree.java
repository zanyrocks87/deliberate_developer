//package rocks.zany.deliberatedeveloper.graph;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class ValidateBinarySearchTree {
//
//}
//
//class Solution {
//	public boolean isValidBST(TreeNode<Integer> root) {
//		Queue<TreeNode<Integer>> queue = new LinkedList<>();
//		queue.add(root);
//
//		while (queue.size() > 0) {
//			TreeNode<Integer> node = queue.remove();
//			System.out.println("Node: " + node.val);
//			List<Integer> parents = new ArrayList<>();
//			parents.add(node.val);
//
//			if (node.left != null) {
//				if (lessThanParents(parents, node.left.val)) {
//					System.out.println("Left: " + node.left.val);
//					queue.add(node.left);
//				} else {
//					System.out.println("Left: False");
//					return false;
//				}
//			}
//
//			if (node.right != null) {
//				if (greaterThanParents(parents, node.left.val)) {
//					System.out.println("Right: " + node.right.val);
//					queue.add(node.right);
//				} else {
//					System.out.println("Right: False");
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}
//
//	private boolean lessThanParents(List<Integer> parents, int val) {
//		return !(parents.stream().filter(p -> p > val).count() > 0);
//	}
//
//	private boolean greaterThanParents(List<Integer> parents, int val) {
//		return !(parents.stream().filter(p -> p < val).count() > 0);
//	}
//}