class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String s:strs){
            str+= s.length()+"#"+s;
        }
        return str;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=str.indexOf("#",i);
            int n = Integer.parseInt(str.substring(i,j));
            String st = str.substring(j+1,j+1+n);
            result.add(st);
            i=j+1+n;
        }
        return result;
    }
}
