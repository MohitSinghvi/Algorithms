class Edge{
	int src;
	int dest;
	int weight;
	public Edge(int s, int d, int w){
		src=s;
		dest=d;
		weight=w;
	}
}
class Graph{
	int v,e;
	Edge[] edges;
	int[] parent;
	int last=0;
	public Graph(int v, int e){
		this.v=v;
		this.e=e;
		edges=new Edge[e]; 
		parent=new int[v];
		for(int i =0;i<v;i++){
			parent[i]=-1;
		}
		
	}
	public void addEdge(int src, int dest, int weight){
		Edge temp = new Edge(src,dest,weight);
		if(last<e){
			edges[last]=temp;
			last+=1;
		}
	}
	public void print(){
		System.out.println("S: D: W: ");
		for(int i=0;i<last;i++){
			System.out.println(edges[i].src+ "  "+edges[i].dest+"  "+edges[i].weight+" ");
		}
	}
	public boolean isCycle(int src, int dest){
		int s=src;
		int d=dest;
		int sc=0;
		int dc=0;
		while(parent[s]>-1){
			s=parent[s];
			sc+=1;
		}
		while(parent[d]>-1){
			d=parent[d];
			dc+=1;
		}
		if(s==d){
			return true;
		}
		else{
			if(sc>=dc){
				parent[src]-=1;
				
				d=dest;
				while(parent[d]>-1){
					int t=d;
					d=parent[d];
					parent[t]=src;
				}
			}
			else{
				parent[dest]-=1;
				
				s=src;
				while(parent[s]>-1){
					int t=s;
					s=parent[s];
					parent[s]=dest;
				}
			}
			return false;
		}
	}
	
}
class Kruskals{
	public static void main(String[] args){
		Graph g1 = new Graph(7,9);
		g1.addEdge(1,6,10);
		g1.addEdge(3,4,12);
		g1.addEdge(2,7,14);
		g1.addEdge(2,3,16);
		g1.addEdge(4,7,18);
		g1.addEdge(4,5,22);
		g1.addEdge(5,6,25);
		g1.addEdge(1,2,28);
		
		g1.print();
	
		Graph g2 = new Graph(7,9);
		for(int i=0;i<g1.edges.length;i++){
			if(!g1.isCycle(g1.edges[i].src,g1.edges[i].dest)){
				g2.addEdge(g1.edges[i].src,g1.edges[i].dest,g1.edges[i].weight);
			}
		}
		g2.print();
		
		
	}
	
}