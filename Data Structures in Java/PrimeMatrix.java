class PrimeMatrix {

    int A[][] = new int[4][4];

    int isprime(int k) {
        for (int i = 2; i < k; i++)
            if (k % i == 0)
                return 0;
        return 1;
    }

    void calc() {
        int x = 3, i, j;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4;)

            {
                int p = isprime(x);
                if (p == 1) {
                    A[i][j] = x;
                    j++;
                }
                x++;
            }

        }
    }

    void display() {
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        PrimeMatrix obj = new PrimeMatrix();
        obj.calc();
        obj.display();
    }
}