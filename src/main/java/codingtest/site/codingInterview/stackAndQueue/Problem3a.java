package codingtest.site.codingInterview.stackAndQueue;

public class Problem3a
{
	public static void main(String [] args)
	{
		FixedMultiStack stacks = new FixedMultiStack(3);
		stacks.push(0, 1);
		stacks.push(0, 2);
		stacks.push(0, 3);
		stacks.push(1, 4);
		stacks.push(1, 5);
		stacks.push(1, 6);
		stacks.push(2, 7);
		stacks.push(2, 8);
		stacks.push(2, 9);
		
		Object values[] = stacks.getValues();
		for (Object obj : values)
			System.out.print(obj + " ");
	}
}
