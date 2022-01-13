public class RemoveAfromString {
    public static void main(String[] args) {
        String str = "baaabcdac", req = "";
        System.out.println(removeA(str, req));
    }

    private static String removeA(String str, String req) {
        if (str.isEmpty())
            return req;
        if (str.charAt(0) == 'a')
            return removeA(str.substring(1), req);
        else
            return removeA(str.substring(1), req + str.charAt(0));

    }
}