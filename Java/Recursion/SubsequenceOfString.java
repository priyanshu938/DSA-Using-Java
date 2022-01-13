public class SubsequenceOfString {
    public static void main(String[] args) {
        String str = "abc";
        subsequenceOfString(str, "");
        subsequenceOfStringWithAscii(str,"");
    }

    private static void subsequenceOfString(String str, String req) {
        if (str.isEmpty()) {
            System.out.println(req);
            return;
        }
        subsequenceOfString(str.substring(1),req+str.substring(0, 1));
        subsequenceOfString(str.substring(1), req);

    }
    private static void subsequenceOfStringWithAscii(String str, String req) {
        if (str.isEmpty()) {
            System.out.println(req);
            return;
        }
        subsequenceOfStringWithAscii(str.substring(1),req+str.substring(0, 1));
        subsequenceOfStringWithAscii(str.substring(1),req+(int)str.charAt(0));
        subsequenceOfStringWithAscii(str.substring(1), req);

    }

}
