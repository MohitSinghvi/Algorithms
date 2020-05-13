class KnapSack01{
	public static void main(String[] args){
		int[] value ={6,10,12};
		int[] weight={1,2,3};
		int capacity=5;
		
		System.out.println(getMaxProfit(value,weight,capacity,0));
		System.out.println(getMaxProfit(value,weight,capacity));
	}
	// Simple Recursion - time: O(2^n)
	public static int getMaxProfit(int[] value, int[] weight, int capacity,int start){
		if(start==weight.length){
			return 0;
		}
		if(weight[start]>capacity){
			return 0;
		}
		return(Math.max(getMaxProfit(value,weight,capacity,start+1),value[start]+getMaxProfit(value,weight,capacity-weight[start],start+1)));
		
	}
	//Dynamic programming - 
	public static int getMaxProfit(int[] value, int[] weight, int capacity){
		int[][] dp_table = new int[weight.length+1][capacity+1];
		for(int i=0;i<capacity+1;i++){
			dp_table[0][i]=0;
		}
		for(int i=0;i<weight.length+1;i++){
			dp_table[i][0]=0;
		}
		int curr_cap=capacity;
		for(int i=1;i<weight.length+1;i++){
			for(int j=1;j<capacity+1;j++){
				dp_table[i][j]=dp_table[i-1][j];
				if(j>=weight[i-1]){
					int val = value[i-1] + dp_table[i-1][j-weight[i-1]];
					
					if(val>dp_table[i][j]){
						dp_table[i][j]=val;
					}
				}
			}
		}
		
		return dp_table[weight.length][capacity];
	}
	
}