//Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter
import java.util.Scanner;
class CoinChange{
	public static void main(String[] args){
		// Scanner sc = new Scanner(System.in);
		int n = 4;;
		int[] arr={1,2,3};
		System.out.println(getChangeWays(arr,arr.length,n));
		System.out.println(getChangeWays(arr,n));
		
	}
	
	//Naive Recursive - Exponential time complexity
	public static int getChangeWays(int[] arr, int m, int n){
		if(m<=0 && n>=1){
			return 0;
		}
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		return getChangeWays(arr,m,n-arr[m-1])+getChangeWays(arr,m-1,n);
	}
	//Dynamic programming - O(mn) m: no. of array elements, n: amount to be changed 
	public static int getChangeWays(int[] arr,int val){
		int[][] change = new int[arr.length+1][val+1];
		
		
		for(int i=0;i<change.length;i++){
			change[i][0]=1;
		}
		for(int i=1;i<val+1;i++){
			change[0][i]=0;
		}
		for(int i=1;i<change.length;i++){
			for(int j=1;j<val+1;j++){
				if(j-arr[i-1]>=0){
					change[i][j]=change[i-1][j]+change[i][j-arr[i-1]];
				}
				else{
					change[i][j]=change[i-1][j];
				}
			}
		}
		return change[arr.length][val];
	}
}