<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>發送請求給 servlet - Ajax</title>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>

<body>
  <h1>發送請求給 servlet - Ajax</h1>
  <br>

  <%-- GET --%>
  名字:&nbsp;<input type="text" id="name">
  <button onclick="sendGet()">GET</button>
  <br>

  <%-- POST --%>
  名字:&nbsp;<input type="text" id="name2">
  <button onclick="sendPost()">POST</button>
  <br>

  <script>
    /** 發送 GET 請求 */
    function sendGet() {
      let nameVal = $('#name').val()
      $.ajax({
        type: 'GET',
        url: "to_servlet_XHR_form?name=" + nameVal,
        success: function (data) {
          console.log(data)
        },
        error: function (err) {
          console.error(err);
          alert("資料有誤");
        }
      })
    }

    /** 發送 POST 請求 */
    function sendPost() {
      let nameVal = $('#name2').val()
      $.ajax({
        type: 'POST',
        url: "to_servlet_XHR_form",
        data: {
          name: nameVal
        },
        success: function (data) {
          console.log(data)
        },
        error: function (err) {
          console.error(err);
          alert("資料有誤");
        }
      })
    }
  </script>
</body>

</html>