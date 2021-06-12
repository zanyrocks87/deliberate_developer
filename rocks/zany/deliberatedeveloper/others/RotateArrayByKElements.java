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
		int dcount = 1;
		while (count <= k) {
			temp[k - count] = nums[n - count];
			System.out.println(dcount++);
			count++;
		}
		int i = n - 1;
		while (i >= k) {
			System.out.println(dcount++);
			nums[i] = nums[i - k];
			i--;
		}
		for (int j = 0; j < k; j++) {
			System.out.println(dcount++);
			nums[j] = temp[j];
		}
	}
}

/**
 * Time complexity: O(n-k)
 */
class KRotateOptimized {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] temp = new int[k];
		int kli = k - 1;

		// Iterate from last index to >=k. As i-k = 0 should be lowest index.
		for (int i = n - 1; i >= k; i--) {
			if (n - i <= k) {
				// Keep in temp if required
				temp[kli--] = nums[i];
			}
			// Shift by k
			nums[i] = nums[i - k];
			if (i - k < k) {
				// Put back the temp if eligible
				nums[i - k] = temp[i - k];
			}
		}
	}
}