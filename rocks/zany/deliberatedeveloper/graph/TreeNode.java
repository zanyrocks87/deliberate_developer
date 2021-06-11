package rocks.zany.deliberatedeveloper.graph;

class TreeNode<T extends Comparable<?>> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T val) {
		this.val = val;
	}
}
