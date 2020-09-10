package codingtest.site.datastructure;

public class LinkedList {
	private Node top;
	private Node tail;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (top == null) {
			top = newNode;
			tail = top;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public int getLast() {
		if (tail == null) {
			throw new RuntimeException("Empty LinkedList");
		} else {
			return tail.data;
		}
	}
	
	@Override
	public String toString() {
		return "LinkedList [top=" + top + ", tail=" + tail + "]";
	}



	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		System.out.println(linkedList.getLast());
	}
}
