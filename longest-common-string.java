class Solution {
    public String longestCommonPrefix(String[] strs) {

      if (strs != null && strs.length < 1) {
        return "";
      }
      if (strs.length ==1 ) return strs[0];

      List<String> sortedList = Stream.of(strs)
                                .sorted((s1, s2) -> s1.length() - s2.length())
                                .collect(Collectors.toList());
      String smallestStr = sortedList.get(0);
      
      int[] range = new int[2];
      int minMatch = smallestStr.length();
      //System.out.println(smallestStr);
      for(String str : sortedList) {     
        boolean matched = false;
        int matchNums = 0;
        
        //System.out.println(str);
        for (int i = 0; i < smallestStr.length(); i++) {
          
          for (int end = i + 1; end <= smallestStr.length(); end++) {
              if (str.contains(smallestStr.substring(i, end))) {
                matched = true;
                //System.out.println("i; " + i + ", " + end);
                if ((end - i) > matchNums && (end - i) <= minMatch) {
                  range[0] = i;
                  range[1] = end; 
                  matchNums = end - i;
                }
              }
          }

        }
        
        if (!matched) {
          return "";
        } else {
          minMatch = range[1] - range[0];
          //System.out.println("minMatch: " + minMatch);;
        }
      }
      return smallestStr.substring(range[0], range[1]);
    }
}
