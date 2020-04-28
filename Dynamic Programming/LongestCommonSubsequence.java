import java.util.*;
class LongestCommonSubsequence{
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args){
		String s1="cdapmrwqmtl";
		String s2 ="ampdcrkqgt";
		System.out.println(lcs(s1,s2,s1.length(),s2.length()));
		printLcs();
		
	}
	public static int lcs(String s1, String s2,int e1, int e2){
		if(e1>0 && e2>0){
			if(s1.charAt(e1-1)==s2.charAt(e2-1)){
				// stack.push(s1.charAt(e1-1));
				return 1+lcs(s1,s2,e1-1,e2-1);
				
			}
			else{
				return Integer.max(lcs(s1,s2,e1-1,e2),lcs(s1,s2,e1,e2-1));
			}
		}
		else{
			return 0;
		}
	}
	// public static void printLcs(){
		
		// System.out.print(stack);
		
	// }
	
}