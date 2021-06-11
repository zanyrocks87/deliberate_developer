package rocks.zany.deliberatedeveloper;

class Gcd {

	public static int gcd(int m, int n) {
		if ((m % n) == 0) {
			return n;
		} else {
			// Here the number sequence changes if m < n
			return gcd(n, (m % n));
		}
	}

	public static void main(String[] args) {
		System.out.println(gcd(75, 60));
	}

}