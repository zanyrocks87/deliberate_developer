
package rocks.zany.deliberatedeveloper.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
class CountSubArraysWithKSum {
	public int subarraySum(int[] nums, int k) {
		Queue<Integer> q = new LinkedList<>();

		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			q.add(nums[i]);

			int sum = sum(q);

			if (sum == k) {
				count++;
			}

			while (q.size() > 1) {
				int t = q.peek();
//				int t = q.remove();
				boolean changed = false;
				if (k < sum) {
					if (t > 0) {
						sum -= t;
						q.remove();
						changed = true;
					}
				}

				if (k > sum) {
					if (t < 0) {
						sum -= t;
						q.remove();
						changed = true;
					}
				}

				if (sum == k && changed) {
					count++;
				}
				if (!changed) {
					break;
				}
			}

		}

		return count;
	}

	private int sum(Queue<Integer> q) {

		return new ArrayList<>(q).stream().reduce(Integer::sum).orElse(0);

	}

	public static void main(String[] args) {
		CountSubArraysWithKSum s = new CountSubArraysWithKSum();
		System.out.println(s.subarraySum(new int[] { 1, -1, 0 }, 0));
	}
}