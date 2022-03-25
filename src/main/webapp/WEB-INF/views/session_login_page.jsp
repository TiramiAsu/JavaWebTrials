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
  <h1>Session<span style="font-size:20px">[登入頁]</span></h1>
  <form method="POST" action="./session">
    帳號:&nbsp;<input type="text" name="acct"><br>
    密碼:&nbsp;<input type="text" name="pwd"><br>
    <input type="submit" value="POST">
  </form>
  <h4 style="color:red">訊息: ${msg}</h4>
  <h4 style="color:red">session 中代碼: ${sessionScope.msg}</h4>
</body>
</html>