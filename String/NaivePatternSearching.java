class NaivePatternSearching{
	public static void main(String[] args){
		String s1=  "orn";
		String s2= "Good morning";
		System.out.println(search(s2,s1));
	}
	
	public static boolean search(String s1, String s2){
		for(int i=0; i<s1.length(); i++){
			if(s1.charAt(i)==s2.charAt(0)){
				int k=i+1;
				for(int j=1;j<s2.length();j++){
					if(s1.charAt(k)==s2.charAt(j)){
						k++;
						if(j==s2.length()-1){
							System.out.println(i);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}