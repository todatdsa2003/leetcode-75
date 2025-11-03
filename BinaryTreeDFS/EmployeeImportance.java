/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private Map<Integer, Employee> employeeMap;
    public int getImportance(List<Employee> employees, int id) {
        employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.id, emp);
        }

        return dfs(id);
    }

    private int dfs(int currentEmployeeId) {
        Employee currentEmployee = employeeMap.get(currentEmployeeId);
        int total = currentEmployee.importance;
        List<Integer> subordinates = currentEmployee.subordinates;

        for (Integer subordinate : subordinates) {
            total += dfs(subordinate);
        }

        return total;
    }
}