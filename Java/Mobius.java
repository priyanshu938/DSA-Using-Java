import java.util.*;

class Mobius {
    int N;

    boolean prime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    int mobius(int N) {
        if (N == 1)
            return 1;
        else if (prime(N))
            return -1;
        else if (Math.sqrt(N) - Math.floor(Math.sqrt(N)) == 0)
            return 0;
        else
            return numberOfPrimeFactors(N);

    }

    int numberOfPrimeFactors(int N) {
        int c, count_no_of_factors = 0;

        for (int i = 2; i <= N; i++) {
            c = 0;
            if (prime(i) && N % i == 0) {
                while (N % i == 0) {
                    N = N / i;
                    c++;
                    if (c > 1)
                        return 0;

                }
                count_no_of_factors++;
            }
        }
        return (int) Math.pow(-1, count_no_of_factors);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mobius obj = new Mobius();
        System.out.println("Enter N : ");
        obj.N = sc.nextInt();
        System.out.println("Mobius value of " + obj.N + " is : " + obj.mobius(obj.N));
        sc.close();
    }
}