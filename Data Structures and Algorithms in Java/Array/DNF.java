import java.util.Scanner;

public class DNF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size= sc.nextInt();
        int ar[]=new int[size];
        int i,l=0,r=size,temp,mid=0;
        for(i=0;i<size;i++)
        {
            ar[i]=sc.nextInt();
        }
        while(mid<=r)
        {
            if(ar[mid]==0)
            {
              temp=  ar[l];
                ar[l]=ar[mid];
              ar[mid]=temp;
              mid++;
                l++;
            }
            if(ar[mid]==1)
            {
                mid++;
            }
            else
            {
                r--;
            }
        }
        for(Integer ele: ar)
        {
            System.out.println(ele);
        }

    }
}
