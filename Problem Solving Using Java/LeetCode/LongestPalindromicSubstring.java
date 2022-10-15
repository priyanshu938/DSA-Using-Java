class Solution {
    
    public String longestPalindrome(String s) {
     
         if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i=0; i<s.length()-1; i++)
        {
           int len1= expandRange(s, i,i);
            int len2= expandRange(s, i,i+1);
            
     int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
        }
         return s.substring(start, end+1);
       
    }
    
    
    private int expandRange(String s, int l, int h)
    {
         
         while(l>=0 && h<s.length() && s.charAt(l)==s.charAt(h))
         {
           l--;
         h++;
         }

     
        return h-l-1;
    }
    
}

    
