package lc.solutions;

import java.util.Arrays;

/*
 * Find largest index i such that array[i − 1] < array[i].

Find largest index j such that j ≥ i and array[j] > array[i − 1].

Swap array[j] and array[i − 1].

Reverse the suffix starting at array[i].
 */
public class NextPermutation {
    public static void nextPermutation(int[] num) {
if (null == num || num.length<=1) return;
    	
        int i=num.length - 1, j=num.length - 1, temp;
        //1.Find largest index i such that array[i - 1] < array[i].
        while (i > 0 && num[i - 1] >= num[i])
            i--;
        
        
        //2.Find largest index j such that j >= i and array[j] > array[i \u2212 1]
        if (i>0) {
           while (num[j] <= num[i - 1] && j>0)
                j--;
        }
        
        //3.Swap array[j] and array[i - 1]
        if (i>0 && i-1!=j) {
            temp = num[i-1];
            num[i-1]=num[j];
            num[j]=temp;
        }
        
        //4.Reverse the suffix starting at array[i]
        j = num.length - 1;
        while (i < j) {
            temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
}
