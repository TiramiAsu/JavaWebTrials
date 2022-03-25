<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="data.Item" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Fifth Servlet Page2</title>
  <style>
    td {
      border: solid 1px;
    }
  </style>
</head>
<body>
  <h1>Hello Five World [JSP]</h1>
  <br>
  <ol>
    <li>&lt;%@ %&gt;: 指令設定(jsp, encoding, import 等設定)</li>
    <li>&lt;%! %&gt;: 宣告實作區</li>
    <li>&lt;% %&gt;: java 程式邏輯片段</li>
    <li>&lt;%= %&gt;: 顯示資料片段</li>
    <li>&#36;{ }: EL 表達式(Expression Language, EL)</li>
  </ol>
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
      <td><%= item.getName() %></td>
    </tr>
    <%
      }
    %>
  </table>
</body>
</html>