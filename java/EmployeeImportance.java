/*
You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
 They have importance value 15, 10 and 5, respectively.
 Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
 Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
 They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 

Note:

One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.

1.我的解法：深度遍历，将目标id与其子id挨个存储到int[] map中，并将未存储的子id用深遍去寻找新的子id。但是循环太多次了。12ms。
2.最优解：将目标id对应的employee存储到Employee[] employeeArray中，只循环了一次，后来都直接用这个employeeArray。4ms。

*/


/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int res = 0;
    int[] map = new int[2000];
    public int getImportance(List<Employee> employees, int id) {
        getSubordinates(employees, id);
        for (Employee e: employees) if (map[e.id] > 0) res += e.importance;
        return res;
    }
    public void getSubordinates(List<Employee> employees, Integer id) {
        for (Employee e: employees) {
            if (e.id == id) {
                map[e.id] ++;
                for (Integer i: e.subordinates) {
                    if (map[i] == 0) getSubordinates(employees, i);
                }
                return;
            }
        }
    }
}


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee[] employeeArray = new Employee[2000];
        for (Employee employee : employees) employeeArray[employee.id] = employee;
        return sum(id, employeeArray);
    }
    private int sum(int id, Employee[] employeeArray) {
        List<Integer> subs = employeeArray[id].subordinates;
        int ans = employeeArray[id].importance;
        if (subs == null || subs.size() == 0) return ans;
        for (Integer sub : subs) ans += sum(sub, employeeArray);
        return ans;
    }
}