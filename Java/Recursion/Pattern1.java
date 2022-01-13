

public class Pattern1 {

    public static void pattern1(int r, int c) {
        if (r == 0)
            return;
        if (r > c) {
            System.out.print("* ");
            pattern1(r, c + 1);
        } else {
            System.out.println();
            pattern1(r - 1, 0);
        }

    }
    public static void pattern2(int r, int c) {
        if (r == 0)
            return;
        if (r>c) {
            pattern2(r, c + 1);
            System.out.print("* ");
        } 
        else {
            pattern2(r - 1, 0);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // pattern1(5,0);
        pattern2(5,0);
        
    }

}
