package com.cxins.cn.message.webserviceTest;
//快速 排序 --- 分治
public class QuickSort {

  public void quickAsc(int[] nums,int left,int right){
	     if(left<right){
		     int begin=left;
		     int end=right;
		     int key=nums[begin];
		     while(left<right){
		    	 while(left<right&&key<=nums[right]){
		    		 right--;
		    	 }
		    	 while(left<right&&key>=nums[left]){
		    		 left++;
		    	 }
		    	 if(left<right){
		             int temp=nums[left];
		             nums[left]=nums[right];
		             nums[right]=temp;
		    	 }
		     }

	    	 int t=nums[left];
             nums[left]=nums[begin];
             nums[begin]=t;
		     for(int n:nums){
		    	 System.out.print(n+" ");
		     }
		     System.out.println();
			 quickAsc(nums,begin,left-1);
		     quickAsc(nums,left+1,end);
	     }
  }
  
  public void quickDesc(int[] nums,int left,int right){
	     if(left<right){
		     int begin=left;
		     int end=right;
		     int key=nums[begin];
		     while(left<right){
		    	 while(left<right&&key>=nums[right]){
		    		 right--;
		    	 }
		    	 while(left<right&&key<=nums[left]){
		    		 left++;
		    	 }
		    	 if(left<right){
		             int temp=nums[left];
		             nums[left]=nums[right];
		             nums[right]=temp;
		    	 }
		     }
		
	    	 int t=nums[left];
             nums[left]=nums[begin];
             nums[begin]=t;
             for(int n:nums){
		    	 System.out.print(n+" ");
		     }
		    
		     System.out.println();
		     quickDesc(nums,begin,left-1);
		     quickDesc(nums,left+1,end);
	     }
  }
  public static void main(String[] args){
	  int[] ori={45,9,40,60,30,-10,3,2,15,100,105,90,70,40};
	  //int[] ori={2,4,9,3,6,7,1,5};
	  //int[] ori={10,5,4,3,2,9,18,19,20,17};
	  int i=0;
	  int j=ori.length-1;
	  new QuickSort().quickAsc(ori,i,j);
	 // new QuickSort().quickDesc(ori,i,j);
	  
  }
}
