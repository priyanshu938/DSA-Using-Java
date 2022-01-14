public class PermutationOfaString {
    public static void main(String[] args) {
        String str = "abcd";
        permutation(str, "");
        System.out.println(permutationCount(str,""));
    }

    private static void permutation(String str, String req) {
        if (str.isEmpty()) {
            System.out.println(req);
            return;
        }
        char ch = str.charAt(0);
        for (int i = 0; i <= req.length(); i++) {
            String first = req.substring(0, i);
            String last = req.substring(i, req.length());
            permutation(str.substring(1), first + ch + last);
        }
    }


    private static int permutationCount(String str, String req) {
        if (str.isEmpty()) {
            
            return 1;
        }
        char ch = str.charAt(0);
        int c=0;
        for (int i = 0; i <= req.length(); i++) {
            String first = req.substring(0, i);
            String last = req.substring(i, req.length());
            c+=permutationCount(str.substring(1), first + ch + last);
        }
        return c;
    }

}
