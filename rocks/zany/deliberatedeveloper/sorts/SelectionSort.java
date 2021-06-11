package rocks.zany.deliberatedeveloper.sorts;

import java.util.Arrays;

import rocks.zany.deliberatedeveloper.Util;

public class SelectionSort {
	public void sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			Util.swap(array, i, minIndex);
		}
	}

	public static void main(String[] args) {
		int[] array = Arrays.copyOf(Util.unsortedArray, Util.unsortedArray.length);

		Util.print(array, "Before Sorting");
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(array);
		Util.print(array, "SelectionSort");
	}
}
