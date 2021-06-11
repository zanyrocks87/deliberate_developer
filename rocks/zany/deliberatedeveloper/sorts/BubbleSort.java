package rocks.zany.deliberatedeveloper.sorts;

import java.util.Arrays;

import rocks.zany.deliberatedeveloper.Util;

public class BubbleSort {
	public void sort(int[] array) {
		int n = array.length;
		int checkTill = n;
//		int count = 1;
		while (0 < checkTill) {
			boolean swapped = false;
			for (int i = 0; i < checkTill - 1; i++) {
//				System.out.println(count++);
				if (array[i] > array[i + 1]) {
					Util.swap(array, i, i + 1);

					swapped = true;
				}
			}
			if (!swapped) {
				System.out.println("Array is already sorted, no need to work further");
				break;
			}
			checkTill--;
		}
	}

	public static void main(String[] args) {
		int[] array = Arrays.copyOf(Util.unsortedArray, Util.unsortedArray.length);

		Util.print(array, "Before sorting");
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array);
		Util.print(array, "BubbleSort");
	}
}
