class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        List<Integer>[] freq=new List[nums.length+1];
        for(int i=0;i<freq.length;i++)
        {
            freq[i]=new ArrayList<>();
        }
        /*loops through every element n in the array nums

Uses a HashMap<Integer, Integer> called count

For each number:

If it’s not yet in the map, start at 1

If it’s already in the map, increase its count by 1*/
        for(int n:nums)
        {
            count.put(n,count.getOrDefault(n,0)+1);
        }
        /*Now that we know each number’s frequency,
we’ll group numbers by how often they appear.

entry.getKey() → the number itself

entry.getValue() → how many times it appeared

We’re adding each number to a “bucket” that corresponds to its frequency.*/
        for(Map.Entry<Integer,Integer> entry: count.entrySet())
        {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res=new int[k];
        int index=0;
        for(int i=freq.length-1;i>0 && index<k;i--)
        {
            for(int n:freq[i])
            {
                res[index++]=n;
                if(index==k)
                {
                    return res;
                }
            }
        }
        return res;
    }
}
