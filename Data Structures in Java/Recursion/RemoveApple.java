public class RemoveApple {

    public static void main(String[] args) {
        String str = "bcdappecd";
        System.out.println(removeAppleApp(str));
    }

    private static String removeAppleApp(String str) {
        if (str.isEmpty())
            return "";
        char ch = str.charAt(0);
        if (str.startsWith("apple"))
            return removeAppleApp(str.substring(5));
        else if (str.startsWith("app"))
            return removeAppleApp(str.substring(3));
        else
            return ch + removeAppleApp(str.substring(1));

    }
}
