<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>發送請求給 servlet - XHR, form</title>
</head>
<body>
  <h1>發送請求給 servlet - XHR, form</h1>
  <br>

  <%-- GET 1 --%>
  名字:&nbsp;<input type="text" id="name">
  <button onclick="sendGetRequest()">GET</button>
  <br>

  <%-- GET 2 --%>
  <a href="./to_servlet_XHR_form?name=HaHa">GET</a>
  <br>

  <%-- GET 3 --%>
  名字:&nbsp;<input type="text" id="name2">
  <button type="button" onclick="sendGet()">GET</button>
  <br>

  <%-- POST --%>
  <form action="./to_servlet_XHR_form" method="POST">
    名字:&nbsp;<input type="text" name="name">
    <input type="submit" value="POST">
  </form>
  
  <script>
    /** 發送 GET 請求 */
    function sendGetRequest() {
      console.log('發送 GET 請求')
      let name = document.getElementById('name').value
      // send request
      let xhr = new XMLHttpRequest()  
      xhr.open('GET', './to_servlet_XHR_form?name=' + name)
      xhr.send()
    }
    function sendGet() {
      console.log('發送 GET 請求2')
      let name = document.getElementById('name2').value
      let a = document.createElement('a')
      a.href = './to_servlet_XHR_form?name=' + name
      a.click()
    }
  </script>
</body>
</html>