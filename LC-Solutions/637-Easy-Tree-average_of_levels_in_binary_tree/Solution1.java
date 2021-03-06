/*
Author: Jiamin
Date: Dec 21, 2017
Problem: Average of Levels in Binary Tree

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        q.offer(root);
        int size = q.size();
        double sum = 0;
        while(!q.isEmpty()) {
            sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum+= cur.val;
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            double avg = sum/size;
            res.add(avg);
            size = q.size();
        }
        return res;
    }
}

// Aug 2nd 2018, review
// 6ms 81%
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        int size = q.size();
        while(!q.isEmpty()){
            Double sum = 0.0;
            for( int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            Double res = sum/size;
            list.add(res);
            size = q.size();
        }
        return list;
    }
}