package rocks.zany.deliberatedeveloper.bits;

/**
 * String contains only lower case
 */
public class BitRepresentationOfUniqueCharString {
	public static void main(String[] args) {
		BitRepresentationOfUniqueCharString bit = new BitRepresentationOfUniqueCharString();

		System.out.println(bit.getBits("abcz"));
	}

	private int getBits(String string) {
		int val = 0;
		for (char ch : string.toCharArray()) {
			val |= 1 << (ch - 'a');
		}
		return val;
	}
}
