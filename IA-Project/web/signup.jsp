<%-- 
    Document   : signup
    Created on : Dec 20, 2019, 2:13:15 PM
    Author     : Diaa Mamdouh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp Page</title>
    </head>
    <body>
        <center><h1>Sign Up</h1></center>
            <Form name="regestration_form" action="SignUpValidate" onsubmit="return validateForm()" method="POST" enctype="multipart/form-data">
                
                <table align="center">
                
                <tr>
                    <th align="right">Username : </th>
                    <td><input type="text" name="username" placeholder="username" onblur="checkExist()"/><span id="isExist"></span></td>
                </tr>
                <br>
                <tr>
                    <th align="right">E-Mail: </th>
                    <td><input type="text" name="email" placeholder="email"/></td>
                </tr>
                <br>
                <tr>
                    <th align="right">Mobile : </th>
                    <td><input type="text" name="mobile" placeholder="mobile"/></td>
                </tr>
                <br>
                <tr>
                    <th align="right">Password : </th>
                    <td><input type="password" name="Pass" placeholder="Pass"/></td>
                </tr>
                 <tr>
                    <th align="right">CV : </th>
                    <td><input type="file" name="Upload" placeholder="Upload Cv" /></td>
                 </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" name="submit" value="SignUp"/>
                    </td>
                </tr>
                 
                </table>
            </Form>
        
<script>
function validateForm() {
  var name = document.forms["regestration_form"]["username"].value;
  var email = document.forms["regestration_form"]["email"].value;
  var mobile = document.forms["regestration_form"]["mobile"].value;
  var password = document.forms["regestration_form"]["Pass"].value;
  
  if (name == "") {
    alert("username must be filled out");
    return false;
  }
  if (email == "") {
    alert("email must be filled out");
    return false;
  }
  if (mobile == "") {
    alert("mobile must be filled out");
    return false;
  }
  if (password == "") {
    alert("password must be filled out");
    return false;
  }
}
function checkExist(){
     var xmlhttp = new XMLHttpRequest();
     var username = document.forms["regestration_form"]["username"].value;
     var url = "profile.jsp?username=" + username;
     xmlhttp.onreadystatechange = function(){
     if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
     if(xmlhttp.responseText === "\n\n\n\n\nUser already exists")
     document.getElementById("isExist").style.color = "red";
     else
     document.getElementById("isExist").style.color = "green";
     document.getElementById("isExist").innerHTML = xmlhttp.responseText;
    }
                    
    };
    try{
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}
catch(e){
    alert("unable to connect to server");
}
}
</script>      
    </body>
</html>
