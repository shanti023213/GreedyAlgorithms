package com.ravindra.greedy;

import java.util.PriorityQueue;

class MinHeap implements Comparable<MinHeap>{
	int weight;
	int profit;
	int profitWeightRatio;
	
	public MinHeap(int weight,int profit){
		this.weight =weight;
		this.profit =profit;
		this.profitWeightRatio = this.profit/this.weight;
	}

	@Override
	public int compareTo(MinHeap profitWeight) {
		return profitWeight.profitWeightRatio-this.profitWeightRatio;
	}
}

public class KnapSack {

	public static void main(String[] args) {
		int W = 50; 
	    int[] weight = {10,20,30};
	    int[] profit = {60,100,120};
	    System.out.println(knapSack(W, weight, profit));
	    

	}
	
	public static int knapSack(int totalWeight, int[] weightArray, int[] profitArray){
		
		int targetWeight = totalWeight;
		int totalProfit =0;
		PriorityQueue<MinHeap> queue = new PriorityQueue<MinHeap>();
		for(int i=0;i<weightArray.length;i++){
			queue.add(new MinHeap(weightArray[i], profitArray[i]));
		}
		
		while(!queue.isEmpty()){
			MinHeap element = queue.poll();
			if(element.weight<=targetWeight){
				totalProfit +=element.profit;
				targetWeight-=element.weight;
			}else if(targetWeight>0){
				totalProfit +=(targetWeight)* element.profitWeightRatio;
			}
		}
		return totalProfit;
	}

}
