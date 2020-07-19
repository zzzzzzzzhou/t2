<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>test index</title>
</head>
<body>
<h1>系统管理</h1>
<!--<div th:each="dept : ${depts}">-->
<!--<h1 th:text="${dept.dept_num}"></h1>-->
<!--    <h1 th:text="${dept.dept_name}"></h1>-->

<a href="#" th:href="@{/dept}">跳转到dept/list.html</a><br><br>
<a href="#" th:href="@{/position}">跳转到position/list.html</a><br><br>
<a href="#" th:href="@{/ManageEmployee}">ManageEmployee/list.html</a><br><br>
</div>
</body>
</html>