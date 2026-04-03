class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0)
        {
            return Character.toString((char)257);
        }
        String separate=Character.toString((char)257);
        StringBuilder sb=new StringBuilder();
        for(String s : strs)
        {
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String str) {
         String separate=Character.toString((char)257);
          if(str.equals(separate))
          {
            return new ArrayList<>();
          }
         

          return Arrays.asList(str.split(separate,-1));
    }
}
