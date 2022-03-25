<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cookie</title>
</head>
<body>
  <h1>Cookie<span style="font-size:20px">[A頁]</span></h1>
  <br>
  <h4 style="color:red">訊息: ${msg}</h4>
  <a href="../cookie">回 Cookie 登入頁</a>
  <script>
    /** 取得 cookies */
    function getCookie(name){
      let regex = ["(^| )", name, "=([^;]*)(;|$)"].join('')
      let arr = document.cookie.match(new RegExp(regex))
      return (arr != null
        ? unescape(arr[2])
        : null)
    }
    
    /** 移除 cookies */
    function removeCookie(name){
      let exp = new Date()
      exp.setTime(exp.getTime() - 1)
      let cval = getCookie(name)
      if (cval != null)
        document.cookie = [name, "=", cval, ";expires=", exp.toGMTString()].join('');
    }
  </script>
</body>
</html>