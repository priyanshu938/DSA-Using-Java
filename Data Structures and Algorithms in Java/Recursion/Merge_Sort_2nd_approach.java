public class Merge_Sort_2nd_approach {


    public static void main(String args[])
    {
int ar[]={3,7,2};
mergeShort(ar);
    for (Integer ele:ar) {
        System.out.println(ele);
    }
}
public static void mergeShort(int[] input)
{
    mergeShort(input,0,input.length-1);
}
public static void mergeShort(int input[],int SI,int EI)
{
    if(SI==EI)
        return;
    int mid=(SI+EI)/2;
    mergeShort(input,SI,mid);
    mergeShort(input,mid+1,EI);
    mergedArray(input,SI,EI);
}
public static int[] mergedArray(int[] arr,int SI,int EI)
{int ar[]=new int[EI-SI+1];
    int i=SI;
    int mid=(SI+EI)/2;
    int j=mid+1;
    int k=0;
    while(i<=mid&&j<=EI)
    {
        if(arr[i]<arr[j])
        {
            ar[k]=arr[i];
            i++;
            k++;
        }
        else
        {
            ar[k]=arr[j];
            j++;
            k++;
        }
    }
    while(i<=mid)
    {
        ar[k]=arr[i];
        i++;
        k++;
    }
    while (j<=EI)
    {
        ar[k]=arr[j];
        j++;
        k++;
    }
    int b=0;
    for(int l=SI;l<=EI;l++)
    {
        arr[l]=ar[b];
        b++;
    }
return arr;
    }
}

