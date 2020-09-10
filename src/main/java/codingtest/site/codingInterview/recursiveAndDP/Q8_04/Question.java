package codingtest.site.codingInterview.recursiveAndDP.Q8_04;

import java.util.ArrayList;
import java.util.List;

public class Question
{
	public static void main(String[] args)
	{
		int arr[] = new int[] {1,2,3,4,5};
		combination(arr); 
	}
	
	public static void combination(int arr[])
	{
		for (int i = 0 ; i <= arr.length ; i++)
		{
			combination(arr, 0, i, new ArrayList<Integer>(), new boolean[arr.length]);
		}
	}
	
	public static void combination(int arr[], int start, int r, List<Integer> list, boolean visited[])
	{
		if (r == list.size()) 
		{
			print(list);
			return ;
		}
		
		for (int i = start ; i < arr.length ; i++)
		{
			if (visited[i] == false)
			{
				visited[i] = true;
				list.add(arr[i]);
				combination(arr, i + 1, r, list, visited);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void print(List<Integer> list)
	{
		for (int i : list)
			System.out.print(i + " ");
		System.out.println();
	}
}