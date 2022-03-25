<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>首頁</title>
  <%-- Bootstrap --%>
  <%-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"> --%>
  <%-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> --%>
  <link rel="stylesheet" href="static/css/bootstrap-5.1.3/bootstrap.min.css">
  <script src="static/js/bootstrap-5.1.3/bootstrap.bundle.min.js"></script>
  <style>
    body {
      padding: 10px 20px 30px 20px;
    }
    .tableContainer {
      padding: 10px 0 30px 0;
    }
  </style>
</head>
<body>
  <h1>我的首頁 - JSP</h1>
  <div class="tableContainer">
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">索引</th>
          <th scope="col">序號</th>
          <th scope="col">頁面名稱</th>
          <th scope="col">Servlet 路徑</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="urlInfo" items="${urlInfoList}" varStatus="status">
        <tr>
          <th scope="row">${status.index}</td>
          <th scope="row">${status.count}</td>
          <td>${urlInfo.pageName}</td>
          <td>
            <a href=".${urlInfo.urlPattern}">${urlInfo.urlPattern}</a>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>