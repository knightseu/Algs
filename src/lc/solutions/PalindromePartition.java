package lc.solutions;

// import java.awt.List;
import java.util.ArrayList;

public class PalindromePartition {
/*
 * Three variations for this problem
1. The result is a int, DP is the solution
2. A specific result, mincut. DP+ backtrack
3. All resultS. dfs

 */
	
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
    	
    	
    	return result;
    }
    
    void dfs(String s, int start, ArrayList<String> al){
        if(start==s.length()){
            //all .add(new ArrayList<String>(al));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            if(isPalin(s,start,i-1)){
                al.add(s.substring(start,i));
                dfs(s,i,al);
                al.remove(al.size()-1);
            }
        }    
    }
    
    boolean isPalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }    
        return true;
    }
}
