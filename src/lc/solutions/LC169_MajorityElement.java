package lc.solutions;
/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

 */
public class LC169_MajorityElement {
/*
 * hardest part is to find time O(n) and space O(1)
 */
	
	/* Program for finding out majority element in an array */
	//# include<stdio.h>
	//# define bool int
	  
	//int findCandidate(int *, int);
	//bool isMajority(int *, int, int);
	  
	/* Function to print Majority Element */
	
	/*void printMajority(int a[], int size)
	{
	   Find the candidate for Majority
	  int cand = findCandidate(a, size);
	  
	   Print the candidate if it is Majority
	  if(isMajority(a, size, cand))
	    printf(" %d ", cand);
	  else
	    printf("NO Majority Element");
	}*/
	
	/* Function to find the candidate for Majority */
	int findCandidate(int a[], int size)
	{
	    int maj_index = 0, count = 1;
	    int i;
	    for(i = 1; i < size; i++)
	    {
	        if(a[maj_index] == a[i])
	            count++;
	        else
	            count--;
	        if(count == 0)
	        {
	            maj_index = i;
	            count = 1;
	        }
	    }
	    return a[maj_index];
	}
	  
	/* Function to check if the candidate occurs more than n/2 times */
	boolean isMajority(int a[], int size, int cand)
	{
	    int i, count = 0;
	    for (i = 0; i < size; i++)
	      if(a[i] == cand)
	         count++;
	    if (count > size/2)
	       return true;
	    else
	       return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
