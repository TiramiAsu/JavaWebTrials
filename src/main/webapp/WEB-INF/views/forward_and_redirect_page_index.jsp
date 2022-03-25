<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>轉發與重定向</title>
  <style>
    td {
      border: solid 1px;
    }
  </style>
</head>
<body>
  <h1>轉發與重定向<span style="font-size:20px">[首頁]</span></h1>
  <table>
    <tr>
      <td>帶參數 ?k=true</td>
      <td>轉發成功頁A</td>
    </tr>
    <tr>
      <td>帶參數 ?k=false</td>
      <td>轉發成功頁B</td>
    </tr>
    <tr>
      <td>帶參數 ?k=abc</td>
      <td>轉發錯誤頁</td>
    </tr>
  </table>
  
  <h3 style="color:red">訊息: ${msg}</h3>
</body>
</html>