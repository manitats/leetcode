class Solution {
    public static final Map<String, Integer> map = new HashMap<>();
    static {
      map.put("I", 1);
      map.put("V", 5);
      map.put("X", 10);
      map.put("L", 50);
      map.put("C", 100);
      map.put("D", 500);
      map.put("M", 1000); 
    }
  
    public int romanToInt(String s) {
        String[] strs = s.split("");
        int sum = 0;
        for(int i = 0; i < strs.length; i++) {
          if (i > 0 && shouldRecalc(strs[i - 1], strs[i])) {
            sum += map.get(strs[i]) - map.get(strs[i - 1]) * 2;
          } else {
            sum += map.get(strs[i]);
          }
          //System.out.println(sum);
        }
      
      return sum;
    }
  
    public static boolean shouldRecalc(String before, String current) {
      if (before.equals("I")) {
        return current.equals("V") || current.equals("X");
      } else if (before.equals("X")) {
        return current.equals("L") || current.equals("C");
      } else if (before.equals("C")) {
        return current.equals("D") || current.equals("M");
      } else {
        return false;
      }
    } 
  
}
