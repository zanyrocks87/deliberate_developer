package rocks.zany.deliberatedeveloper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1 };
		int[] nums2 = new int[] { 2 };
		System.out.println(Solution1.findMedianSortedArrays(nums1, nums2));
	}
}

class Solution1 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int total = m + n;// 2
		int needSize = total / 2 + 1;// 2
		int[] merged = new int[needSize];

		int i = 0;
		int j = 0;
		int k = 0;

		while (k < needSize && i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}
		}

		while (k < needSize && i < nums1.length) {

			merged[k++] = nums1[i++];

		}

		while (k < needSize && j < nums2.length) {

			merged[k++] = nums2[j++];

		}
		System.out.println(Arrays.stream(merged).mapToObj(num -> num + "").collect(Collectors.joining(",")));
		if (total % 2 == 0) {
			return (merged[k - 1] + merged[k - 2]) / (double) 2;
		} else {
			return merged[k - 1];
		}
	}

}

class SolutionWithBinarySearch {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int total = m + n;// 2
		int needSize = total / 2 + 1;// 2
		int[] merged = new int[needSize];

		int i = 0;
		int j = 0;
		int k = 0;

		while (k < needSize && i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}
		}

		while (k < needSize && i < nums1.length) {

			merged[k++] = nums1[i++];

		}

		while (k < needSize && j < nums2.length) {

			merged[k++] = nums2[j++];

		}
		System.out.println(Arrays.stream(merged).mapToObj(num -> num + "").collect(Collectors.joining(",")));
		if (total % 2 == 0) {
			return (merged[k - 1] + merged[k - 2]) / (double) 2;
		} else {
			return merged[k - 1];
		}
	}

}