package codingtest.site.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lee
 * @point & feedback
 * 	1. 문제에서 Stacks 이라고 명시되있어서 쉽게 풀 수 있었음.
 * 	2. Example 을 찾을 때 너무 편향되게 찾음. 예외 Example 을 찾아야 한다는 것을 명심
 * 	3. 알고리즘은 애니팡 같은걸 생각하면 될듯. 같은 모양이 들어오면 지워지는 것처럼
 * 	   brackets 이 같은게 stack 에서 만나면 지워지도록. 
 * 	4. 최종적으로 아무 것도 안남게 된다면 match  
 */
public class BalancedBrackets
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++)
		{
			String expression = in.next();
			System.out.println(( isBalanced(expression) ) ? "YES" : "NO");
		}
	}
	
	public static boolean isBalanced(String expression)
	{
		BalancedBracketsStack stack = new BalancedBracketsStack();
		for (char c : expression.toCharArray())
		{
			stack.push(c);
		}
		
		if (stack.size() == 0)
			return true;
		else
			return false;
	}
}

class BalancedBracketsStack
{
	List<Character> list;
	
	public BalancedBracketsStack()
	{
		list = new ArrayList<Character>();
	}
	
	public void push(Character c)
	{
		int listSize = list.size();
		if (listSize == 0)
			list.add(c);
		else
		{
			if (list.get(listSize - 1) == '[')
			{
				if (c == ']')
					list.remove(listSize - 1);
				else
					list.add(c);
			}
			else if (list.get(listSize - 1) == '(')
			{
				if (c == ')')
					list.remove(listSize - 1);
				else
					list.add(c);
			}
			else if (list.get(listSize - 1) == '{')
			{
				if (c == '}')
					list.remove(listSize - 1);
				else
					list.add(c);
			}
			else
				list.add(c);
		}
	}
	
	public int size()
	{
		return list.size();
	}
}