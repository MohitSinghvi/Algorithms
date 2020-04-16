//Dijkstras algorithm is single source shortest path algorithm
import java.util.*;
class DijkstraGraph extends Graph{
	public void getShortestPath(String s){
		HashMap<String,Integer> dist= new HashMap<>();
		HashSet<String> included = new HashSet<>();
		dist.put(s,0);
		while(included.size()!=nodes.size()){
			checkNeighbors(getSmallest(dist,included),dist,included);
		}
		printShortestDist(dist);
		
		
	}
	public void printShortestDist(HashMap<String,Integer> dist){
		for(Map.Entry me : dist.entrySet()){
			System.out.println((String)me.getKey()+" : "+(int)me.getValue());
		}
	}
	public void checkNeighbors(String s, HashMap<String,Integer> dist,HashSet<String> included){
		if(nodes.containsKey(s)){
			if(!included.contains(s)){
				included.add(s);
				MyLinkedList.MyNode temp = nodes.get(s).head;
				while(temp!=null){
					if(!included.contains(temp.name)){
						if(!dist.containsKey(temp.name)){
							dist.put(temp.name,dist.get(s)+temp.cost);
						}
						else{
							if(dist.get(temp.name)>dist.get(s)+temp.cost){
								dist.put(temp.name,dist.get(s)+temp.cost);
							}
						}
					}
					temp=temp.next;
				}
			}
		}
	}
	public String getSmallest(HashMap<String,Integer> dist,HashSet <String> included ){
		int min=Integer.MAX_VALUE;
		String mins="";
		for(Map.Entry me : dist.entrySet()){
			String key=(String)me.getKey();
			int val=(int)me.getValue();
			if(!included.contains(key)&&val<min){
				min=val;
				mins=key;
				
			}
			
		}
		return mins;
	}
	
}
class Dijkstras{
	public static void main(String[] args){
		
		
		DijkstraGraph g = new DijkstraGraph();
		String[] nodearr={"a","b","c","d","e","f","g"};
		g.addNodes(nodearr);
		g.addEdge("a","b",5);
		g.addEdge("a","c",8);
		g.addEdge("b","c",2);
		g.addEdge("b","f",4);
		g.addEdge("c","d",3);
		g.addEdge("c","g",2);
		g.addEdge("d","e",1);
		g.addEdge("d","g",5);
		g.addEdge("e","f",6);
		g.getShortestPath("c");
		// g.dfs("a");
		// g.prim("a");
		
		
		
	}
}