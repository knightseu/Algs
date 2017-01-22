package lc.solutions;
/*
 * Write a function that takes an unsigned integer and returns the number of �1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer �11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class LC191_NumberOfOneBits {
/*
 *  

This is known as the 'Hamming Weight', 'popcount' or 'sideways addition'.

The 'best' algorithm really depends on which CPU you are on and what your usage pattern is.

Some CPUs have a single built-in instruction to do it and others have parallel instructions which act on bit vectors. The parallel instructions will almost certainly be fastest, however, the single-instruction algorithms are 'usually microcoded loops that test a bit per cycle; a log-time algorithm coded in C is often faster'.

A pre-populated table lookup method can be very fast if your CPU has a large cache and/or you are doing lots of these instructions in a tight loop. However it can suffer because of the expense of a 'cache miss', where the CPU has to fetch some of the table from main memory.

If you know that your bytes will be mostly 0's or mostly 1's then there are very efficient algorithms for these scenarios.

I believe a very good general purpose algorithm is the following, known as 'parallel' or 'variable-precision SWAR algorithm'. I have expressed this in a C-like pseudo language, you may need to adjust it to work for a particular language (e.g. using uint32_t for C++ and >>> in Java):

int NumberOfSetBits(int i)
{
     i = i - ((i >> 1) & 0x55555555);
     i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
     return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
}

This is because it has the best worst-case behaviour of any of the algorithms discussed, so will efficiently deal with any usage pattern or values you throw at it.

References:

http://graphics.stanford.edu/~seander/bithacks.html

http://en.wikipedia.org/wiki/Hamming_weight

http://gurmeetsingh.wordpress.com/2008/08/05/fast-bit-counting-routines/

http://aggregate.ee.engr.uky.edu/MAGIC/#Population%20Count%20(Ones%20Count)

 */
	
	/*
	int hammingWeight(uint32_t n)
	{
	    int res = 0;
	    while(n)
	    {
	        n &= n - 1;
	        ++ res;
	    }
	    return res;
	}
	*/

	/*
	 * The most straightforward intuition here is that we can use bit mask to extract bit of n 1 by 1, by which I have the following code:

def hammingWeight(self, n):
        rst = 0
        mask = 1
        for i in range(32):
            if n & mask:
                rst += 1
            mask = mask << 1
        return rst

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
