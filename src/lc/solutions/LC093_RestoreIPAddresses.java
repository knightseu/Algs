package lc.solutions;

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations. 

For example: 
Given "25525511135", 
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class LC093_RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(s.length() <4 || s.length() > 12)
            return result;
        
        helper(result, list, s , 0);
        return result;
    }
    
    public void helper(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length())
                return;
            
            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        for(int i=start; i<s.length() && i<= start+3; i++){
            String tmp = s.substring(start, i+1);
            if(isvalid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isvalid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}