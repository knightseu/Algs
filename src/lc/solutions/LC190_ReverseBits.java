package lc.solutions;
/*
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
 */
public class LC190_ReverseBits {

	public int reverseBits(int n) {
        int result = 0;
        for(int i =0;i<32;i++){
            if( ((1<<i) & n) != 0 )
                result |= 1<< (31-i);
        }
        return result;
    }
	
	
	
	/*
	 * optimization
	 * 以4位为单位执行反转，将0x0至0xF的反转结果预存在一个长度为16的数组中，反转时直接查询即可
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
