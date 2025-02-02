//https://leetcode.com/problems/camelcase-matching
//TC : O(nk) -> n- number of queries, k - avg length of query
//SC : O(1)
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String q : queries){
            boolean flag = false;
            for(int i=0,j=0 ; i<q.length();i++){
                char cq = q.charAt(i);
                if(j<pattern.length() && cq == pattern.charAt(j)){
                    j++;
                    if(j == pattern.length())
                        flag = true;
                }else if(Character.isUpperCase(cq)){
                    flag = false;break;
                }
            }
            result.add(flag);
        }
        return result;
    }
}
