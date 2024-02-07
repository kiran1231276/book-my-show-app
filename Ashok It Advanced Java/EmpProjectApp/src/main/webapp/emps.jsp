<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search Employee</title>
</head>
<body>
       <a href="index.jsp">Add New Emp</a>
       
    <form action="select" method="POST">
        <table>
            <tr>
                <td>Emp Gender</td>
                <td>
                    <select name="gender">
                        <option value="">-Select-</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Emp Department</td>
                <td>
                    <select name="dept">
                        <option value="">-Select-</option>
                        <option value="development">Development</option>
                        <option value="testing">Testing</option>
                        <option value="db">Database</option>
                        <option value="ops">Operations</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Emp Exp</td>
                <td>
                    <select name="exp">
                        <option value="">-Select-</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
            <hr/> 
            <table border="1">
    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Dept</th>
            <th>Exp</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${emps}" var="emp" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${emp.empName}</td>
                <td>${emp.empEmail}</td>
                <td>${emp.empGender}</td>
                <td>${emp.empDept}</td>
                <td>${emp.empExp}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
