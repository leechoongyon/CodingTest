package codingtest.site.codingInterview.sort.Q10_05;

public class Question
{
	public static void main(String [] args)
	{
		String array[] = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(solve(array, "at"));
		System.out.println(solve(array, "ball"));
		System.out.println(solve(array, "car"));
		System.out.println(solve(array, "dad"));
	}
	
	public static int solve(String array[], String ball)
	{
		/**
		 * 	1. 일단 이진 탐색
		 * 	2. "" 이 나오면, 양 옆으로 조회
		 */
		return binarySearch(array, ball, 0, array.length - 1);
	}
	
	public static int binarySearch(String array[], String ball, int first, int last)
	{
		/** 기저 사례 */
		if (first == last)
		{
			if (array[first].equals(ball)) return first;
			else return -1;
		}
		
		int mid = (first + last) / 2;
		int index = 0;
		if (array[mid].equals(ball)) return mid;
		else if (array[mid] == "")
		{
			index = binarySearch(array, ball, first, mid);
			if (index != -1) return index;
			index = binarySearch(array, ball, mid + 1, last);
			if (index != -1) return index;
		}
		else if (array[mid].compareTo(ball) < 0)
		{
			return binarySearch(array, ball, mid + 1, last);
		}
		else if (array[mid].compareTo(ball) > 0)
		{
			return binarySearch(array, ball, first, mid);
		}
		else 
		{
			System.out.println("???");
		}
		return -1;
	}
}
