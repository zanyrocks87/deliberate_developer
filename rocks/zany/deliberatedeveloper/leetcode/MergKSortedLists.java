package rocks.zany.deliberatedeveloper.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/**
 * First solution with Time complexity: O(kN) where k is the number of linked
 * lists.
 *
 */
class MergKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode result = null;
		ListNode last = null;
		int k = lists.length;
		while (true) {
			int minI = -1;

			for (int i = 0; i < k; i++) {
				if (lists[i] != null) {
					if (minI == -1) {
						minI = i;
					} else {
						if (lists[i].val < lists[minI].val) {
							minI = i;
						}
					}
				}

			}
			if (minI == -1) {
				break;
			}
			ListNode currNode = lists[minI];
			if (result == null) {
				result = currNode;
				last = result;
			} else {
				last.next = currNode;
				last = last.next;
			}
			lists[minI] = currNode.next;
		}

		return result;
	}
}