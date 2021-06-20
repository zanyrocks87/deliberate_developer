package rocks.zany.deliberatedeveloper.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		BoyerMooreAlgo algo = new BoyerMooreAlgo();
		System.out.println(algo.majorityElement(new int[] { 1, 2, 3, 5, 1, 1, 1, 1 }));
	}

}

class MapBasedSolution {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			Integer c = counts.get(num);

			if (c == null) {
				c = 0;
			}
			counts.put(num, ++c);

			if (c > (n / 2)) {
				return num;
			}
		}
		return -1;
	}
}

/**
 * Assumes there is a majority element in given array. If the input is wrong it
 * gives wrong output.
 */
class BoyerMooreAlgo {

	public int majorityElement(int[] nums) {
		int c = 0;
		int el = 0;

		for (int num : nums) {
			if (c == 0) {
				el = num;
			}

			if (el == num) {
				c++;
			} else {
				c--;
			}
		}

		return el;
	}
}