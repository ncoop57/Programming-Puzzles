import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
	
	Node[] graph;
	
	private class Node
	{
		private ArrayList<Edge> adjList;
		private int num;
		private int layer;
		
		private boolean visited;
		
		public Node(int num)
		{
			
			adjList = new ArrayList<Edge>();
			this.num = num;
			this.layer = 0;
			visited = false;
			
		}
		
	}
	
	/** Used to connect nodes to each other */
	private class Edge
	{
		
		private int to;
		
		public Edge(int to)
		{
			
			this.to = to;
			
		}
		
	}
	
	/** Initialize the entire nodes that are in the graph */
	private void initGraph(int num)
	{
		
		graph = new Node[num];
		
		for(int i = 0; i < num; i++)
		{
			
			graph[i] = new Node(i);
			
		}
		
	}
	
	
	private void addEdge(int start, int to)
	{
		
		graph[start].adjList.add(new Edge(to));
		graph[to].adjList.add(new Edge(start));
		
	}
	
	private int bfs(int start, int end)
	{
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int current = -1;
		
		graph[start].layer = 0;
		
		queue.add(start);
		
		while(!queue.isEmpty())
		{
			
			current = queue.peek();
			graph[current].visited = true;
			
			for(Edge edge : graph[current].adjList)
			{
				
				if(!graph[edge.to].visited)
				{
					
					queue.add(graph[edge.to].num);
					graph[edge.to].visited = true;
					graph[edge.to].layer = graph[current].layer = 1;
					
				}
				
			}
			
			queue.poll();
			
		}
	
		for(Node node: graph)
			System.out.print(node.layer + " ");
		
		return graph[end].layer;
		
	}
	
	public static void main(String[] args)
	{
		
		Main main = new Main();
		int graphSize = 36;
		
		main.initGraph(graphSize);
		
		for(int i = 0; i < graphSize - 1; i++)
		{
			
				main.addEdge(i, i + 1);
			
			/*
			if(i > 5)
			{
				main.addEdge(i - 6, i);
				main.addEdge(i, i - 6);
			}*/
		}
		
		System.out.printf("That is only %d layers away!", main.bfs(0, 10));

	}

}
