class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = need.size();
        int have = 0;

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if(need.containsKey(c) &&
               window.get(c).equals(need.get(c))) {
                have++;
            }

            while(have == required) {

                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                window.put(remove, window.get(remove) - 1);

                if(need.containsKey(remove) &&
                   window.get(remove) < need.get(remove)) {
                    have--;
                }

                left++;
            }

            right++;
        }

        if(minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}