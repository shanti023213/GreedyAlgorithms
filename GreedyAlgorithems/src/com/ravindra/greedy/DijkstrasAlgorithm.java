package com.ravindra.greedy;

public class DijkstrasAlgorithm {

	public static void main(String[] args) {
	     int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
           dijkstra(graph, 0);

	}
	
	public static void dijkstra(int[][] graph, int start){
		
		int[] distance = new int [graph.length];
		for(int i=0;i<graph.length;i++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[graph.length];
		distance[0] =0;
		//visited[0] =true;
		
		for(int i=0;i<graph.length;i++){
			
			int source = min(distance,visited);
			visited[source] =true;
			
			for(int j=0;j<graph[0].length;j++){
				
				if(graph[source][j] !=0 && !visited[j]){
					distance[j] = Math.min(distance[source] + graph[source][j] , distance[j]);
				}
			}
		}
		
		System.out.println("*****");
	}
	
	public static int min(int[] dist, boolean[] visited){
		int min = Integer.MAX_VALUE; int minIndex=-1;
		
		for(int i=0;i<dist.length;i++){
			if(!visited[i] && dist[i] <min){
				min = dist[i];
				minIndex=i;
			}
		}
		
		return minIndex;
	}

}
