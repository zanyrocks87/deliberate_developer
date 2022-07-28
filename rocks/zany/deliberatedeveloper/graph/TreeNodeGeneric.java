package rocks.zany.deliberatedeveloper.graph;

public class TreeNodeGeneric<T extends Comparable<?>> {
	public T val;
	public TreeNodeGeneric<T> left;
	public TreeNodeGeneric<T> right;

	public TreeNodeGeneric(T val) {
		this.val = val;
	}
}
