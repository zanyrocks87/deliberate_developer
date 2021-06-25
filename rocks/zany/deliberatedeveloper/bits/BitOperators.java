package rocks.zany.deliberatedeveloper.bits;

public class BitOperators {

	public static void main(String[] args) {

		System.out.println(convertCase('B'));
		System.out.println(countSetBits(32));

	}

	public static int countSetBits(int num) {
		int count = 0;
		while (num > 0) {
			num &= (num - 1);
			count++;
		}
		return count;
	}

	public static char convertCase(char ch) {

		ch = (char) (ch ^ (1 << 5));

		return ch;
	}
}
