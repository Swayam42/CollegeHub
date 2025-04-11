package BST;

import java.util.*;
class Vertex{
	char c;
	boolean wasVisited;
	public Vertex(char c){
		this.c=c;
		wasVisited=false;
	}
	
}
public class Graph {
	int n=0;
	int maxVert=20;
	Vertex vertexList[]=new Vertex[maxVert];
	int adjMat[][]=new int [maxVert][maxVert];
	
	public void addVertex(char val) {
		vertexList[n]=new Vertex(val);
		n++;
	}
	
	public void addEdge(int start,int end) {
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void display(){
		System.out.print("  ");
        for (int j=0;j<n;j++){
            System.out.print(vertexList[j].c + " ");
        }
        System.out.println();
        for (int row=0;row<n;row++){
            System.out.print(vertexList[row].c + " ");
            for (int col=0;col<n;col++){
                System.out.print(adjMat[row][col]+ " ");
            }
            System.out.println();
        }
	}
	
	
	public void DFS() {
	    Stack<Integer> stack = new Stack<>();
	    vertexList[0].wasVisited =true;
	    System.out.print(vertexList[0].c+" ");
	    stack.push(0);

	    while (!stack.isEmpty()){
	        int v=stack.peek();
	        
	        int adjVertex = getAdjacentVertex(v);

	        if (adjVertex==-1){
	            stack.pop();
	        } else {
	            vertexList[adjVertex].wasVisited=true;
	            System.out.print(vertexList[adjVertex].c+" ");
	            stack.push(adjVertex);
	        }
	    }
	    //ReInitialising the 
	    for (int i=0;i<n;i++){
	        vertexList[i].wasVisited = false;
	    }
	}
	
	//helper method for DFS
	public int getAdjacentVertex(int v) {
		for(int i=0;i<n;i++) {
			if(adjMat[v][i]==1&&vertexList[i].wasVisited==false)
				return i;
		}
		return -1;
	}
	
	
	
	
	public static void main(String[] args) {
		Graph g=new Graph();
		char ver[]= {'A','B','C','D','E'};
		for(char i:ver) {
			g.addVertex(i);
		}
		 	g.addEdge(0,1); // A-B
	        g.addEdge(0,2);
	        g.addEdge(0,3); 
	        g.addEdge(1,2);
	        g.addEdge(2,4);
	        System.out.println("Adjacency Matrix Representation: ");
	        g.display();
	        System.out.print("\nDFS traversal :");
	        g.DFS();

	}

}
