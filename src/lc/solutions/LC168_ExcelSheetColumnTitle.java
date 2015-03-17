package lc.solutions;
/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class LC168_ExcelSheetColumnTitle {
	/*
	 * [分析]
10进制转26进制

[注意事项]
1）注意while循环里面的n–，因为26进制里最小对应的是10进制里面的1，不是0
	 */
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
