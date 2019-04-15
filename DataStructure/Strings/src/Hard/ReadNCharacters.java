// Read N Chars I
// Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.
//File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
//char[] buf = new char[4]; // Create buffer with enough space to store characters
//read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
//read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
//read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file

//Read N Chars II
// Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.
//File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
//char[] buf = new char[4]; // Create buffer with enough space to store characters
//read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
//read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
//read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file

package Hard;

public class ReadNCharacters {

	private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    
//    public int readI(char[] buf, int n) {
//        boolean eof = false;      // end of file flag
//        int total = 0;            // total bytes have read
//        char[] tmp = new char[4];
//        
//        while (!eof && total < n)
//        {
//            int count = read4(tmp);
//            eof = count < 4;
//            count = Math.min(count, n - total);
//        
//            for (int i = 0; i < count; i++) 
//                buf[total++] = tmp[i];
//        }
//          
//            return total;
//    }
    
//    public int readII(char[] buf, int n) {
//        int ptr = 0;
//        while (ptr < n) {
//            if (buffPtr == 0) {
//                buffCnt = read4(buff);
//            }
//            if (buffCnt == 0) break;
//            while (ptr < n && buffPtr < buffCnt) {
//                buf[ptr++] = buff[buffPtr++];
//            }
//            if (buffPtr >= buffCnt) buffPtr = 0;
//        }
//        return ptr;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
