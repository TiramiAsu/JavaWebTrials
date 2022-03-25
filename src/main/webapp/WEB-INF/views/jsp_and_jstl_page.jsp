<%@ page language="java" pageEncoding="UTF-8"%> <%-- 必須加--%>
<%@ page import="java.util.*" %> <%-- 使用 jstl 後, 就不需要 import, 需要 import 是因為在 html 中寫 java code --%>
<%@ page import="data.Item" %> <%-- 使用 jstl 後, 就不需要 import, 需要 import 是因為在 html 中寫 java code --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  1 下載 https://mvnrepository.com/artifact/taglibs/standard/1.1.2 jar 檔案
  2 下載 https://mvnrepository.com/artifact/javax.servlet/jstl/1.2 jar 檔案
  3 兩個 jar 檔案放在 WEB-IN/lib 中
  4 引用 jstl 的 JSP 必須加上 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 即可
 --%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP and JSTL</title>
  <style>
    td {
      border: solid 1px;
    }
  </style>
</head>
<body>
  <h1>JSP and JSTL</h1>
  <br>
  <%-- JSP 註解(只有開發者看得見) --%>
  <!-- JSP 註解(會出現在程式碼中) --%>
  <!-- HTML 註解 -->
  <%
    // java 程式註解
  %>

  <%-- 1 使用原生 java 嵌入 html 方式顯示
  <table>
    <tr>
      <td>編號</td>
      <td>名稱</td>
    </tr>
    <%
      List<Item> itemList = (List<Item>) request.getAttribute("itemList");
      for (Item item : itemList) {
    %>
    <tr>
      <td><% out.print(item.getNo()); %></td>
      <td><% out.print(item.getName()); %></td>
    </tr>
    <%
      }
    %>
  </table>
  --%>

  <%-- 2 使用 jstl 方式顯示 --%>
  <table>
    <tr>
      <td>編號</td>
      <td>名稱</td>
    </tr>
    <%-- 同 for (Item item : itemList) {} --%>
    <c:forEach var="item" items="${itemList}">
      <tr>
        <td>${item.no}</td> <%-- 直接 .屬性名稱取得資料 --%>
        <td>${item.getName()}</td> <%-- 使用 .get 方法也可取得資料 --%>
      </tr>
    </c:forEach>
  </table>
</body>
</html>