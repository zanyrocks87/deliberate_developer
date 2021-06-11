package rocks.zany.deliberatedeveloper.sorts;

import rocks.zany.deliberatedeveloper.Util;

public class InsertionSort {

	public void sort(int[] array) {
		int n = array.length;

		// Here interval is 1, i.e h=1
		for (int i = 1; i < n; i++) {

			for (int j = i; j > 0 && (array[j] < array[j - 1]); j--) {
				Util.swap(array, j, j - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = Util.unsortedArray;

		Util.print(array, "Before Sorting");
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(array);
		Util.print(array, "InsertionSort");
	}
}
