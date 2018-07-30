package com.ravindra.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Job implements Comparable<Job>{
	char element;
	int deadline;
	int profit;
	
	public Job(char element, int deadline,int profit){
		this.element =element;
		this.deadline =deadline;
		this.profit =profit;
	}
		
	@Override
	public int compareTo(Job job){
		return job.profit-this.profit;
	}
}

public class JobSequencingDeadLines {

	public static void main(String[] args) {
	      	ArrayList<Job> arr=new ArrayList<Job>();
	        arr.add(new Job('a',2,100));
	        arr.add(new Job('b',1,19));
	        arr.add(new Job('c',2,27));
	        arr.add(new Job('d',1,25));
	        arr.add(new Job('e',3,15));
	     
	        
	        printJobScheduling(arr);
	}
	
	
	public static void printJobScheduling(ArrayList<Job> list){
		
		PriorityQueue<Job> queue = new PriorityQueue<Job>();
		int maxDeadline =0;
		
		for(Job job:list){
			queue.add(job);
			if(maxDeadline<job.deadline){
				maxDeadline =job.deadline;
			}
		}
		
		char[] result = new char[maxDeadline];
		int i=0;
		
		while(!queue.isEmpty() && i<maxDeadline){
			Job job = queue.poll();
			
			int maxIndex = job.deadline;
			while(maxIndex>0){
				if(result[maxIndex-1]==0){
					result[maxIndex-1] =job.element;
					break;
				}else{
					maxIndex--;
				}
			}
		}
		
		for(int j=0;j<maxDeadline;j++){
			System.out.println(result[j]);
		}
		
	}

}
