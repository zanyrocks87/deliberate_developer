package rocks.zany.deliberatedeveloper.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

class MergeSort {

	public static void main(String... args) {
		int[] array = new int[] { 6, 3, 5, 2, 1, 4 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array, 0, array.length - 1);
		System.out.println(Arrays.stream(array).mapToObj(i -> i + "").collect(Collectors.joining(",")));
	}

	public void sort(int[] array, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			sort(array, l, m);
			sort(array, m + 1, r);
			merge(array, l, m, r);
		}
	}

	private void merge(int[] array, int l, int m, int r) {
		int[] lcopy = new int[m - l + 1];
		int[] rcopy = new int[r - m];

		for (int i = 0; i < lcopy.length; i++) {
			lcopy[i] = array[l + i];
		}
		for (int i = 0; i < rcopy.length; i++) {
			rcopy[i] = array[m + i + 1];
		}

		int k = l;
		int i = 0;
		int j = 0;
		while (i < lcopy.length && j < rcopy.length) {
			if (lcopy[i] <= rcopy[j]) {
				array[k++] = lcopy[i++];
			} else {
				array[k++] = rcopy[j++];
			}
		}

		while (i < lcopy.length) {
			array[k++] = lcopy[i++];
		}

		while (j < rcopy.length) {
			array[k++] = rcopy[j++];
		}
	}
}