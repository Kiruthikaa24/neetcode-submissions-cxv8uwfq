/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// //https://chatgpt.com/share/68e787aa-6d5c-8009-a467-d8d77271ba52
class Solution {
    public int kthSmallest(TreeNode root, int k) {
         TreeNode curr = root; 
        while (curr != null) { 
            if (curr.left == null) { 
                k--; 
                if (k == 0) 
                return curr.val;
                 curr = curr.right; 
                 }
                  else 
                  { TreeNode pred = curr.left; 
                  while (pred.right != null && pred.right != curr) pred = pred.right; 
                  if (pred.right == null) { 
                    pred.right = curr;
                     curr = curr.left; } 
                  else {
                     pred.right = null;
                      k--; 
                      if (k == 0)
                       return curr.val;
                        curr = curr.right; 
                        } 
                        } 
            } 
            return -1; 
    }
}
