package rocks.zany.deliberatedeveloper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rocks.zany.deliberatedeveloper.graph.TreeNode;

public class Util {

	public static int[] unsortedArray = new int[] { 4, 5, 78, 8, 78, 1, 34, 3, 500, 678, 345, 454, 5, 6, 7, 456345, 6,
			4556, 455, 645, 456, 45, 4645, 45645, 345, 33, 67, 656, 456, 5 };

	public static int[] sortedArray = new int[] { 1, 3, 4, 5, 5, 5, 6, 6, 7, 8, 33, 34, 45, 67, 78, 78, 345, 345, 454,
			455, 456, 456, 500, 645, 656, 678, 4556, 4645, 45645, 456345 };

	public static int[] reverseSortedArray = new int[] { 456345, 45645, 4645, 4556, 678, 656, 645, 500, 456, 456, 455,
			454, 345, 345, 78, 78, 67, 45, 34, 33, 8, 7, 6, 6, 5, 5, 5, 4, 3, 1 };

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void print(TreeNode<Integer> root, String label) {
		System.out.println("==================" + label + "==================");
		BTreePrinter.printNode(root);
	}

	public static void print(int[] array, String label) {
		System.out.println(label + ": " + stringify(array));
	}

	public static void print(List<Integer> list, String label) {
		System.out.println(label + ": " + stringify(list));
	}

	public static String stringify(List<Integer> list) {
		return list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", "));

	}

	public static String stringify(int[] array) {
		return Arrays.stream(array).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(", "));
	}
}
