package com.ravindra.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharFreq implements Comparable<CharFreq>{
	char element;
	int frequency;
	
	public CharFreq(char element, int frequency){
		this.element =element;
		this.frequency =frequency;
	}
	
	@Override
	public int compareTo(CharFreq a){
		return this.frequency- a.frequency;
	}
}
public class RearrangeDDistance {

	public static void main(String[] args) {
		  String str = "geeksforgeeks";
		  rearrange(str, 3);

	}
	
	public static void rearrange(String str, int distance){
		
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			if(map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), 1+map.get(str.charAt(i)));
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		
		PriorityQueue<CharFreq> queue = new PriorityQueue<CharFreq>();
		
		for(Character c: map.keySet()){
			queue.add(new CharFreq(c,map.get(c)));
		}
		
		char[] str2 = new char[str.length()];
		
		for(int i=0;i<map.size();i++){
			CharFreq c = queue.poll();
			int p = i;
			
			while(str2[p]!='\0')
				p++;
			
			for(int j=0;j<c.frequency;j++){
					if(p+distance*j>=str2.length){
						System.out.println("Not possible");
					}
					str2[p+distance*j] =c.element;
			}
		}
						
			System.out.println(str2);
		}
		
	}

