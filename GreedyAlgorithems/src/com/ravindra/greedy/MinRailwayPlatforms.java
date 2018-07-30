package com.ravindra.greedy;

import java.util.Arrays;

public class MinRailwayPlatforms {

	public static void main(String[] args) {
		 int arr[] = {900, 940, 950, 1100, 1500, 1800};
		 int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		 minPlatformsNeeded(arr,dep);
	}
	
	public static void minPlatformsNeeded(int[] arr, int[] dep){
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int noOfPlatforms = 1;
		//int i=1; 
		  int j = 0;
	        int rooms = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] < dep[j]) {
	                rooms++;
	            } else {
	                j++;
	            }
	        }
		
		System.out.println("Min platforms" +rooms);
	}

}
