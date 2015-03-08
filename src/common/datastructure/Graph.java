package common.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	 public class Vertex {
	        public char label;        // label (e.g. 'A')
	        // -------------------------------------------------------------
	        public Vertex(char lab)   // constructor
	        { label = lab; }
	    }  // end class Vertex
	 
	 private Vertex vList[];
     private final int MAX_VERTS = 30;
     private int adjMatrix[][];
     private int nVerts; // actual number of vertex in this graph
     private int time;
     
     private int color[]; //helper structure for dfs, 
     private int pi[]; //helper structure for dfs, record the predecesor
     private int d[]; //helper structure for dfs, record the order being visited
     private int f[]; //helper structure for dfs, record the order being visited
     public Graph() {
    	 vList = new Vertex[MAX_VERTS];
         // adjacency matrix
         adjMatrix = new int[MAX_VERTS][MAX_VERTS];
         nVerts = 0;
         for(int j=0; j<MAX_VERTS; j++)      // set adjacency
             for(int k=0; k<MAX_VERTS; k++)   // matrix to 0
                 adjMatrix[j][k] = 0;
     }
     
     public void addVertex(char lab)
     {
         vList[nVerts++] = new Vertex(lab);
     }
     
     public void addEdge(int start, int end)
     {
         adjMatrix[start][end] = 1;
     }
     
     public void dfs() {
    	 color = new int[this.nVerts];
    	 Arrays.fill(color, 0);
    	 pi = new int[this.nVerts];
    	 Arrays.fill(pi, -1);
    	 d = new int[this.nVerts];
    	 Arrays.fill(d, 0);
    	 f = new int[this.nVerts];
    	 Arrays.fill(f, 0);
    	 
    	 time = 0;
    	 for (int i=0; i<nVerts;i++) {
    		 if (0==color[i])
    			 dfsHelper(i);
    	 }
    	 
     }
     
     private void dfsHelper(int vIndex) {
    	 color[vIndex] = 1;
    	 time++;
    	 d[vIndex] = time;
    	 for (int v : adjV(vIndex)) {
    		 if (color[v] == 0) {
    			 pi[v] = vIndex;
    			 dfsHelper(v);
    		 }
    	 }
    	 color[vIndex] = 2;
    	 //f[vIndex] = ++time;
     }
     
     private ArrayList<Integer> adjV(int vIndex) {
    	 ArrayList<Integer> rst = new ArrayList<Integer>();
    	 for (int i=0;i<nVerts;i++) {
    		 if (adjMatrix[vIndex][i] == 1)
    			 rst.add(i);
    	 }
    	 return rst;
     }
     
     public void printDFS(){
    	 for (int i=0;i<nVerts;i++) {
    		 System.out.println(i+ " : "+pi[i] +",");
    	 }
     }
     public void dag() {
    	 
     }
}
