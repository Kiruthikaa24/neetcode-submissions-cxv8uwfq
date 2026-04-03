class MedianFinder {
    //It’s a dynamic array provided by Java’s java.util package.
//It can grow or shrink in size automatically as you add or remove elements — unlike a regular array (int[]), which has a fixed size.
    public ArrayList<Integer> data;

    public MedianFinder() {
        data=new ArrayList<>();
    }
    
    public void addNum(int num) {
        data.add(num);
        
    }
    
    public double findMedian() {
        Collections.sort(data);
        int n=data.size();
        /*This checks whether n is odd.

 (n & 1) means:

Bitwise AND of n and 1

Returns 1 if n is odd, 0 if even.

Examples:

5 & 1 = 1 → odd

6 & 1 = 0 → even */
        if((n &1)==1)
        {
            return data.get(n/2);
        }
        else
        {
            return (data.get(n/2)+ data.get(n/2-1))/2.0;
        }
    }
}
