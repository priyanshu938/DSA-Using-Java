/*
Problem : 
There are n people in the party. 
Each person is wearing T-shirts with numbers written on the T-shirts. 
The numbers on the T-shirts can be unique or the same.
In three turns 3 people leave the party one at a time.
You are provided with the people remaining in the party after every turn.
You need to print the T-shirt number of people who left the party in the order they left.

Note :
First line contains t test cases
For each test case we have  -
Line 1 has list size
Line 2 has n elements
Line 3 has n-1 element
Line 4 has n-2 element
Line 5 has n-3 element

O/p :
List of missing element in each step

Ex-
1) 

Input :
1
7
11 5 1 2 7 3 1
11 5 2 7 3 1
5 2 7 3 1
5 7 3 1

Output :
1 11 2  

2) 
Input :
2
5
3 4 6 6 7
3 4 6 7
3 4 6
4 6
6
1 5 8 3 3 4
1 8 3 3 4
8 3 3 4
8 3 4

Output :
6 7 3
5 1 3

*/

import java.util.*;

public class TShirtMissing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(), i, j, k, n = 0;
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for (i = 1; i <= t; i++) {
            n = scanner.nextInt();
            List<List<Integer>> inp = new LinkedList<List<Integer>>();

            for (j = 1; j <= 4; j++) {
                List<Integer> sub = new LinkedList<Integer>();
                for (k = 1; k <= n - j + 1; k++) {
                    sub.add(scanner.nextInt());
                }
                inp.add(sub);
            }
            ans.add(findTshirtMiss(inp));
        }
        scanner.close();
        System.out.println("Output :");
        for (List<Integer> x : ans) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> findTshirtMiss(List<List<Integer>> inp) {
        int i, j, k, flag = 0;
        List<Integer> ans = new LinkedList<Integer>();
        for (i = 0; i < 3; i++) {
            List<Integer> l1 = inp.get(i);
            List<Integer> l2 = inp.get(i + 1);
            flag = 0;
            for (j = 0, k = 0; k < l2.size(); j++, k++) {
                if (l1.get(j) != l2.get(k)) {
                    ans.add(l1.get(j));
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) // checks if the element is removed from the end of l1
                ans.add(l1.get(l1.size() - 1));
        }
        return ans;
    }
}
