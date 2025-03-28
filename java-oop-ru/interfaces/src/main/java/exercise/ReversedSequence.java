package exercise;


// BEGIN extends
public class ReversedSequence implements CharSequence {

    private String reverseText;

    public ReversedSequence(String text) {
        this.reverseText = reverse(text);
    }

    private static String reverse(String text) {
        StringBuilder result = new StringBuilder(text);
        result.reverse();
        return result.toString();
    }

    //@Override
    public String toString() {
        return reverseText;
    }

    public char charAt(int n) {
        if (n < 0 || n > reverseText.length()) {
            return ' ';
        }
        char[] arrChar = reverseText.toCharArray();
        return arrChar[n];
    }

    public int length() {
        return reverseText.length();
    }

    public CharSequence subSequence(int start, int end) {
        if (start < 0 || start > reverseText.length() - 2) {
            return "";
        }
        if (end < start || end > reverseText.length() - 1) {
            return "";
        }

        char[] result = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[end - i] = reverseText.charAt(i);
        }

        CharSequence text = new ReversedSequence(String.valueOf(result));
        return text;
    }

}
// END
