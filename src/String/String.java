package String;

public class String {
    //No: 243; Length of Last Word
    //Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    //return the length of last word in the string.

    public int lengthOfLastWord(String s) {
        // write your code here
        String[] substring = s.split(" ");
        return substring[substring.length - 1].length();
    }
}
