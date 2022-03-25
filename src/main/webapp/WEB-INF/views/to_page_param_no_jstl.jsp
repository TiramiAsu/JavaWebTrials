<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Java 傳送參數給前端 JSP 頁面 - 無使用 jstl</title>
</head>
<body>
  <h1>Java 傳送參數給前端 JSP 頁面 - 無使用 jstl</h1>
  <%
    String showName = (String) request.getAttribute("name");
  %>

  It's JSP, the name is <%= request.getAttribute("name") %>.<br>
  And You can using this way to get name: <%= showName %><br>
  And or using this way to get name: ${name}<br>
</body>
</html>