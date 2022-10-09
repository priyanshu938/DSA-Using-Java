public class LetterCombinationsPhoneNo {
    public static void main(String[] args) {
        letterCombinations("", "12");
    }

    private static void letterCombinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3 && i != 26; i++) // skipping for 26th character which is after z
        {
            char ch = (char) ('a' + i);
            letterCombinations(p + ch, up.substring(1));
        }
    }
}