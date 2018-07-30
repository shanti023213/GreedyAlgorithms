package com.ravindra.greedy;

import java.util.PriorityQueue;

public class CostOfConnectingRopes {

	public static void main(String[] args) {
		  int len[] = {2,3,5,7,9,13};
		  System.out.println(costConnectingRopes(len));

	}
	
	public static int costConnectingRopes(int[] ropesList){
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			for(int i=0;i<ropesList.length;i++){
				queue.add(ropesList[i]);
			}
			
			while(queue.size()>1){
				
					int a = queue.poll();
					int b = queue.poll();
					
					int result = a+b;
					queue.add(result);
				}
			
			return queue.poll();
			}
	}


