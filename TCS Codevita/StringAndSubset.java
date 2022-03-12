import java.util.*;

public class StringAndSubset {
    public static String[] all;
    public static List<List<String>> ans = new LinkedList<List<String>>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        String inp = scanner.next();
        all = inp.split(",");
        subsets(0, new LinkedList<String>());
        Collections.sort(ans, (o1, o2) -> ((LinkedList<String>) o1).size() - ((LinkedList<String>) o2).size());
        List<String> res = ans.get(r - 1);
        String z = "";
        for (String x : res) {
            z = z + x + ",";
        }
        System.out.println(z.substring(0, z.length() - 1));
    }

    private static void subsets(int i, LinkedList<String> ds) {
        if (i == all.length) {
            ans.add(new LinkedList<String>(ds));
            return;
        }
        ds.add(all[i]);
        subsets(i + 1, ds);
        ds.remove(ds.size() - 1);
        subsets(i + 1, ds);
    }
}
