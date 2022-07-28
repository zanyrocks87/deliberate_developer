package rocks.zany.deliberatedeveloper.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Java program to check whether an array can be
// partitioned into K subsets of equal sum
class KPartsEqualSum {

// Recursive Utility method to check K equal sum
// subsetition of array
	/**
	 * array - given input array subsetSum array - sum to store each subset of the
	 * array taken - boolean array to check whether element is taken into sum
	 * partition or not K - number of partitions needed N - total number of element
	 * in array curIdx - current subsetSum index limitIdx - lastIdx from where array
	 * element should be taken
	 */
	static boolean isKPartitionPossibleRec(int arr[], int subsetSum[], boolean taken[], int subset, int K, int N,
			int curIdx, int limitIdx) {
		if (subsetSum[curIdx] == subset) {
			/*
			 * current index (K - 2) represents (K - 1) subsets of equal sum last partition
			 * will already remain with sum 'subset'
			 */
			if (curIdx == K - 2)
				return true;

			// recursive call for next subsetition
			return isKPartitionPossibleRec(arr, subsetSum, taken, subset, K, N, curIdx + 1, N - 1);
		}

		// start from limitIdx and include elements into current partition
		for (int i = limitIdx; i >= 0; i--) {
			// if already taken, continue
			if (taken[i])
				continue;
			int tmp = subsetSum[curIdx] + arr[i];

			// if temp is less than subset then only include the element
			// and call recursively
			if (tmp <= subset) {
				// mark the element and include into current partition sum
				taken[i] = true;
				subsetSum[curIdx] += arr[i];
				boolean nxt = isKPartitionPossibleRec(arr, subsetSum, taken, subset, K, N, curIdx, i - 1);

				// after recursive call unmark the element and remove from
				// subsetition sum
				taken[i] = false;
				subsetSum[curIdx] -= arr[i];
				if (nxt)
					return true;
			}
		}
		return false;
	}

// Method returns true if arr can be partitioned into K subsets
// with equal sum
	static boolean isKPartitionPossible(int arr[], int N, int K) {
		// If K is 1, then complete array will be our answer
		if (K == 1)
			return true;

		// If total number of partitions are more than N, then
		// division is not possible
		if (N < K)
			return false;

		// if array sum is not divisible by K then we can't divide
		// array into K partitions
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += arr[i];
		if (sum % K != 0)
			return false;

		// the sum of each subset should be subset (= sum / K)
		int subset = sum / K;
		int[] subsetSum = new int[K];
		boolean[] taken = new boolean[N];

		// Initialize sum of each subset from 0
		for (int i = 0; i < K; i++)
			subsetSum[i] = 0;

		// mark all elements as not taken
		for (int i = 0; i < N; i++)
			taken[i] = false;

		// initialize first subset sum as last element of
		// array and mark that as taken
		subsetSum[0] = arr[N - 1];
		taken[N - 1] = true;

		// call recursive method to check K-substitution condition
		return isKPartitionPossibleRec(arr, subsetSum, taken, subset, K, N, 0, N - 1);
	}

// Driver code
	public static void main(String[] args) {
		int arr[] = { 2, 1, 4, 5, 3, 3 };
		int N = arr.length;
		int K = 3;

		if (isKPartitionPossible(arr, N, K))
			System.out.println("Partitions into equal sum is possible.");
		else
			System.out.println("Partitions into equal sum is not possible.");
	}
}

// This code is contributed by Princi Singh

/**
 * I have written during the interview, incorrect code. Kept is for reference.
 */
class SumArrayMain {

	/**
	 * [1,11,5,7,8,5,10,1,9,7] [7,9] [1,5,10] [5,11] [1,7,8]
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[][] breakIntoSubArrays(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		Collections.sort(list);
		int total = Arrays.stream(nums).sum();
		int sum = total / k;

		int[][] result = new int[k][];
		int j = 0;
		while (j < k) {
			int l = list.size() - 1;
			Integer i = list.get(l);
			list.remove(l);
			int localSum = i;
			while (localSum < sum) {
				Integer next = list.get(--l);
				localSum += next;
			}
		}

		return result;
	}

}
