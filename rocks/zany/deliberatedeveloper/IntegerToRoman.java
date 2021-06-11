package rocks.zany.deliberatedeveloper;

public class IntegerToRoman {
	public static void main(String[] args) {
		BruteForce bruteForce = new BruteForce();
		System.out.println(bruteForce.intToRoman(3658));

	}
}

class BruteForce {

	public String intToRoman(int num) {
		String roman = "";

		while (num > 0) {
			if (num >= 1000) {
				roman = roman + "M";
				num -= 1000;
				continue;
			}
			if (num >= 900) {
				roman = roman + "CM";
				num -= 900;
				continue;
			}
			if (num >= 500) {
				roman = roman + "D";
				num -= 500;
				continue;
			}
			if (num >= 400) {
				roman = roman + "CD";
				num -= 400;
				continue;
			}
			if (num >= 100) {
				roman = roman + "C";
				num -= 100;
				continue;
			}
			if (num >= 90) {
				roman = roman + "XC";
				num -= 90;
				continue;
			}

			if (num >= 50) {
				roman = roman + "L";
				num -= 50;
				continue;
			}
			if (num >= 40) {
				roman = roman + "XL";
				num -= 40;
				continue;
			}
			if (num >= 10) {
				roman = roman + "X";
				num -= 10;
				continue;
			}
			if (num >= 9) {
				roman = roman + "IX";
				num -= 9;
				continue;
			}
			if (num >= 5) {
				roman = roman + "V";
				num -= 5;
				continue;
			}
			if (num >= 4) {
				roman = roman + "IV";
				num -= 4;
				continue;
			}
			if (num >= 1) {
				roman = roman + "I";
				num -= 1;
				continue;
			}
		}
		return roman;
	}
}