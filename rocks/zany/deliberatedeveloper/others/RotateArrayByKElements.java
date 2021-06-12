package rocks.zany.deliberatedeveloper.others;

import rocks.zany.deliberatedeveloper.Util;

public class RotateArrayByKElements {
	public static void main(String[] args) {
		WithTempArray withTempArray = new WithTempArray();
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Util.print(array, "Before shifting");
		withTempArray.rotate(array, 3);
		Util.print(array, "After shifting");
	}
}

/**
 * Time complexity: O(n+k)
 */
class WithTempArray {
	public void rotate(int[] nums, int k) {
		int n = nums.length;

		int[] temp = new int[k];

		int count = 1;

		while (count <= k) {
			temp[k - count] = nums[n - count];
			count++;
		}
		int i = n - 1;
		while (i >= k) {
			nums[i] = nums[i - k];
			i--;
		}
		for (int j = 0; j < k; j++) {
			nums[j] = temp[j];
		}
	}
}
