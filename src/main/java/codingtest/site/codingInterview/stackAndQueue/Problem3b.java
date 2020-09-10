package codingtest.site.codingInterview.stackAndQueue;

public class Problem3b
{
	public static void main(String [] args)
	{
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(6);
		stack.push(2);
		
		System.out.println(stack);
		
		System.out.println("min value : " + stack.getMinValue());
		stack.pop();
		System.out.println("min value : " + stack.getMinValue());
		stack.pop();
		System.out.println("min value : " + stack.getMinValue());
		stack.pop();
		System.out.println("min value : " + stack.getMinValue());
	}
}
