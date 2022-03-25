<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="data.Item" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP</title>
  <style>
    td {
      border: solid 1px;
    }
  </style>
</head>
<body>
  <h1>JavaServer Pages, JSP</h1>
  <%-- JSP 註解(只有開發者看得見) --%>
  <!-- JSP 註解(會出現在程式碼中) --%>
  <!-- HTML 註解 -->
  <%
    // java 程式註解
  %>
  <div style="font-family:monospace;">
    <ul>[JSP 常用標籤]
      <ol>
        <li>&lt;%@ %&gt;: 指令設定(jsp, encoding, import 等設定)</li>
        <li>&lt;%! %&gt;: 宣告實作區</li>
        <li>&lt;% %&gt;: java 程式邏輯片段</li>
        <li>&lt;%= %&gt;: 顯示資料片段</li>
        <li>&#36;{ }: EL 表達式(Expression Language, EL)</li>
      </ol>
    </ul>
    <br>
    <ul>[註解]
      <ol>
        <li>&lt;%-- --%&gt;: JSP 註解(只有開發者看得見)</li>
        <li>&lt;!-- --%&gt;: JSP 註解(會出現在程式碼中)</li>
        <li>&lt;!-- --&gt;: HTML 註解</li>
        <li>&lt;%<br>&nbsp;&nbsp;// java 程式註解<br>%&gt;</li>
      </ol>
    </ul>
  </div>
  <br>

  <%!
    String title1 = "編號";
    String title2 = "名稱";
  %>
  <table>
    <tr>
      <td><% out.print(title1); %></td>
      <td><%= title2 %></td>
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