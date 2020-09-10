package codingtest.site.codingInterview.stackAndQueue;


/**
 * 	1. Stack 을 정렬하는 프로그램을 작성
 * 	2. Stack 을 순회하면서 작은 값을 sortedStack 에 집어넣음.
 * 	3. sortedStack 에 최종적으로 제일 작은 값이 들어가도록 세팅
 * 	4. 그런 뒤, Stack 을 다 순회한 후, sortedStack 에 있는 것을 stack 으로 옮기면 제일 작은게 맨 위로 올라옴.
 */
public class Question3e
{
	public static void sort(Stack<Integer> stack)
	{
		Stack<Integer> tempStack = new Stack<Integer>();

		// stack 순회
		while ( !stack.isEmpty())
		{
			/** 
			 * 값을 꺼내서 tempStack 에 있는 값과 비교. 이 로직이 의미하는 바는 
			 * tmp 를 가져와서 tempStack 의 적절한 위치에 넣어준다는 것.
			 * tempStack 은 내림차순으로 정렬돼있음.
			 * tmp 가 제 위치를 찾아간 다음에는 stack 에 있는 값을 tempStack 에 넣어줌. 
			 */
			int tmp = stack.pop();
			while ( !tempStack.isEmpty() && tempStack.peek() > tmp)
			{
				stack.push(tempStack.pop());
			}
			tempStack.push(tmp);
		}
		
		// 내림차순 tempStack 을 stack 에 넣어주면 오름차순이 됨.
		while ( !tempStack.isEmpty())
			stack.push(tempStack.pop());
	}
	
	public static void sort1(Stack<Integer> stack)
	{
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> sortedStack = new Stack<Integer>();
		
		
		int max = stack.pop();
		do 
		{
			while ( !stack.isEmpty())
			{
				int tmp = stack.pop();
				if (tmp > max)
				{
					temp.push(max);
					max = tmp;
				}
				else
				{
					temp.push(tmp);
				}
			}
			sortedStack.push(max);
			while ( !temp.isEmpty())
				stack.push(temp.pop());
				
		} while( !stack.isEmpty());
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(20);
		stack.push(5);
		stack.push(13);
		
		System.out.println("before");
		System.out.println(stack);
		System.out.println("after");
		sort1(stack);
		System.out.println(stack);
	}
	
}
