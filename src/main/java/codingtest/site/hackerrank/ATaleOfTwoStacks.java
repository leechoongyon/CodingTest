package codingtest.site.hackerrank;

import java.util.Scanner;
import java.util.Stack;


/**
 * @file		hackerrank.ATaleOfTwoStacks.java
 * @filetype	java source file
 * @brief
 * @author		USER
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			USER		2018. 2. 3.		신규작성
 *
 * @point & feedback
 * 1. Stack 의 데이터를 옮겨가며 하는 것이 핵심
 * 2. 나는 전체 operation 에 데이터를 왔다갔다 하면 되는 건줄알았는데 더할 때는 그냥 더하면 됨.
 * 3. 옮기는 건 new -> old 만 필요
 * 4. 또 다른 핵심은 old 에 데이터가 있으면 넣을 필요가 없음. 어차피 맨 위니까
 */
public class ATaleOfTwoStacks
{
    public static class MyQueue<T>
    {
	Stack<T> stackNewestOnTop = new Stack<T>();
	Stack<T> stackOldestOnTop = new Stack<T>();

	public void enqueue(T value)
	{
	    stackNewestOnTop.add(value);
	}

	public T dequeue()
	{
	    transferData();
	    return stackOldestOnTop.pop();
	}

	public T peek()
	{
	    transferData();
	    return stackOldestOnTop.peek();
	}

	public void transferData()
	{
	    if (stackOldestOnTop.isEmpty())
		while (!stackNewestOnTop.isEmpty())
		    stackOldestOnTop.push(stackNewestOnTop.pop());
	}
    }

    public static void main(String[] args)
    {
	MyQueue<Integer> queue = new MyQueue<Integer>();

	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();

	for (int i = 0; i < n; i++)
	{
	    int operation = scan.nextInt();
	    if (operation == 1)
	    { // enqueue
		queue.enqueue(scan.nextInt());
	    } else if (operation == 2)
	    { // dequeue
		queue.dequeue();
	    } else if (operation == 3)
	    { // print/peek
		System.out.println(queue.peek());
	    }
	}
	scan.close();
    }
}
