

import java.util.*;

public class CountZeroes {
public static int countZeroes(int n,int c)
{
    if(n<=0) return c;
    int x=n%10;
    if(x==0) return countZeroes(n/10,c+1);
    else return countZeroes(n/10,c);
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        System.out.println("Number of zeroes in "+n+" is : "+countZeroes(n,0));
        scanner.close();
}    
}
