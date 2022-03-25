<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Java 傳送參數給前端 JSP 頁面 - 使用 jstl</title>
</head>
<body>
  <h1>Java 傳送參數給前端 JSP 頁面 - 使用 jstl</h1>
  name: <c:out value="${name}"></c:out>
  <br>
  sameName: <c:out value="${newSetName}"></c:out>
</body>
</html>