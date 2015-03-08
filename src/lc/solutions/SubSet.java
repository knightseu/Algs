package lc.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        rst.add(tmp);
        Arrays.sort(S);
        dfs(rst, tmp, S, 0);
        return rst;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>  rst, ArrayList<Integer> tmp, int[] S, int pos) {
    	for (int i=pos; i<=S.length-1; i++) {
    		tmp.add(S[i]);
    		rst.add(new ArrayList<Integer>(tmp));
    		dfs(rst, tmp, S, i+1);
    		tmp.remove(tmp.size()-1);
    		//
    		//while (i<S.length-1 && S[i] == S[i+1]) ++i;
    	}
    }
}
