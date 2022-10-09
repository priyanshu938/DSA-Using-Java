public class DiceSum {
    public static void main(String[] args) {
        diceSum("", 6);
    }

    private static void diceSum(String sumS, int make) {
        if (make == 0) {
            System.out.println(sumS);
            return;
        }
        for (int i = 1; i <= 6 && make >= i; i++) {
            diceSum(sumS + i, make - i);
        }
    }
}