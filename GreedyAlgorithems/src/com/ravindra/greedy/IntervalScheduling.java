package com.ravindra.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval implements Comparable<Interval>{
	int start;
	int end;
	
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Interval a){
		return this.end-a.end;
	}
}

public class IntervalScheduling {

	public static void main(String[] args) {
		int[][] intervals = {{10,13} ,{9,14}, {7,11},{12,16},{20,25} ,{1,50}};
		findIntervals2(intervals);
	}
	
	
	public static void findIntervals2(int[][] intervals){
		
		List<Interval> list = new ArrayList<Interval>();
		for(int i=0;i<intervals.length;i++){
			list.add(new Interval(intervals[i][0],intervals[i][1]));
		}
		
		Collections.sort(list);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(list.get(0).end);
		int count=1;
		
		for(int i=1;i<list.size();i++){
			if(list.get(i).start>queue.peek()){
				count++;
				queue.poll();
				queue.add(list.get(i).end);
			}
		}
		
		System.out.println("No Of Meeting Rooms needed:"+( 1+intervals.length-count));
		
	}



}
