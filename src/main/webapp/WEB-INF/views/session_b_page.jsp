<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Session</title>
</head>
<body>
  <h1>Session<span style="font-size:20px">[B頁]</span></h1>
  <br>
  <form method="POST" action="./logout">
    <input type="submit" value="登出">
  </form>
  <h4 style="color:red">訊息: ${msg}</h4>
  <a href="../session">回 Session 登入頁</a>
</body>
</html>