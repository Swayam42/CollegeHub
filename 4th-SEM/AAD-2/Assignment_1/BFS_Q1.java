package Assignment_1;
/*write a java program to perform the breadth first search (BFS) on a given graph*/
import java.util.*;

class Queue{
	
	ArrayList<Integer> list=new ArrayList<>();
	
	boolean isEmpty() {
		return list.isEmpty();
	}
	
	void enqueue(int n) {
		list.add(n);
	}
	
	int dequeue() {
		if(!isEmpty()) {
			list.remove(0);
		}
		return list.remove(0);
	}
	
}
public class BFS_Q1 {
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int  v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	static void bfs(ArrayList<ArrayList<Integer>> adj,int start,int v) {
		boolean visited[]=new boolean[v];
		Queue q=new Queue();
		
		q.enqueue(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int vertex=q.dequeue();
			System.out.print(vertex+" ");
			
			for (int neighbor : adj.get(vertex)) {
	            if (!visited[neighbor]) {
	                visited[neighbor] = true;
	                q.enqueue(neighbor); // Enqueue unvisited neighbors
	            }
	        }
		}
	}
	public static void main(String[] args) {
		//input no. of vertices :
		int v=5;
		//representing of graph using adjacency list 
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
		
		//for every vertices a list is created to store the neighboring vertices 
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1); 
        addEdge(adj, 0, 4); 
        addEdge(adj, 1, 2); 
        addEdge(adj, 1, 3); 
        addEdge(adj, 1, 4); 
        addEdge(adj, 2, 3); 
        addEdge(adj, 3, 4);
        
        bfs(adj,0,v);
	}

}
