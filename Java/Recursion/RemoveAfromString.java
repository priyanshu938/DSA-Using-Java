public class RemoveAfromString {
    public static void main(String[] args) {
        String str = "baaabcdac", req = "";
        System.out.println(removeA(str, req, 0));
    }

    private static String removeA(String str, String req, int i) {
        if (i == str.length())
            return req;
        if (str.charAt(i) == 'a')
            return removeA(str, req, i + 1);
        else
            return removeA(str, req + str.charAt(i), i + 1);

    }
}