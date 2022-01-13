import java.util.*;
public class NthPrime
{
    public static boolean prime(int n)
    {
        for(int i = 2; i < n; i++)
        {
            if(n%i==0)
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n :");
        int n=scanner.nextInt();
        scanner.close();
        int i=1,c=0;
        while(c!=n)
        {
            if(prime(++i))
            {
                c++;
            }
            
        }
        System.out.println(n+"th prime number is : "+i);

    }
}