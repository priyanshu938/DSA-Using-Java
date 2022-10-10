class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr));
    }

    // O(N^2)
    static int maxSum(int[] arr){
        int csum=0;
        int res=arr[0];
        for(int i=0;i<arr.length;i++){
            csum=0;
            for(int j=i;j<arr.length;j++){
                csum+=arr[j];
                if(res<csum){
                    res=csum;
                }
            }
        }
        return res;
    }

    // O(N)
    static int maxSum2(int[] arr){
        int csum=0;
        int psum=0;
        int res=arr[0];
        for(int i=0;i<arr.length;i++){
            csum=psum+arr[i];
            psum=Math.max(csum,arr[i]);
            if(res<psum){
                res=psum;
            }
        }
        return res;
    }
}