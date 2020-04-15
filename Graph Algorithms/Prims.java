import java.util.*;
class MyLinkedList{
	MyNode head;
	MyNode last;
	class MyNode{
		String name;
		int cost;
		MyNode next;
		public MyNode(String name, int cost){
			this.name=name;
			this.cost=cost;
			this.next=null;
		}
		
	}
	public void append(String node_name, int cost){
		MyNode new_node = new MyNode(node_name,cost); 
		if(head==null){
			head = new_node;
			last=new_node;
		}
		else{
			last.next=new_node;
			last=new_node;
			
		}
	}
	
	
}
class Graph{
	HashMap<String, MyLinkedList> nodes = new HashMap<>();
	HashSet<String> visited = new HashSet<>();
	
	public void addNodes(String[] node_names){
		for(int i=0;i<node_names.length;i++){
			nodes.put(node_names[i],null);
			
		}
	}
	public void addEdge(String s1, String s2, int cost){
		if(nodes.containsKey(s1)){
			MyLinkedList l1 = nodes.get(s1);
			if(l1==null){
				l1=new MyLinkedList();
			}
			l1.append(s2, cost);
			nodes.put(s1,l1);
		}
		if(nodes.containsKey(s2)){
			MyLinkedList l2 =  nodes.get(s2);
			if(l2==null){
				l2=new MyLinkedList();
			}
			l2.append(s1,cost);
			nodes.put(s2,l2);
		
		}
	}
	public void dfs(String s){
		
		
		visited.add(s);
		System.out.println(s);
		if(nodes.containsKey(s)){
			MyLinkedList temp1;
			temp1=nodes.get(s);
			
			MyLinkedList.MyNode temp=temp1.head;
			while(temp!=null){
				if(!visited.contains(temp.name)){
					dfs(temp.name);
				}
				temp=temp.next;
			}
		}
	}
	public void updateCosts(String s,HashSet<String> included, HashMap<String,Integer> costs, HashMap<String,String>parents){
		// System.out.println(s+"HIHIHI");
		MyLinkedList.MyNode temp=nodes.get(s).head;
		if(!included.contains(s)){
			included.add(s);	
			while(temp!=null){
				if(!included.contains(temp.name) ){
					
					if(costs.get(temp.name)!=null){
						if(temp.cost<costs.get(temp.name)){
							parents.put(temp.name, s);
							costs.put(temp.name,temp.cost);
						}
						
					}
					else{
						parents.put(temp.name, s);
						costs.put(temp.name,temp.cost);
					}
					
				}
				
				temp=temp.next;
			}
		}
	}
	public String getMin(HashSet<String> included, HashMap<String,Integer> costs){
		
		int mini=Integer.MAX_VALUE;
		String minis="";
		for(Map.Entry me : 	costs.entrySet()){
			String key= (String)me.getKey();
			int val = (int)me.getValue();
			
			// System.out.println(key+" : "+val);
			if(val<mini && !included.contains(key)){
				mini=val;
				minis=key;
				
			}
		}
		return minis;
		
	}

	public void printMST(HashMap<String,String> parents, HashMap<String,Integer> costs){
		nodes.forEach((k,v) -> System.out.println(parents.get(k)+" -> "+k+" : "+ costs.get(k)));
	}
	public void prim(String s){
		HashSet<String> included=new HashSet<>();
		HashMap<String,Integer> costs = new HashMap<>();
		HashMap<String,String>parents= new HashMap<>();
		updateCosts(s,included,costs,parents);
		
		
		while(included.size()!=nodes.size()){
			updateCosts(getMin(included,costs),included,costs,parents);
			
		}
		printMST(parents,costs);

	}
	
	
	
}

class Prims{
	public static void main(String[] args){
		Graph g = new Graph();
		String[] nodearr={"a","b","c","d","e","f","g"};
		g.addNodes(nodearr);
		g.addEdge("a","b",5);
		g.addEdge("a","c",6);
		g.addEdge("b","c",7);
		g.addEdge("c","d",9);
		
		g.addEdge("a","e",3);
		g.addEdge("d","e",2);
		g.addEdge("e","f",4);
		g.addEdge("a","f",8);
		g.addEdge("d","g",5);
		g.dfs("g");
		g.prim("a");
		
		
	}
	
}