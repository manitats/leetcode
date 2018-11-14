class Solution {
    public String longestCommonPrefix(String[] strs) {

      if (strs != null && strs.length < 1) {
        return "";
      }
      else if (strs.length == 1 ) {
        return strs[0];
      }
      
      List<String> sortedList = Stream.of(strs)
                                .sorted((s1, s2) -> s1.length() - s2.length())
                                .collect(Collectors.toList());
      String smallestStr = sortedList.get(0);
      
      int range = 0;
      int minMatch = smallestStr.length();
      
      for(String str : sortedList) {     
        boolean matched = false;
        int matchNums = 0;
        
        for (int i = 1; i <= smallestStr.length(); i++) {
          
           if (str.startsWith(smallestStr.substring(0, i))) {
              matched = true;
              if (i > matchNums && i <= minMatch) {
                range = i;
                matchNums = i;
              }
            }

        }
        
        if (!matched) {
          return "";
        } else {
          minMatch = range;
        }
      }
      return smallestStr.substring(0, range);
    }
}
