package codingtest.site.codingInterview.stackAndQueue;

public class Problem3c
{
	public static void main(String[] args)
	{
		SetOfStacks stacks = new SetOfStacks(5);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		stacks.push(8);
		stacks.push(9);
		stacks.push(10);
		stacks.push(11);
		stacks.push(12);
		stacks.push(13);
		for (Stack s : stacks.getStacks())
			System.out.println(s);

		stacks.popAt(2);
		System.out.println();
		for (Stack s : stacks.getStacks())
			System.out.println(s);
		
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		
		System.out.println();
		for (Stack s : stacks.getStacks())
			System.out.println(s);
		
		
	}
}
