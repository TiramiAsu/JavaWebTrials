<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Session</title>
  <style>
    td {
      border: solid 1px;
    }
  </style>
</head>
<body>
  <h1>Session</h1>
  <br>
  <table>
    <tr>
      <td>序號</td>
      <td>帳號</td>
      <td>密碼</td>
      <td>servlet url</td>
    </tr>
    <c:forEach var="info" items="${userInfoList}" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${info.account}</td>
      <td>${info.password}</td>
      <td>
        <a href="session?account=${info.account}&password=${info.password}">/session?account=${info.account}&password=${info.password}</a>
      </td>
    </tr>
  </c:forEach>
  </table>
  <br>
  <c:if test="${isLogin}">
    ${userInfo.account}&nbsp;登入成功!!
  </c:if>
  <c:if test="${!isLogin}">
    <br>
  </c:if>
  <h3>登入清單</h3>
  <div style="${loginList.size() > 0 ? '' : 'display: none;'}">
    <table>
      <tr>
        <td>序號</td>
        <td>帳號</td>
        <td>session ID</td>
      </tr>
      <c:forEach var="login" items="${loginList}" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${login.account}</td>
        <td>${login.sessionId}</td>
      </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>