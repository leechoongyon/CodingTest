package codingtest.site.codingInterview.treeAndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 방향 그래프가 주어졌을 때, 두 노드 사이에 경로가 존재하는지 확인하는 알고리즘을 작성하라.
 * 
 *  1. 방향 그래프를 어떻게 구현해야하는가?
 *  	- 인접 행렬과 인접리스트가 있음.
 *  2. BFS 이용해서 두 노드 사이에 거리를 구함.
 *  	- DFS 는 끝까지 접근해서 값을 찾기에, 최악의 경우가 발생할 확률이 높음.
 *  
 *  1 --> 2, 3
 *  2 --> 3, 4
 *  3 --> 4, 5
 *  4 --> 5
 *  
 *  graph 는 모든 node 를 가지고 있고, node 는 인접한 노드를 가지고 있다.
 *  
 */
public class Question4a
{
	private static Queue<Node> queue = new LinkedBlockingQueue<Node>();
	
	public static class Graph
	{
		private List<Node> nodes;
		
		public Graph ()
		{
			nodes = new ArrayList<Node>();
		}
		
		public void addNode(Node n)
		{
			nodes.add(n);
		}

		public List<Node> getNodes()
		{
			return nodes;
		}
		
		@Override
		public String toString()
		{
			return "Graph [nodes=" + nodes + "]";
		}
	}
	
	
	public static class Node
	{
		private Object item;
		private List<Node> adjacent = new ArrayList<Node>();
		private boolean visited = false;
		
		public Node(Object item)
		{
			this.item = item;
		}
		
		public void addAdjacent(Node n)
		{
			adjacent.add(n);
		}
		
		public List<Node> getAdjacent()
		{
			return adjacent;
		}

		@Override
		public String toString()
		{
			return "Node [item=" + item + ", adjacent=" + adjacent + "]";
		}
	}
	
	public static void main(String [] args)
	{
		Graph graph = new Graph();
		
		Node n = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		
		// 1 --> 2
		n.addAdjacent(n1);
		graph.addNode(n);
		
		// 2 --> 3
		n1.addAdjacent(n2);
		graph.addNode(n1);
		
		// 3 --> 5
		n2.addAdjacent(n4);
		graph.addNode(n2);
		
		// 4 --> 5
		n3.addAdjacent(n4);
		graph.addNode(n3);
		
		graph.addNode(n4);
		
		search(graph, n, n3);
	}
	
	public static void search(Graph graph, Node start, Node end)
	{
		queue.add(start);
		start.visited = true;
		
		while ( !queue.isEmpty())
		{
			Node n = queue.poll();
			for (Node adj : n.getAdjacent())
			{
				if (adj.equals(end))
				{
					System.out.println("Path exists.");
					return ;
				}
				if (adj.visited == false)
				{
					adj.visited = true;
					queue.add(adj);
				}
			}
		}
		System.out.println("Path is not exists.");
	}
}














