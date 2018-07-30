package com.ravindra.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
 

class HuffMan implements Comparable<HuffMan>{
	
	int freq;
	char element;
	HuffMan left;
	HuffMan right;
	
	public HuffMan(int freq, char element){
		this.freq = freq;
		this.element =element;
	}

	@Override
	public int compareTo(HuffMan huffMan) {
		return this.freq-huffMan.freq;
	}
}

 
public class HuffManCodes {

    public static void main(String[] args)
    {
    
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        huffManCodesAlgorithem(charArray,charfreq);
 
    } 
    
    public static void huffManCodesAlgorithem(char[] charArray, int[] freqArray){
    	
    	PriorityQueue<HuffMan> queue = new PriorityQueue<HuffMan>();
    	for(int i=0;i<charArray.length;i++){
    		queue.add(new HuffMan(freqArray[i], charArray[i]));
    	}
    	
    	HuffMan root = null;
    	while(queue.size()>1){
    		HuffMan huffman1 = queue.poll();
    		HuffMan huffman2 = queue.poll();
    		HuffMan result = new HuffMan(huffman1.freq+huffman2.freq, '-');
    		result.left=huffman1;
    		result.right=huffman2;
    		root =result;
    		queue.add(result);
    		
    	}
    	
    	printNodes(root, "");
    	
    }
    
   public static void printNodes(HuffMan root, String s){
	   
	   if(root ==null){
		   return;
	   }
	   if(root.left==null && root.right ==null && Character.isLetter(root.element)){
		   System.out.println(root.element + " "+s);
	   }
	   
	   printNodes(root.left,s+'0');
	   printNodes(root.right,s+'1');
    }
}
 
