/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 19, 2017
 Problem:    Diameter of Binary Tree
 Difficulty: Easy
 Notes:

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

eg

Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        depth(root,res);
        return res[0];
    }
    public int depth(TreeNode root, int[] res) {
        if(root == null) return 0;
        int l = depth(root.left,res), r = depth(root.right,res);
        res[0] = Math.max(res[0], l+r);
        return Math.max(l,r) +1;
        
    }
}