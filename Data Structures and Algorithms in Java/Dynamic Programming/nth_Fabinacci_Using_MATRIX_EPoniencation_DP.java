import java.util.Scanner;

public class nth_Fabinacci_Using_MATRIX_EPoniencation_DP {
        static long mod = 1000000007;
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter");
            int n= sc.nextInt();
            System.out.println("Nth Fabinacci is: ");
int a=fibonacciNumber(n);
            System.out.println("Nth fabbinacci is:"+a);
        }
        public static int fibonacciNumber(int n) {
            // Write your code here.
            long arr[][] = new long [2][2];
            arr[0][0] = 1;
            arr[1][1] = 0;
            arr[0][1] = 1;
            arr[1][0] = 1;
            long[][] res = new long[2][2];
            res = pow(arr, n - 1);
            int ans = (int)res[0][0];
            return ans;
        }
        static long[][] pow(long[][] a, int b) {
            long arr[][] = new long[2][2];
            arr[0][0] = 1;
            arr[1][1] = 1;
            if (b == 0)
                return arr;
            long[][] res = new long[2][2];
            res = pow(a, b / 2);
            if (b % 2 != 0) {
                res = multiply(res, res);
                res = multiply(res, a);
            } else {
                res = multiply(res, res);
            }
            return res;
        }
        static long[][] multiply(long[][] a, long[][] b) {
            int row, col, i;
            long sum = 0;
            long c[][] = new long[2][2];
            c[0][0] = 0;
            c[1][1] = 0;
            c[1][0] = 0;
            c[0][1] = 0;
            for (row = 0; row < 2; row++) {
                for (col = 0; col < 2; col++) {
                    sum = 0;
                    for (i = 0; i < 2; i++) {
                        sum = ( ( a[row][i]%mod* b[i][col]%mod) + sum%mod) %mod;
                    }
                    c[row][col] = sum;
                }
            }
            return c;
        }
    }
