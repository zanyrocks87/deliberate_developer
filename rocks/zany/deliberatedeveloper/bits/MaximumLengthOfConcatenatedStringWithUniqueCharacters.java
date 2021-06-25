package rocks.zany.deliberatedeveloper.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

	public static void main(String[] args) {
		BitmaskAndBacktracking s = new BitmaskAndBacktracking();
		System.out.println(s.maxLength(Arrays.asList("cha", "r", "act", "ers")));
	}

}

class BitmaskAndBacktracking {
	int res = 0;

	public int maxLength(List<String> arr) {
		List<Integer> masks = new ArrayList<>();
		for (String s : arr) {
			int mask = getMask(s);
			if (mask > 0)
				masks.add(mask);
		}
		backtrack(0, 0, masks);
		return res;
	}

	public void backtrack(int idx, int used, List<Integer> masks) {
		if (idx == masks.size()) {
			res = Math.max(Integer.bitCount(used), res);
			return;
		}
		if ((used & masks.get(idx)) == 0) {
			backtrack(idx + 1, used | masks.get(idx), masks);
		}
		backtrack(idx + 1, used, masks);
	}

	public int getMask(String s) {
		int mask = 0;
		for (int i = 0; i < s.length(); i++) {
			int bit = 1 << s.charAt(i) - 'a';
			// Here it checks if the char repeated already in same string. If so the string
			// is not eligible for concatenating
			if ((mask & bit) != 0)
				return -1;
			mask |= bit;
		}
		return mask;
	}
}
