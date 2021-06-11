package rocks.zany.deliberatedeveloper.sorts;

import java.util.Arrays;

import rocks.zany.deliberatedeveloper.Util;

public class ShellSort {
	public static void main(String[] args) {
		int[] shellArray = Arrays.copyOf(Util.unsortedArray, Util.unsortedArray.length);
		Util.print(shellArray, "Before Sorting");
		ShellSquence shellSort = new ShellSquence();
		shellSort.sort(shellArray);
		Util.print(shellArray, "ShellSquence");

		int[] knuthArray = Arrays.copyOf(Util.unsortedArray, Util.unsortedArray.length);
		Util.print(knuthArray, "Before Sorting");
		KnuthSquence knuthSquence = new KnuthSquence();
		knuthSquence.sort(knuthArray);
		Util.print(knuthArray, "KnuthSquence");
	}
}

class ShellSquence {
	public void sort(int[] array) {
		int n = array.length;
		int count = 1;
		for (int h = n / 2; h > 0; h /= 2)
			for (int i = h; i < n; i += h) {
				for (int j = i; j > 0 && (array[j] < array[j - h]); j -= h) {
					System.out.printf("h: %d, count: %d \n", h, count++);
					Util.swap(array, j, j - h);
				}
			}
	}
}

class KnuthSquence {

	public void sort(int[] array) {
		int n = array.length;
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		int count = 1;
		while (h > 0) {
			for (int i = h; i < n; i += h) {
				for (int j = i; j > 0 && (array[j] < array[j - h]); j -= h) {
					System.out.printf("h: %d, count: %d \n", h, count++);
					Util.swap(array, j, j - h);
				}
			}
			h = (h - 1) / 3;
		}
	}

}