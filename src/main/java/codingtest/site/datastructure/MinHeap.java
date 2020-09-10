package codingtest.site.datastructure;

import java.util.Arrays;

public class MinHeap
{
	private int heap[] = null;
	private int size;
	private int maxSize;
	private final int ROOT = 1;
	
	public MinHeap(int maxSize)
	{
		this.maxSize = maxSize;
		size = 0;
		// maxSize + 1 인 이유는 parent, child 계산을 쉽게 하기 위해, 0번째 index 는 비워둔채 사용.
		heap = new int[maxSize + 1];
		heap[0] = -Integer.MAX_VALUE;
	}

	/**
	 * 	1. 맨 마지막에 집어넣는다.
	 * 	2. 부모노드와 현재 노드를 비교.
	 * 	3. 현재 노드가 작으면 swap
	 * 	4. 2,3 번을 반복
	 */
	public void insert(int element)
	{
		heap[++size] = element;
		int current = size;
		
		// parent 의 끝은 결국 0이며, heap[1] > heap[0] 이기에 heap[0] < heap[0] 은 수행 안된다.
		while (heap[current] < heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	/**
	 *
	 * 	1. ROOT 에 있는 값을 가져온다.
	 * 	2. 맨 마지막에 있는 값을 ROOT 로 가져온다.
	 * 		- 맨 마지막에 있는 값은 0으로 변경
	 * 		- size--
	 * 	3. ROOT 부터 왼쪽, 오른쪽 자식 노드를 비교하면서 제 자리를 찾아가도록 한다.
	 * 		- 최종적으로 ROOT 는 가장 작은 값이 된다. 
	 */
	public int remove()
	{
		int min = heap[ROOT];
		heap[ROOT] = heap[size];
		heap[size] = 0;
		size--;
		
		int current = ROOT;
		
		while ( !isLeaf(current))
		{
			if (heap[current] > heap[leftChild(current)] || 
				heap[current] > heap[rightChild(current)])
			{
				if (heap[leftChild(current)] < heap[rightChild(current)])
				{
					swap(current, leftChild(current));
					current = leftChild(current);
				}
				else
				{
					swap(current, rightChild(current));
					current = rightChild(current);
				}
			}
			else
				break;
		}
		
		return min;
	}
	
	/**
	 *	@desc 자식노드가 없는가? 
	 */
	private boolean isLeaf(int current)
	{
		if (rightChild(current) > size)
			return true;
		return false;
	}
	
	private void swap(int a, int b)
	{
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	private int parent(int current)
	{
		return current / 2;
	}
	
	private int leftChild(int current)
	{
		return (current * 2);
	}
	
	private int rightChild(int current)
	{
		return (current * 2) + 1;
	}
	
	@Override
	public String toString()
	{
		return "MinHeap2 [heap=" + Arrays.toString(heap) + ", size=" + size + ", maxSize=" + maxSize + "]";
	}

	public static void main(String [] args)
	{
		MinHeap heap = new MinHeap(15);
		heap.insert(6);
		heap.insert(3);
		heap.insert(4);
		heap.insert(2);
		heap.insert(2);
		heap.insert(2);
		heap.insert(2);
		heap.insert(2);
		heap.insert(1);
		System.out.println(heap);
		System.out.println(heap.remove());
		System.out.println(heap);
		System.out.println(heap.remove());
		System.out.println(heap);
		System.out.println(heap.remove());
		System.out.println(heap);
		System.out.println(heap.remove());
		System.out.println(heap);
		System.out.println(heap.remove());
		System.out.println(heap);
		System.out.println(heap.remove());
	}
}
