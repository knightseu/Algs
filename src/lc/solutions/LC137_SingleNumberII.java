package lc.solutions;

public class LC137_SingleNumberII {
	/*
	 * 
    ones   代表第ith 位只出现一次的掩码变量
    twos  代表第ith 位只出现两次次的掩码变量
    threes  代表第ith 位只出现三次的掩码变量

	 */
	int singleNumber(int A[], int n) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < n; i++) {
		    twos |= ones & A[i];
		    ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
		    //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
		    threes = ones & twos;
		    ones &= ~threes;
		    twos &= ~threes;
		}
		
		return ones;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
