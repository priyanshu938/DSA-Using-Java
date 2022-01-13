

import java.util.*;

public class ReverseANumber {
    public static int rev=0;
    public static void reverse(int n)
    {
        if(n==0)
        {
            return ;
        }
        rev=rev*10+n%10;
        reverse(n/10);
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        reverse(n);
        System.out.println("Reverse of "+n+" is : "+rev);
        scanner.close();
    }
}
