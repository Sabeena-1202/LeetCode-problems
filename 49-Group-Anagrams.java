class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagMap = new HashMap<>();

        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(!anagMap.containsKey(sortedStr)){
                anagMap.put(sortedStr, new ArrayList<>());
            }

            anagMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagMap.values());
    }
}