import java.util.Scanner;
class Permutations{
	public static void main(String[] args){
		
		printStringPermutation();
		
	}
	public static void printStringPermutation(){
		char[] input = {'a','b','c'};
		permutation(input,0,input.length-1);
		
		
	}
	public static void permutation(char[] s,int l,int r){
		if(l==r){
			System.out.println(s);
		}
		for(int i=l;i<= r;i++){
			char temp = s[l];
			s[l]=s[i];
			s[i]=temp;
			permutation(s,l+1,r);
			// temp = s[l];
			// s[l]=s[i];
			// s[i]=temp;
		}
		
	}
	
	
}
