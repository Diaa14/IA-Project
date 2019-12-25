<%-- 
    Document   : login
    Created on : Dec 20, 2019, 2:13:00 PM
    Author     : Diaa Mamdouh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
             <br><br><br><br>
        <center><h1>Login</h1></center>
            <Form  action="loginValidate" name="LoginForm" onsubmit="return validateForm()" method="POST">
                
                <table align="center">
                <tr>
                    <th align="right">UserName : </th>
                    <td><input type="text" name="username" placeholder="username" /></td>
                </tr>
                <br>
                <tr>
                    <th align="right">Password : </th>
                    <td><input type="password" name="Pass" placeholder="Pass"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" name="submit" value="Login"/>
                    </td>
                </tr>
                 
                </table>
            </Form>
<script>
function validateForm() {
  var name = document.forms["LoginForm"]["username"].value;
  var password = document.forms["LoginForm"]["Pass"].value;
  
  if (name === "") {
    alert("username must be filled out");
    return false;
}
  if (password === "") {
    alert("password must be filled out");
    return false;
  }
}


</script>
    </body>
</html>
