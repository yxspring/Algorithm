/*Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/nth-highest-salary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
declare:定义变量 default 默认值
IF(expr1,expr2,expr3): 如果expr1的值为true,则返回expr2的值,如果expr1的值为false,则返回expr3的值.
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  declare  c  INT default if(N>0,N-1,1);
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT  IFNULL(Salary,null) FROM `employee` ORDER BY Salary desc limit 1 OFFSET c
  );
END