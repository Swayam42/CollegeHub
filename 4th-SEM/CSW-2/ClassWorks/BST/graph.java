package BST;


class Vertex{
	char c;
	boolean wasVisited;
	public Vertex(char c){
		this.c=c;
		wasVisited=false;
	}
	
}
public class Graph {
	int i=0;
	int maxVert=10;
	Vertex vertexList[]=new Vertex[maxVert];
	int adjMat[][]=new int [maxVert][maxVert];
	
	public void addVertex(char val) {
		vertexList[i]=new Vertex(val);
		i++;
	}
	
	public void addEdge(int start,int end) {
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void display() {
		System.out.print("  ");
        for (int j = 0; j < i; j++) {
            System.out.print(vertexList[j].c + " ");
        }
        System.out.println();
        for (int row = 0; row < i; row++) {
            System.out.print(vertexList[row].c + " ");
            for (int col = 0; col < i; col++) {
                System.out.print(adjMat[row][col] + " ");
            }
            System.out.println();
        }
	}
	
	
	public static void main(String[] args) {
		Graph g=new Graph();
		char ver[]= {'A','B','C','D','E','F'};
		for(char i:ver) {
			g.addVertex(i);
		}
		 	    g.addEdge(0, 1); // A-B
	        g.addEdge(1, 2); // B-C
	        g.addEdge(2, 3); // C-D
	        g.addEdge(3, 4); // D-E
	        g.addEdge(4, 0); // E-A
	        g.display();

	}

}
