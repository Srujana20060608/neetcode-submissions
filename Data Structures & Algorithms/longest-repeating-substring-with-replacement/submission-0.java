class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left=0;
        int right=0;
        int len=0;
        int maxf=0;
        while(right<s.length()){
            count[s.charAt(right)-'A']++;
            maxf = Math.max(maxf,count[s.charAt(right)-'A']);
            while(((right-left+1)-maxf)>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}
