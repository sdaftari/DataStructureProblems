//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 

package Easy;

public class ExcelSheetColNum {

	public static void main(String[] args) {
		ExcelSheetColNum obj = new ExcelSheetColNum();
		System.out.println(obj.titleToInt("AA"));
	}

	private int titleToInt(String str)
	{
		int res = 0;
		for (int i = 0; i < str.length(); i++)
			res = res * 26 + str.charAt(i) - 'A' + 1;
		
		return res;
	}
}
