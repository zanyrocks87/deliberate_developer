package rocks.zany.deliberatedeveloper.others;

import rocks.zany.deliberatedeveloper.Util;

public class RotateArrayByKElements {
	public static void main(String[] args) {
		Solution withTempArray = new Solution();
		int[] array = new int[] { 1, 2 };
		Util.print(array, "Before shifting");
		withTempArray.rotate(array, 3);
		Util.print(array, "After shifting");

	}
}

/**
 * 
 * Fails when k is > n. Inefficient when k is > n/2
 * 
 * <pre>
 * Time complexity: O(n+k)
 * </pre>
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
 * 
 * Time complexity is n^2.
 *
 */
class KTimesRotate {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int count = 1;
		while (count <= k) {
			int temp = nums[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				nums[i + 1] = nums[i];
			}
			nums[0] = temp;
			count++;
		}
	}
}

/**
 * Only when the array.length > k
 * 
 * <pre>
 * Time complexity: O(n-k)
 * </pre>
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

/**
 * 
 * Works in all cases. Time complexity is O(n)
 */
class Solution {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		if (n < 2) {
			return;
		}

		if (k > n) {
			k = k - n;
		}

		if (k < 1) {
			return;
		}
		if (k * 2 <= n) {
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
		} else {
			if (k > n) {
				k = k % n;
			} else {
				k = n - k;
			}
			int[] temp = new int[k];

			for (int i = 0; i < n - k; i++) {
				if (i < k) {
					temp[i] = nums[i];
				}
				int si = i + k;
				nums[i] = nums[si];
				if (n - si <= k) {
					nums[si] = temp[k - (n - si)];
				}
			}
		}

	}
}

/**
 * Simplest, working code. But have to remember, solution is not intuitive
 */
class UsingReverse {
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}