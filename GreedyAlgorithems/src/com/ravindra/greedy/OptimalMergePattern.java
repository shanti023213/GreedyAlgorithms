package com.ravindra.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class OptimalMerge implements Comparable<OptimalMerge>{
	int records;
	char element;
	
	OptimalMerge left;
	OptimalMerge right;
	
	public OptimalMerge(char element, int records){
		this.element=element;
		this.records =records;
	}
	
	@Override
	public int compareTo(OptimalMerge a){
		return this.records-a.records;
	}
}
public class OptimalMergePattern {
	
	static int result;

	public static void main(String[] args) {
			ArrayList<OptimalMerge> list = new ArrayList<OptimalMerge>();
			list.add(new OptimalMerge('a',40));
			list.add(new OptimalMerge('b',10));
			list.add(new OptimalMerge('c',20));
			list.add(new OptimalMerge('d',15));
			list.add(new OptimalMerge('e',25));
			list.add(new OptimalMerge('f',30));
			
			optimalMerge(list);
			System.out.println(result);
			
			result =0;
			ArrayList<OptimalMerge> list1 = new ArrayList<OptimalMerge>();
			list1.add(new OptimalMerge('a',10));
			list1.add(new OptimalMerge('b',20));
			list1.add(new OptimalMerge('c',30));
			
			optimalMerge(list1);
			System.out.println(result);
	}
	
	public static void optimalMerge(ArrayList<OptimalMerge> list){
		
		PriorityQueue<OptimalMerge> queue = new PriorityQueue<OptimalMerge>();
		queue.addAll(list);
		
		OptimalMerge root = null;
		while(queue.size()>1){
			OptimalMerge a = queue.poll();
			OptimalMerge b = queue.poll();
			
			OptimalMerge c = new OptimalMerge('-' , a.records+b.records);
			c.left =a;
			c.right =b;
			root =c;
			queue.add(c);
		}
		
		mergeLength(root,0);
	}
	
	public static void mergeLength(OptimalMerge node, int length){
		
		if(node== null){
			return ;
		}
		
		if(node.left==null && node.right==null && Character.isLetter(node.element)){
			
			result += node.records *length;
		}
		mergeLength(node.left ,length+1);
		mergeLength(node.right ,length+1);
		
		
	
	}

}
