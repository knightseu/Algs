package lc.solutions;

public class ZigzagConversion {
    public String convert(String s, int nRows) {
        if (nRows<=1) return s;
        int len = s.length();
        String result= "";
        if (len == 0) return result;	
        int zigzag =  2*nRows -2;
        
        int m = len/zigzag, n=len%zigzag;
        for (int i=0; i<nRows; i++) 
            for (int j=0; j<len; j+=zigzag) {
            	
        }
        return result;
    }
}
