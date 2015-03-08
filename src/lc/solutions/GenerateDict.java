package lc.solutions;

import common.datastructure.Graph;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32859257.html
 * wrt
    wrf
    er
    ett
    rftt
    w,e,r,t,f
 */
public class GenerateDict {
    public static void getDict() {
    	Graph theG = new Graph();
    	theG.addVertex('w');//0
    	theG.addVertex('r');//1
    	theG.addVertex('t');//2
    	theG.addVertex('f');//3
    	theG.addVertex('e');//4
    	
    	//wrt
    	theG.addEdge(0,1);
    	theG.addEdge(1,2);
    	//wrf
    	theG.addEdge(1, 3);
    	//er
    	theG.addEdge(4, 1);
    	//ett
    	theG.addEdge(4, 2);
    	theG.addEdge(2, 2);
    	//rftt
    	theG.addEdge(3, 2);
    	theG.dfs();
    	theG.printDFS();
    }
}
