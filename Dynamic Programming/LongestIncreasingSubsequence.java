import java.util.Scanner;
class LongestIncreasingSubsequence{
	public static void main(String[] args){
		int[] arr = {31,1,3,8,9,2,7,3,6,4,5};
		lis(arr);
		
	}
	public static void  lis(int[] arr){
		int[] temp = new int[arr.length]; 
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j <= i; j++){
					if(arr[j]<arr[i]){
						temp[i]=temp[j]+1;
					}
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(temp[i]>max){
				max=temp[i];
				
			}
		}
		int[] output= new int[max+1];
		int now=max+1;
		for(int i=arr.length-1;i>=0;i--){
			if(temp[i]==now-1){
				output[now-1]=arr[i];
				now--;
			}
		}
		System.out.println(max+1);
		for(int i=0; i<max+1;i++){
			System.out.println(output[i]);
		}
	}
	
}