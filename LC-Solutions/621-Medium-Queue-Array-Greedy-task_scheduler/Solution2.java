/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 24, 2017
 Problem:    task scheduler
 Difficulty: medium
 Notes:
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c:tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);
        int i = 24;
        while(i>=0 && map[i] == map[25]){
            i--;
        }
        int total = (map[25] - 1) * (n + 1) + (25 - i);
        if (total < tasks.length)  return tasks.length;
        return total;
    }
}
