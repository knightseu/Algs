package lc.solutions;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path.length()<=1) return path;
    	String rst="";
    	Stack<String> st = new Stack<String>();
        int index=0;
        //parsing string
        while (index < path.length()) {
        	int cur = index;
        	while (cur<path.length() && path.charAt(cur) != '/') {
        		cur++;
        	}
        	
        	// now path[cur] show be '/' 
        	if (cur==path.length()) {
        		cur--;
        	}
        	
        	//we skip'/' here
        	if (cur == index) {
        		index++;
        	}
        	else {
        		String s = path.substring(index, cur+1);
        		if (s.compareTo(".") == 0) {
        			index++;
        		}
        		else if (s.compareTo("..") == 0) {
        			index = cur;
        			if (!st.empty()) st.pop();
        		}
        		else {
        		    st.push(s);
        		    index = cur;
        		}
        		
        	}
        	
        }
        //reconstruct path
        while (!st.empty()) {
            rst+="/";
            rst+= st.pop();
        }
        
        return rst;
    }
}
