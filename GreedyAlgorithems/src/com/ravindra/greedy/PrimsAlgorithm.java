package com.ravindra.greedy;

import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int weight;
	int parent;
	int vertex;
	
	public Node(int parent,int weight,int vertex){
		this.parent =parent;
		this.weight= weight;
		this.vertex =vertex;
	}
	
	@Override
	public int compareTo(Node node){
		return this.weight-node.weight;
	}
}
public class PrimsAlgorithm {

	public static void main(String[] args) {
		
		  int graph[][] = new int[][]{{0, 2, 0, 6, 0},
						              {2, 0, 3, 8, 5},
						              {0, 3, 0, 0, 7},
						              {6, 8, 0, 0, 9},
						              {0, 5, 7, 9, 0}};
						              
		 primsAlgorithm(graph);

	}
	
	
	public static void primsAlgorithm(int[][] graph){
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(-1,0,0));
		boolean[] visited = new boolean[graph.length];
		visited[0] =true;
		while(!queue.isEmpty()){
			Node n = queue.poll();
			for(int i=0;i<graph[0].length;i++){
				if(graph[n.vertex][i] !=0 && !visited[i]){
					System.out.println(n.vertex +"-" +i +"- "+ graph[n.vertex][i]);
					queue.add(new Node(n.vertex,graph[n.vertex][i],i));
					visited[i] =true;
				}
			}
			
		}
	}

}
