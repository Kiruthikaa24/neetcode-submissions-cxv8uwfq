class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree= new int[numCourses];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites)
        {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        int finished=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            finished++;
            for(int neigh: adj.get(node))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.add(neigh);
                }
            }
        }
        return finished==numCourses;
    }
}
