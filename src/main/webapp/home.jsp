<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Home Page</title>
</head>
<body>
  <h3>Hello ${user.name} ${user.surname}</h3>
  <p>${user.id}</p>
  <p>${user.login}</p>
  <p>${user.age}</p>
  <p>${user.email}</p>
</body>
</html>
