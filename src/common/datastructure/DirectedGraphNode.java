package common.datastructure;

/**
 * Created by xuan on 1/26/17.
 */
import java.util.ArrayList;

public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
