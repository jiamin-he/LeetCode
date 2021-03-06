/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 20, 2017
 Problem:    merge two binary trees
 Difficulty: Easy
 Notes:
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.


eg
Input: 
    Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
         3
        / \
       4   5
      / \   \ 
     5   4   7

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return null;
        }
        
        int val= (t1==null? 0: t1.val) + (t2==null? 0: t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeTrees((t1==null? null :t1.left),(t2==null? null:t2.left));
        newNode.right = mergeTrees((t1==null? null: t1.right),(t2==null? null:t2.right));

        return newNode;
    }
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        


        head.next = first;
        first.next = second;
        second.next = third;

        System.out.println("list: ");
        print(head);

        deleteNode(second);
        System.out.println("deleted list: ");
        print(head);



    }
}
