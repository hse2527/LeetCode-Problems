class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String key;
        List<String> list;
        char[] arr;
        for(String str : strs) {
            arr = str.toCharArray();
            Arrays.sort(arr);
            key = new String(arr);
            list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}