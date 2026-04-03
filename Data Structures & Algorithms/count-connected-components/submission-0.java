class Solution {
    public int countComponents(int n, int[][] edges) {
        /*Create adj, a list of lists → adjacency list representation of the graph.

visit[i] keeps track of whether node i has been visited.

Since the graph is undirected, for each edge [u, v]:

Add v to u’s list.

Add u to v’s list.

✅ Now we can easily explore neighbors of each node. */
     List<List<Integer>> adj=new ArrayList<>();
     boolean[] visit=new boolean[n];
     for(int i=0;i<n;i++)
     {
        adj.add(new ArrayList<>());
     }
     for(int[] edge:edges)
     {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
     }
     /*For each node:

If it hasn’t been visited, that means we’ve found a new connected component.

Run DFS starting from this node to mark all nodes in this component as visited.

Increment res (the component counter).*/
     int res=0;
     for(int node=0;node<n;node++)
     {
        if(!visit[node])
        {
            dfs(adj,visit,node);
            res++;
        }
     }
     return res;
    }
    //Recursive DFS:
//Mark current node as visited.
//For each neighbor (nei) of the node:
//If not visited, call DFS on it.
//This keeps exploring until the whole connected component is covered.
    private void dfs(List<List<Integer>> adj, boolean[] visit, int node)
    {
        visit[node]=true;
        for(int neigh: adj.get(node))
        {
            if(!visit[neigh])
            {
                dfs(adj,visit,neigh);
            }
        }
        //for input 2
        /*Step by step:

Start with node 0: not visited → run DFS(0). This visits 0,1,2. res = 1.

Node 1: already visited → skip.

Node 2: already visited → skip.

Node 3: not visited → run DFS(3). This visits 3,4. res = 2.

Node 4: already visited → skip.

Final: res = 2 connected components. */
    }
}
