package String;

public class ExcelSheetColumnTitle {
    //No.1350. Excel Sheet Column Title;
    StringBuffer result = new StringBuffer();
    public String convertToTitle(int n) {
        return helper("", n);
    }
    private String helper(String s, int n) {
        if(n <= 0) {
            return s;
        }
        helper(s, n/26);

        int temp = n % 26;
        char high = (char)('A' + temp - 1);
        result.append(high);
        return result.toString();
    }
}
