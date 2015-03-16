package lc.solutions;
/*
 *  The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Solution: 

    buffer – An array of size 4 is used to store data returned by read4 temporarily. If the characters were read into the buffer and were not used partially, they will be used in the next call.

    offset – Use to keep track of the offset index where the data begins in the next read call. The buffer could be read partially (due to constraints of reading up to n bytes) and therefore leaving some data behind.

    bufsize – The real buffer size that stores the actual data. If bufsize > 0, that means there is partial data left in buffer from the last read call and we should consume it before calling read4 again. On the other hand, if bufsize == 0, it means there is no data left in buffer. 
 */
public class LC158_ReadNCharactersGivenRead4II {
	   private char[] buffer = new char[4];
	   int offset = 0;
	   int bufsize = 0;
	   
		private int read4(char[] b4) {
			return 0;
		}

	   public int read(char[] buf, int n) {
	       int Readbytes = 0;
	       boolean lessthan4 = false;
	       int bytes = 0;
	       
	       while(!lessthan4 && Readbytes<n){
	           if(bufsize == 0){
	               bufsize = read4(buffer);
	               lessthan4 = bufsize<4;
	           }
	           bytes = Math.min((n-Readbytes),bufsize);
	           for(int i=0; i<bytes; i++){
	               buf[Readbytes+i] = buffer[offset+i];
	           }
	           
	           offset = (offset+bytes)%4;
	           bufsize -= bytes;
	           Readbytes += bytes;
	       }
	       return Readbytes;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
