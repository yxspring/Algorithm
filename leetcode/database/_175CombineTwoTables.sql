/**
Table: Person
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
 
Write a SQL query for a report that provides the following information for each person in the Person table,
regardless if there is an address for each of those people:
FirstName, LastName, City, State
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combine-two-tables
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255))
Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255))
Truncate table Person
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
Truncate table Address
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')

idea: The table Person left join the table Address on Person.PersonId=Address.PersonId
the Table join knowledge from "https://coolshell.cn/articles/3463.html?amp=1";
the reason of using left join:
    The left outer join produces the complete set of table person, while the matched one in the address table has a value, and the unmatched one is replaced by a null value.
*/
编写一个SQL查询,满足条件:
无论 person 是否有地址信息,都需要基于上述两表提供 person 的以下信息:
FirstName, LastName, City, State:
SELECT
	p.FirstName,
	p.LastName,
	a.City,
	a.State
FROM
	person p
	LEFT JOIN address a ON p.`PersonId` = a.`PersonId`;