/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 05, 2017
 Problem:    Accounts Merge
 Difficulty: Medium
 Notes:

Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

*/


//dsu
//166ms 26.25%
class Solution {
    int MAX_EMAIL_VALUE = 10000;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> name = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        int count = 0;
        DSU dsu = new DSU(MAX_EMAIL_VALUE + 1);
        // a email address --> a name and an index
        for(List<String> account: accounts){
            String tempName = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                if(!name.containsKey(account.get(i))) {
                    name.put(account.get(i), tempName);
                    index.put(account.get(i),count++);
                }
                dsu.union(index.get(account.get(1)), index.get(account.get(i)));
            }
        }
        
        //format
        Map<Integer, List<String>> res = new HashMap<>();
        for(String email: name.keySet()) {
            res.computeIfAbsent(dsu.find(index.get(email)), (k) -> new ArrayList<>()).add(email);
        }
        for(List<String> ret: res.values()) {
            Collections.sort(ret);
            ret.add(0,name.get(ret.get(0)));
        }
        return new ArrayList(res.values());
    }
    
    class DSU {
        int[] parent;
        int[] rank;
        
        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if( parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if(rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
                rank[xp]++;
            }
        }
    }
}

