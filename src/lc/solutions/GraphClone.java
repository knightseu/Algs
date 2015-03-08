package lc.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import common.datastructure.UndirectedGraphNode;

public class GraphClone {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
        UndirectedGraphNode rst = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        que.add(node);
        map.put(node, rst);
        while (!que.isEmpty()) {
        	UndirectedGraphNode cur = que.pop();
        	UndirectedGraphNode curCopy = map.get(cur);
        	ArrayList<UndirectedGraphNode> curNBs = (ArrayList<UndirectedGraphNode>)cur.neighbors;
        	
        	for (UndirectedGraphNode aNB: curNBs) {
        		if (!map.containsKey(aNB)) {
        			//not in the map yet, this node has not been copied
        			UndirectedGraphNode aNBCopy = new UndirectedGraphNode(aNB.label);
        			map.put(aNB, aNBCopy);
        			curCopy.neighbors.add(aNBCopy);
        			que.add(aNB);
        		}
        		else {
        			//already in the map, do not need a new copy
        			curCopy.neighbors.add(map.get(aNB));
        		}
        			
        	}
        }
        return rst;
    }
}
