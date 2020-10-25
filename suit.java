
/**
 * this class is for suits
 */

public enum suit {
	CLUB, DIAMOND, HEART, SPADE;
	
	public char suitAbbrev() {
		return toString().charAt(0);
	} // get first character

	// following method is used to transform arguments to suits
	public static char toSuit(char cha) {
		for (suit s : values()) {
			if (s.suitAbbrev() == cha)
				return cha;
		}
		return 'A'; // "A" for invalid input
	}

	// following method is used to determine if there is a flush
	public static boolean findFlush(char[] a) {
		int count = 1;
		for (int i = 1; i < 5; i++) {
			if (a[i] == a[i - 1])
				count++;
		}
		return count == 5;
	}
}