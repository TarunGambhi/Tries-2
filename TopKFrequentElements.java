//https://leetcode.com/problems/top-k-frequent-elements
//TC : O(n)
//SC : O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max = Math.max(max,map.get(num));
        }
        int[] result = new int[k];
        Map<Integer,List<Integer>> freqMap = new HashMap<>();
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq,new ArrayList<>());
            }
            freqMap.get(freq).add(key);
        }
        for(int i = max; i>0 && k>0;i--){
            List<Integer> li = freqMap.get(i);
            if(li == null) continue;
            for(int j=0;j<li.size() && k>0;j++){
                result[--k] = li.get(j); 
            }
        }
        return result;
    }
}
