package codingtest.site.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoNumbers
{
	public static int[] stringToIntegerArray(String input)
	{
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0)
		{
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++)
		{
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input)
	{
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues)
		{
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node)
	{
		if (node == null)
		{
			return "[]";
		}

		String result = "";
		while (node != null)
		{
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null)
		{
			ListNode l1 = stringToListNode(line);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);

			ListNode ret = new Solution().addTwoNumbers(l1, l2);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}
	
	public static class Solution
	{
		public ListNode addTwoNumbers(ListNode l1, ListNode l2)
		{
			ListNode result = null;
			ListNode tail = null;
			int digitSum = 0;
			int nextDigitAddNum = 0;
			int val1 = 0;
			int val2 = 0;
			while (l1 != null || l2 != null || nextDigitAddNum != 0)
			{
				val1 = (l1 == null) ? 0 : l1.val;
				val2 = (l2 == null) ? 0 : l2.val;
				digitSum = val1 + val2;
				if (nextDigitAddNum != 0)
				{
					digitSum += nextDigitAddNum;
					nextDigitAddNum = 0;
				}
				if (digitSum >= 10)
				{
					digitSum -= 10;
					nextDigitAddNum = 1;
				}
				
				ListNode newNode = new ListNode(digitSum);
				if (result == null) 
				{
					result = newNode;
					tail = result;
				}
				else
				{
					tail.next = newNode;
					tail = newNode;
				}
				l1 = (l1 == null) ? null : l1.next;
				l2 = (l2 == null) ? null : l2.next;
			}
			return result;
		}
	}
	
	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int val)
		{
			this.val = val;
		}
		@Override
		public String toString()
		{
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
}