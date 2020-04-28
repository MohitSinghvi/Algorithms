class MinCostPath{
	public static void main(String[] args){
		int[][]arr={{1,2,3},
					{4,8,2},
					{1,5,3}
					};
		System.out.println(mcp(arr,arr.length-1,arr[arr.length-1].length-1));
		System.out.println(mcp(arr));
	}
	public static int min(int a,int b, int c){
		if(a<b){
			return (a<c)?a:c;
		}
		else{
			return (b>c)?b:c;
		}
	}
	//Naive(Recursvie)(O(2^n))
	public static int mcp(int[][] arr, int i,int j){
		if(i==0 && j==0){
			return arr[i][j];
		}
		else{
			int up,left,diagonal;
			if(i!=0 && j!=0){
				up = mcp(arr,i-1,j);
				left = mcp(arr,i,j-1);
				diagonal = mcp(arr,i-1,j-1);
			}
			else if(i==0){
				up=Integer.MAX_VALUE;
				left = mcp(arr,i,j-1);
				diagonal=Integer.MAX_VALUE;
			}
			else{
				up = mcp(arr,i-1,j);
				left=Integer.MAX_VALUE;
				diagonal=Integer.MAX_VALUE;
			}
			
			int min;
			if(up<left){
				if(up<diagonal){
					min=up;
				}
				else{
					min=diagonal;	
				}
			}
			else{
				if(left<diagonal){
					min=left;
				}
				else{
					min=diagonal;	
				}
			}
			// System.out.println(min);
			return min+arr[i][j];
		}
	}
	
	//Dynami Programming - O(n^2)
	public static int mcp(int[][] arr){
		int[][] mincost = new int[arr.length][arr[arr.length-1].length];
		mincost[0][0]=arr[0][0];
		for(int i=1;i<arr.length;i++){
			mincost[i][0]=mincost[i-1][0]+arr[i][0];
		}
		for(int j=1;j<arr[arr.length-1].length;j++){
			mincost[0][j]=mincost[0][j-1]+arr[0][j];
		}
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[arr.length-1].length;j++){
				mincost[i][j]=arr[i][j]+min(mincost[i-1][j],mincost[i][j-1],mincost[i-1][j-1]);
			}
		}
		
		return mincost[mincost.length-1][mincost.length-1];
		
	}
	
}
