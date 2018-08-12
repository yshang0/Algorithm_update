package String;

public class CountAndSay {
    //No.420: Count And Say;
    public static String countAndSay(int n) {
        String s = "1";
        return helper(s, n);
    }
    private static String helper(String s, int n) {
        if(n <= 1) {
            return s;
        }
        StringBuffer res = new StringBuffer();
        String[] a = s.split("");
        String temp = a[0];
        int l = a.length;
        int count = 1;
        for(int i = 1; i <= l - 1; i++) {
            if(temp.equals(a[i])) {
                count++;
            } else {
                res.append(String.valueOf(count));
                res.append(temp);
                temp = a[i];
                count = 1;
            }
        }
        res.append(String.valueOf(count));
        res.append(temp);
        n--;
        String result = res.toString();
        return helper(result, n);
    }
}
