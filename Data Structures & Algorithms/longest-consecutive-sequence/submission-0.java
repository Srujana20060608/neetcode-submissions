class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int start=nums[i];
                int current=nums[i];
                while(set.contains(current+1)){
                    current++;
                }
                len = Math.max(current - start + 1, len);
            }
        }
        return len;
    }
}
