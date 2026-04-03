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
            //(because pre[0] depends on pre[1]).
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        //Start with courses that have no prerequisites (indegree = 0).
         //These can be taken immediately.
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
//Pop a course from the queue → mark it as finished.
//Decrease indegree of all its neighbors (because one prerequisite is now completed).
//If some neighbor’s indegree becomes 0, it means all its prerequisites are done → add it to queue.
//This is exactly Kahn’s Algorithm for topological sorting.
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
        //If we were able to finish all courses, finish == numCourses.
//If there’s a cycle, some courses will never reach indegree = 0, so they never get processed, and finish < numCourses.
        return finished==numCourses;
    }
}
