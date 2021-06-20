package rocks.zany.deliberatedeveloper.others;

public class SwapTwoNumbers {
	public static void main(String[] args) {

		WithXor withXor = new WithXor();
		WithSum withSum = new WithSum();
		WithTempVariable withTempVariable = new WithTempVariable();

		System.out.println("withXor.swap(78, 93)");
		withXor.swap(78, 93);

		System.out.println("withSum.swap(78, 93)");
		withSum.swap(78, 93);

		System.out.println("withTempVariable.swap(78, 93)");
		withTempVariable.swap(78, 93);

	}
}

class WithXor {
	public void swap(int x, int y) {

		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(x);
		System.out.println(y);
	}
}

class WithSum {
	public void swap(int x, int y) {

		y = x + y;
		x = y - x;
		y = y - x;
		System.out.println(x);
		System.out.println(y);
	}
}

class WithTempVariable {
	public void swap(int x, int y) {

		int temp = x;
		x = y;
		y = temp;
		System.out.println(x);
		System.out.println(y);
	}
}
