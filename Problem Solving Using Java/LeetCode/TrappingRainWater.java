class TrappingRainWater{
    public static void main(String args[]){
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
            int water=0;
            if(height.length==0 || height.length==1){
                return 0;
            }
            int i=0;
            int j=1;
            int maxInd=0;
            for(int k=0;k<height.length;k++){
                if(height[maxInd]<height[k]){
                    maxInd=k;
                }
            }
            boolean check=false;
            int minHeight=0;
            while(i<maxInd){
                if(height[i]<height[j]){
                    i++;
                    j++;
                    continue;
                }
                int maxHeight=height[j];
                while(height[i]>height[j]){
                    if(j==height.length-1){
                        check=true;
                        break;
                    }
                    maxHeight=Math.max(maxHeight,height[j]);
                    j++;
                }
                if(!check){
                    minHeight=(int)Math.min(height[i],height[j]);
                }
                while(i+1!=j){
                    if(check){
                        water+=(maxHeight-height[i+1]);
                        i++;
                    }
                    else{
                        water+=(minHeight-height[i+1]);
                        i++;
                    }
                }
                i=j;
                if(i!=maxInd){
                    j++;
                }
            }
            int k=height.length-1;
            j=k-1;
            while(k>maxInd){
                if(height[k]<height[j]){
                    k--;
                    j--;
                    continue;
                }
                while(height[k]>height[j]){
                    j--;
                }
                minHeight=(int)Math.min(height[k],height[j]);
                while(k-1!=j){
                        water+=(minHeight-height[k-1]);
                        k--;
                }
                k=j;
                if(k!=maxInd){
                    j--;
                }
            }
            return water;
        }}