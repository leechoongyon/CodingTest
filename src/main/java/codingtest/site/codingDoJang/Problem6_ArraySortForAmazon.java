package codingtest.site.codingDoJang;

public class Problem6_ArraySortForAmazon {
	public static void main(String[] args) {
		String str[] = { "a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4",
				"b5" };

		int L = str.length, l = L / 2;

		String after[] = new String[L];

		for (int i = 0; i < l; i++) {
			after[i * 2] = str[i];
			after[i * 2 + 1] = str[l + i];
		}

		for (int i = 0; i < after.length; i++)
			System.out.print(after[i] + " ");
	}

}
