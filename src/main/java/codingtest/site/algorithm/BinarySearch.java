package codingtest.site.algorithm;

public class BinarySearch {
	public static int Binarysearch(int[] numbers, int key, int min, int max) {
		if (min > max)
			throw new RuntimeException("Not found.");

		int mid = (min + max) / 2;
		System.out.println("Searching... Middle index = " + mid);

		if (key == numbers[mid])
			return key;
		else if (key > numbers[mid])
			return Binarysearch(numbers, key, mid + 1, max);
		else if (key < numbers[mid])
			return Binarysearch(numbers, key, min, mid - 1);
		else
			throw new RuntimeException("Not found.");
	}
}
